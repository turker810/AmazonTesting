package ui.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import ui.pages.AmazonElementPages;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;
import ui.utilities.JSUtil;
import ui.utilities.Log;

public class US07StepDef {

    AmazonElementPages pages=new AmazonElementPages();

    @Given("User navigates homepage")
    public void userNavigatesHomepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Log.info("url e gitti");
    }

    @Then("Scrolls down in homepage,")
    public void scrollsDownInHomepage() {

        JSUtil.scrollDownByJS();

    }


    @Then("Clicks on any links")
    public void clicksOnAnyLinks() {
        pages.downPageLink.click();
    }

    @And("Verifies that links works correctly")
    public void verifiesThatLinksWorksCorrectly() {
        String expectedText="Create a free account";
        String actualText=pages.amazonBusinessText.getText();
       // System.out.println(actualText);
        Assert.assertEquals("the link is clicked",expectedText,actualText);
        Log.info("link is clicked");
    }



}
