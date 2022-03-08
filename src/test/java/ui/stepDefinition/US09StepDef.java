package ui.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.AmazonElementPages;
import ui.utilities.Driver;
import ui.utilities.Log;

public class US09StepDef {

    AmazonElementPages pages=new AmazonElementPages();

    @Given("User navigates to wish list link {string}")
    public void userNavigatesToWishListLink(String url) {
        Driver.getDriver().get(url);
    }

    @Then("Clicks on wish list")
    public void clicksOnWishList() {
        pages.wishList.click();
        WebElement switchedList=Driver.getDriver().findElement(By.xpath("//img[@alt='Switch to list view']"));
        switchedList.click();
        Driver.wait(2);
    }

    @And("verifies that items exist in the wish list")
    public void verifiesThatItemsExistInTheWishList() {
        String items=pages.firstItemInwishList.getText()+" , "+pages.secondItemInwishList.getText();
        System.out.println(items);
        String expectedItems="Kalorik Red High Heat Stone Pizza Oven , Philips Kitchen Appliances EP4321/54 Espresso Machine, One Size, Black";
        Assert.assertEquals(expectedItems,items);
        Log.info("items are seen in the wish list");
    }
}
