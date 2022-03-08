package ui.stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ui.pages.AmazonElementPages;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;
import ui.utilities.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US03StepDef {
    AmazonElementPages pages=new AmazonElementPages();
    String allElements;
    List<WebElement> allOptions;

    @When("User navigates to homepage")
    public void user_navigates_to_homepage() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("User clicks on ALL section")
    public void user_clicks_on_ALL_section() {
        pages.allMenu.click();
        Log.info("All butonuna tıklandı");

    }

//    @Then("Verify that all elements are seen")
//    public void verify_that_all_elements_are_seen() {
//        // identify div elements with same class
//        allOptions = Driver.getDriver().findElements(By.className("hmenu-item"));
//
//        // list iteration
//        System.out.println("Elements are: ");
//        for (int j = 0; j < allOptions.size(); j++) {
//            //identify separate div
//            allElements = allOptions.get(j).getText();
//            System.out.println(allElements);
//        }
//        Log.info("All menusundeki butun elementler alindi");
//    }
    @And("User chooses one of them such as {string}")
    public void userChoosesOneOfThemSuchAs(String categori) {
        for (int i=0; i< pages.categoriMenu.size(); i++){
            if (pages.categoriMenu.get(i).getText().equals(categori)){
                pages.categoriMenu.get(i).click();
            }
        }
        Log.info("electronics is selected");



    }

       
    @Then("user verifies that there are {int} subcategories")
    public void userVerifiesThatThereAreSubcategories(int numOfsubElements) {
        Assert.assertEquals(pages.subCategoriMenu.size()-1,numOfsubElements);
        Log.info ("alt katogorilerin kaç tane olduğu doğrulandı");
    }


    @And("user verifies the title of all subcategories")
    public void userVerifiesTheTitleOfAllSubcategories() {
        List<String> expectedSubMenu= Arrays.asList(
                "TV & Video",
                "Home Audio & Theater",
                "Camera, Photo & Video",
                "Cell Phones & Accessories",
                "Headphones",
                "Video Games",
                "Bluetooth & Wireless Speakers",
                "Car Electronics",
                "Musical Instruments",
                "Wearable Technology",
                "Electronics",
                "Amazon Renewed"
               );

        List<String>actualSubMenu=new ArrayList<>();
        for (int i=0; i< pages.subCategoriMenu.size(); i++){
            actualSubMenu.add(pages.subCategoriMenu.get(i).getText());
        }

        Assert.assertTrue(actualSubMenu.containsAll(expectedSubMenu));
        Log.info("beklenen tüm alt kategorilerin olduğu doğrulandı");
        Log.endTestCase("all menu testi");

    }


}


