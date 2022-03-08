package api.stepDefinition;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import ui.utilities.ConfigReader;


public class TestBaseApi {

    protected RequestSpecification spec;

    Response response;


    public void setUp(){
        spec= new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com").build();
    }

}
