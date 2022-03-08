package ui.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.pages.AmazonElementPages;
import ui.utilities.Driver;
import ui.utilities.JSUtil;
import ui.utilities.Log;
import ui.utilities.ReusableMethods;

import java.util.*;


public class US05StepDef {

    AmazonElementPages pages=new AmazonElementPages();
    String resultForSearch;
    String orderedResult;
    Integer[] intValues1;




    @Then("Types  on search box")
    public void typesOnSearchBox() {
        pages.searchTextBox.sendKeys("phone");
        pages.searchSubmitBtn.click();
    }

    @Then("Choose any filter option")
    public void chooseAnyFilterOption() {

        JSUtil.scrollInToViewJS(pages.filterBrandAppleOption);
        Actions action = new Actions(Driver.getDriver());
        action.doubleClick(pages.filterBrandAppleOption).perform();

        List<WebElement> priceLists = Driver.getDriver().findElements(By.xpath("//span[@class='a-price-whole']"));

        for (int i = 0; i < priceLists.size()-1; i++) {
             resultForSearch= priceLists.get(i).getText();
            System.out.println(resultForSearch);  //24 results
        }

        System.out.println("###########################################");
        Driver.wait(2);
        JSUtil.scrollInToViewJS(pages.sortByFeatured);
        pages.sortByFeatured.click();
        pages.lowToHighhOption.click();
        Driver.wait(2);
        List<WebElement> priceOrderedLists = Driver.getDriver().findElements(By.xpath("//span[@class='a-price-whole']"));
        for (int i = 0; i < priceLists.size()-1; i++) {
            orderedResult = priceOrderedLists.get(i).getText();
            System.out.println(orderedResult); //23
        }

    }
    @And("Verify that prices are matched")
    public void verifyThatPricesAreMatched() {
        Assert.assertFalse(resultForSearch.equalsIgnoreCase(orderedResult));
        Log.info("price did not match");
    }
}
