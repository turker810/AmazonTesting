package api.stepDefinition;

import api.trellopojos.MyPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C03_CreateListsStepDef extends TestBaseApi {
      Response response;
      JsonPath jsonPath;
      String  createdBoardName;
      String createdList;
      String updatedListName;

    @Given("user creates a board")
    public void user_creates_a_board() {
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "boards").
                queryParams("key",ConfigReader.getProperty("key"),"token",ConfigReader.getProperty("token"));
//istersen key ve token i query paramsa istersen map in altina yaz
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "esra");



        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{parametre1}/{parametre2}");

        response.prettyPrint();
        jsonPath = response.jsonPath();
        createdBoardName=jsonPath.getString("name");
        System.out.println("board name is "+createdBoardName);
    }
    @Then("from created board ,creates list name as {string}")
    public void from_created_board_creates_list_name_as(String bugList) {

     //POST /1/lists
        setUp();
        spec.pathParams("parametre1", 1, "parametre2", "lists");
        //burada key ve token i map ime yaziyorum 2 farkli yazilimi gormek icin



        HashMap<String, String> requestList = new HashMap<>();
        requestList.put("idBoard",ConfigReader.getProperty("idBoard"));
        requestList.put("name",bugList);//featuredan isim verdim
        requestList.put("key",ConfigReader.getProperty("key"));
        requestList.put("token",ConfigReader.getProperty("token"));
        response = given().
                spec(spec).
                contentType("application/json").
                body(requestList).
                when().
                post("/{parametre1}/{parametre2}");

        response.prettyPrint();
        jsonPath = response.jsonPath();
        createdList=jsonPath.getString("name");
        System.out.println("list name is "+createdList);

    }
    @Then("Assert status code for list is {int}")
    public void assert_status_code_for_list_is(Integer int1) {
        Assert.assertEquals(200,response.getStatusCode());
     //   Assert.assertEquals("bugList1",createdList);
        Assert.assertEquals(ConfigReader.getProperty("idBoard"),jsonPath.getString("idBoard"));


    }
    @Then("verifies list is created as {string}")
    public void verifies_list_is_created_as(String bugList1) {

        Assert.assertEquals(bugList1,createdList);
    }
    @Given("PUT request for update list")
    public void putRequestForUpdateList() {
        setUp();
        spec.pathParams("param1",1,"param2","lists",
                "param3",ConfigReader.getProperty("idList"));

      //  Map<String ,String>updateReq=new HashMap<>();
        //istersem map olustururum istersem key ve token olan pojomla yaparim
        MyPojo pojo=new MyPojo("updateListName",ConfigReader.getProperty("key"),ConfigReader.getProperty("token"));
        //name e manual olarak istedigim ismi veriyorum
        //3 parametre yazilacak cunku 3 parametre lazim
        response=given().contentType("application/json").
                spec(spec).body(pojo).
                when().put("{param1}/{param2}/{param3}");
        response.prettyPrint();
    }

    @Then("verify update response")
    public void verifyUpdateResponse() {
        jsonPath=response.jsonPath();
        updatedListName=jsonPath.getString("name");
        Assert.assertEquals("updateListName",updatedListName);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(ConfigReader.getProperty("idList"),jsonPath.getString("id"));
        Assert.assertEquals(ConfigReader.getProperty("idBoard"),jsonPath.getString("idBoard"));
    }


}
