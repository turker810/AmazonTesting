package ui.stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.pages.AmazonElementPages;
import ui.utilities.Driver;
import ui.utilities.Log;
import java.util.List;

public class US04StepDef {

    AmazonElementPages pages = new AmazonElementPages();

    @Given("Types anything on search box")
    public void types_anything_on_search_box() {
        pages.searchTextBox.sendKeys("Samsung");


    }

    @Then("Clicks on search button")
    public void clicks_on_search_button() {
        pages.searchSubmitBtn.click();
        Driver.wait(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,250)", "");



    }

    @Then("Verify that the results starts with what user types")
    public void verify_that_the_results_starts_with_what_user_types() {

        List<WebElement> searchResultList = Driver.getDriver().findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));

        for (int i = 0; i < searchResultList.size(); i++) {
              if (searchResultList.get(i).getText().startsWith("Samsung")) {
                  System.out.println(searchResultList.get(i).getText());
                  Assert.assertTrue(searchResultList.get(i).getText().contains("Samsung"));

                 }
        }
        System.out.println("arama kelimesi sonuclarda cikti");

        Log.info("aranan cumleler bulundu");
    }

    @Then("Types sameword multiple times on search box")
    public void typesSamewordMultipleTimesOnSearchBox() {

        pages.searchTextBox.sendKeys("Samsung Samsung");

    }


    @And("Verify that the results starts with containing the given text")
    public void verifyThatTheResultsStartsWithContainingTheGivenText() {
        List<WebElement> searchResultList = Driver.getDriver().findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));

        for (int i = 0; i < searchResultList.size(); i++) {
            if (searchResultList.get(i).getText().startsWith("Samsung")) {
                System.out.println(searchResultList.get(i).getText());
                Assert.assertTrue(searchResultList.get(i).getText().contains("Samsung"));

            }
        }

        Log.info("aranan cumleler bulundu");
    }
}