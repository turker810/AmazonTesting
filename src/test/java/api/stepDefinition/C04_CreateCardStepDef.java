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
   




