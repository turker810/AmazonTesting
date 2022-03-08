package api.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C01_CreateBoardStepDef extends TestBaseApi {

    Response response;
    JsonPath jsonPath;
    String createdBoardName;
    String readBoardName;
    String newBoardName;
    String deletedBoardId;


    @Given("Send POST request for create {string} board")
    public void send_post_request_for_create_board(String boardName) {

        //url tanımla
        //expected data-request data
        // request gönder
        //resposu al
        //assert et
        //CREATE
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "boards");

        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("name", boardName);
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token", ConfigReader.getProperty("token"));

        System.out.println(requestBody);

        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}");

        response.prettyPrint();
        jsonPath = response.jsonPath();
        createdBoardName=jsonPath.getString("name");
        System.out.println("board name is"+createdBoardName);

    }

    @Then("Assert status code {int}")
    public void assertStatusCode(int statusCode) {

        Assert.assertEquals(statusCode, response.getStatusCode());

    }

    @Then("Assert board name is {string}")
    public void assert_board_name_is(String boardName) {

        Assert.assertEquals(boardName, jsonPath.getString("name"));

    }
//read
    @Then("read the created board")
    public void readTheCreatedBaord() {
        //GET /1/boards/{id}
        setUp();
        spec.pathParams("para1",1,"para2","boards",
                "id",ConfigReader.getProperty("createdId")).
                queryParams("key",ConfigReader.getProperty("key"),"token",ConfigReader.getProperty("token"));

        response=given().spec(spec).contentType("application/json").
                when().get("{para1}/{para2}/{id}");
        response.prettyPrint();
    }

    @And("assert board is existed")
    public void assertBoardIsExisted() {
        Assert.assertEquals(readBoardName,createdBoardName);
    }
//update
    @Then("update the created board name")
    public void updateTheCreatedBoardName() {
        //PUT /1/boards/{id}

        setUp();
        spec.pathParams("para1",1,"para2","boards",
                "id",ConfigReader.getProperty("createdId")).
                queryParams("key",ConfigReader.getProperty("key"),"token",ConfigReader.getProperty("token"));

        Map<String,Object> updateboardName=new HashMap<>();
        updateboardName.put("name","esr");

        response=given().spec(spec).contentType("application/json").
                body(updateboardName).when().put("{para1}/{para2}/{id}");
        response.prettyPrint();
        jsonPath=response.jsonPath();
        newBoardName=jsonPath.getString("name");
        System.out.println("updated board name is "+newBoardName);


    }

    @And("assert board name is updated")
    public void assertBoardNameIsUpdated() {
        String expectedBoardName="esr";
        Assert.assertEquals(expectedBoardName,newBoardName);
    }
//DELETE
    @Then("delete the created board")
    public void deleteTheCreatedBoard() {
        //DELETE /1/boards/{id}
        setUp();
        spec.pathParams("para1",1,"para2","boards",
                "id",ConfigReader.getProperty("createdId")).
                queryParams("key",ConfigReader.getProperty("key"),"token",ConfigReader.getProperty("token"));

        response=given().spec(spec).contentType("application/json").
                when().delete("{para1}/{para2}/{id}");
        response.prettyPrint();
        jsonPath=response.jsonPath();
        deletedBoardId=jsonPath.getString("id");
        System.out.println("updated board value is "+deletedBoardId);

    }

    @And("assert board name is deleted")
    public void assertBoardNameIsDeleted() {
        Assert.assertEquals(deletedBoardId,null);
        System.out.println("board is deleted successfully");
    }


}
//{name=a, key=f8b3320467128ba1511e10fc8af85cf4, token=3eb5076a19cc4638e8a6355327ce78791f28793d4785d91e389b773381344afb}
//        {
//        "id": "6223895cac28eb796a82f77b",
//        "name": "a",
//        "desc": "",
//        "descData": null,
//        "closed": false,
//        "idOrganization": "621e4281dadd6362f2a7d0be",
//        "idEnterprise": null,
//        "pinned": false,
//        "url": "https://trello.com/b/dPT3X2MO/a",
//        "shortUrl": "https://trello.com/b/dPT3X2MO",
//        "prefs": {
//        "permissionLevel": "private",
//        "hideVotes": false,
//        "voting": "disabled",
//        "comments": "members",
//        "invitations": "members",
//        "selfJoin": true,
//        "cardCovers": true,
//        "isTemplate": false,
//        "cardAging": "regular",
//        "calendarFeedEnabled": false,
//        "hiddenPluginBoardButtons": [
//
//        ],
//        "background": "blue",
//        "backgroundColor": "#0079BF",
//        "backgroundImage": null,
//        "backgroundImageScaled": null,
//        "backgroundTile": false,
//        "backgroundBrightness": "dark",
//        "backgroundBottomColor": "#0079BF",
//        "backgroundTopColor": "#0079BF",
//        "canBePublic": true,
//        "canBeEnterprise": true,
//        "canBeOrg": true,
//        "canBePrivate": true,
//        "canInvite": true
//        },
//        "labelNames": {
//        "green": "",
//        "yellow": "",
//        "orange": "",
//        "red": "",
//        "purple": "",
//        "blue": "",
//        "sky": "",
//        "lime": "",
//        "pink": "",
//        "black": ""
//        },
//        "limits": {
//
//        }
//        }



