package ui.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.pages.AmazonElementPages;
import ui.utilities.Driver;
import ui.utilities.JSUtil;
import ui.utilities.Log;

import java.util.List;

public class US06DynamicSearchStepDef {

    AmazonElementPages pages = new AmazonElementPages();
    List<String> products;
    List<WebElement> allOptions;
    String priceSecond;
    String priceFirst;

    @Then("types any product")
    public void typesAnyProduct() {
        pages.searchTextBox.sendKeys("kettle");
        pages.searchSubmitBtn.click();
    }

    @And("adds second product and gets its price")
    public void addsSecondProductAndGetsItsPrice() {
            WebElement chosen = Driver.getDriver().findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).get(2);
            chosen.click();

        Log.info("2.elemente tiklandi");

         priceFirst=Driver.getDriver().findElement(By.xpath("//span[@data-a-color='price']")).getText();
        System.out.println(priceFirst);


    }

    @Then("checks prices in the shoppping cart")
    public void checksPricesInTheShopppingCart() {
        Driver.wait(2);
        pages.addToCartSbmtBtn.click();
        JSUtil.clickElementByJS(pages.noThanksBtn);
        priceSecond=Driver.getDriver().findElement(By.xpath("//span[@class='ewc-subtotal-amount']")).getText();
        System.out.println(priceSecond);

    }

    @And("Verify that both prices are same")
    public void verifyThatBothPricesAreSame() {
        Assert.assertEquals(priceFirst,priceSecond);
        Log.info("prices matched");
    }
}