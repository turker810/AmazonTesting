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

public class US08StepDef {
    AmazonElementPages pages=new AmazonElementPages();
    @Given("User navigates to given URL")
    public void userNavigatesToGivenURL() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Log.info("url e gitti");
    }


    @Then("added any item")
    public void addedSomeItems() {
        pages.shoppingCartSelectionItem.click();
        JSUtil.scrollInToViewJS(pages.shoppingCartSelectDropDown);
        pages.shoppingCartSelectDropDown.click();
        pages.shoppingCartSize.click();
        Driver.wait(2);
        JSUtil.scrollInToViewJS(pages.shoppingCartAddToCart);
        pages.shoppingCartAddToCart.click();

    }

    @And("verifies the item is added")
    public void verifiesTheItemIsAdded() {
        String actualText=pages.addedToCartText.getText();
        System.out.println(actualText);
        String expectedText="Added to Cart";
        Assert.assertEquals(expectedText,actualText);
        Log.info("item is in the shopping cart");
    }

    @Then("removed item")
    public void removedItem() {
        Driver.wait(2);
        JSUtil.clickElementByJS(pages.cartChecking);
        Driver.wait(2);
        JSUtil.clickElementByJS(pages.deleteItem);

    }

    @And("verifies that item is removed")
    public void verifiesThatItemIsRemoved() {
        Driver.waitForPageToLoad(3);
        String expectedText="Your Amazon Cart is empty.";
        String actualText=pages.cartEmptyText.getText();
        System.out.println(actualText);
        Assert.assertEquals(expectedText,actualText);
        Log.info("item is in the shopping cart deleted");
    }



//was removed from Shopping Cart.
}
