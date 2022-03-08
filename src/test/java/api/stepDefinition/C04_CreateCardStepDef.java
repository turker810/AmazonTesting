package api.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C04_CreateCardStepDef extends TestBaseApi {
    Response response;
    JsonPath jsonPath;
    String createdCardName;

    @Given("creates card {string}")
    public void creates_card(String cardName) {
//POST /1/cards
        setUp();
        spec.pathParams("param1", 1, "param2", "cards");
        HashMap<String, String> createCard = new HashMap<>();
        createCard.put("idList", ConfigReader.getProperty("idList"));
        createCard.put("name", cardName);//featuredan isim verdim
        createCard.put("key", ConfigReader.getProperty("key"));
        createCard.put("token", ConfigReader.getProperty("token"));

        response = given().
                spec(spec).
                contentType("application/json").
                body(createCard).
                when().
                post("/{param1}/{param2}");
        response.prettyPrint();
    }

    @Given("verifies card is created")
    public void verifies_card_is_created() {
        jsonPath = response.jsonPath();
        createdCardName = jsonPath.getString("name");
        Assert.assertEquals("this is my first card with API", createdCardName);

    }
}
//    {
//        "attachments": [
//
//    ],
//        "id": "6226c97ec5c56c0f73ef58bb",
//            "badges": {
//        "attachmentsByType": {
//            "trello": {
//                "board": 0,
//                        "card": 0
//            }
//        },
//        "location": false,
//                "votes": 0,
//                "viewingMemberVoted": false,
//                "subscribed": false,
//                "fogbugz": "",
//                "checkItems": 0,
//                "checkItemsChecked": 0,
//                "checkItemsEarliestDue": null,
//                "comments": 0,
//                "attachments": 0,
//                "description": false,
//                "due": null,
//                "dueComplete": false,
//                "start": null
//    },
//        "checkItemStates": [
//
//    ],
//        "closed": false,
//            "dueComplete": false,
//            "dateLastActivity": "2022-03-08T03:11:58.789Z",
//            "desc": "",
//            "descData": {
//        "emoji": {
//
//        }
//    },
//        "due": null,
//            "dueReminder": null,
//            "email": null,
//            "idBoard": "6226b99d6e690c0a0e0e1a3d",
//            "idChecklists": [
//
//    ],
//        "idList": "6226c0925af7343cd1d437a3",
//            "idMembers": [
//
//    ],
//        "idMembersVoted": [
//
//    ],
//        "idShort": 1,
//            "idAttachmentCover": null,
//            "labels": [
//
//    ],
//        "idLabels": [
//
//    ],
//        "manualCoverAttachment": false,
//            "name": "this is my first card with API",
//            "pos": 16384,
//            "shortLink": "9dgVwZLq",
//            "shortUrl": "https://trello.com/c/9dgVwZLq",
//            "start": null,
//            "subscribed": false,
//            "url": "https://trello.com/c/9dgVwZLq/1-this-is-my-first-card-with-api",
//            "cover": {
//        "idAttachment": null,
//                "color": null,
//                "idUploadedBackground": null,
//                "size": "normal",
//                "brightness": "dark",
//                "idPlugin": null
//    },
//        "isTemplate": false,
//            "cardRole": null,
//            "stickers": [
//
//    ],
//        "limits": {
//
//    }
 //   }




