package api.stepDefinition;

import api.trellopojos.MyPojo;
import api.trellopojos.RequestPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class

C02_CreateBoardWithPoJosStepDef extends TestBaseApi {
    Response response;
    RequestPojo pojo;

    @Given("post request for creating board {string} with pojo")
    public void postRequestForCreatingBoardWithPojo(String boardName) {

        setUp();
        spec.pathParams("param1", 1, "param2", "boards");

        MyPojo pojo = new MyPojo(boardName, ConfigReader.getProperty("key"), ConfigReader.getProperty("token"));
        response = given().contentType("application/json").
                spec(spec).
                body(pojo)
                .when().post("/{param1}/{param2}");
        response.prettyPrint();

    }


    @Then("get response using pojo")
    public void getResponseUsingPojo() {
         pojo=response.as(RequestPojo.class);
        //json tipinde gelen kodlari java diline cevirir:deserilization
        System.out.println(pojo);
    }



    @And("assert response {string}")
    public void assertResponse(String boardName) {
        Assert.assertEquals(200,response.getStatusCode());
        //status kod herzaman responsadan alinir cunku body icinde gelmez
        Assert.assertEquals(boardName,pojo.getName());
        //response dan gelen pojom getname ile ulasiyorum

        System.out.println( pojo.getId());

    }
}
