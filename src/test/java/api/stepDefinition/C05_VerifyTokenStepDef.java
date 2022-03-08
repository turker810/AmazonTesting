package api.stepDefinition;

import api.trellopojos.MyPojo;
import api.trellopojos.RequestPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utilities.ConfigReader;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class C05_VerifyTokenStepDef extends TestBaseApi {



    Response response;
    JsonPath jsonPath;
    String readToken;
    MyPojo pojo;

    @Given("user gets token")
    public void user_gets_token() {
    setUp();
        //GET /1/tokens/{token}
    spec.pathParams("param1",1,"param2","tokens","token",ConfigReader.getProperty("token")).
            queryParam("key",ConfigReader.getProperty("key"));


        response=given().spec(spec).contentType("application/json").
                when().get("{param1}/{param2}/{token}");
        response.prettyPrint();

    }
    @And("verify token is {string}")
    public void verifyTokenIs(String readToken) {
        jsonPath=response.jsonPath();
        readToken= jsonPath.getString("identifier");
        System.out.println(readToken);
        Assert.assertEquals("Server Token",readToken);


    }
}
