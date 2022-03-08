package ui.stepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;
import ui.utilities.Log;

public class US01StepDef {

    @Given("User go to URL")
    public void user_go_to_URL() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Log.info("url e gitti");
    }

    @Given("Verify homepage opens successfully")
    public void verify_homepage_opens_successfully() {
       String actualURL= Driver.getDriver().getCurrentUrl();
        System.out.println(actualURL);
       String expectedURL="https://www.amazon.com/";
        Assert.assertEquals(expectedURL,actualURL);
        Log.info("url i verify etti");

    }



}
