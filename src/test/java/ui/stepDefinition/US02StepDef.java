package ui.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ui.pages.AmazonElementPages;

import ui.utilities.Driver;

public class US02StepDef {
    AmazonElementPages pages=new AmazonElementPages();

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {

        Driver.getDriver().get(url);
    }

    @Then("User clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
       pages.amazonSignIn.click();
    }

    @Then("User types invalid credentials")
    public void user_types_invalid_credentials() {
      pages.emailText.click();
      pages.emailText.sendKeys("aliamazon@hotmail.com");
      pages.continueBtn.click();
      pages.passwordText.click();
      pages.passwordText.sendKeys("1234ally");

    }

    @When("User clicks on submit button")
    public void user_clicks_on_submit_button() {
        pages.signInSubmitBtn.click();
    }

    @When("User verifies that user can not sign in")
    public void user_verifies_that_nosign_in() {
        String actualErrorMsg=pages.invalidErrorMessage.getText();
        System.out.println("actual error message is "+actualErrorMsg);
        String expectedErrorMsg="Your password is incorrect";

        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);


    }


}
