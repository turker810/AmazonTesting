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

public class US06StepDef {
    AmazonElementPages pages=new AmazonElementPages();
    String pricewithoutCart;
    String priceInTheCart;
    int priceWith;
    int priceWithout;

    @Given("User navigates amazon webpage")
    public void userNavigatesAmazonWebpage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Log.info("url e gitti");
    }

    @Then("Choose products randomly")
    public void chooseProductsRandomly() {
        pages.searchTextBox.sendKeys("kettle");
        pages.searchSubmitBtn.click();
        JSUtil.scrollInToViewJS(pages.kettle1Option);
        pages.kettle1Option.click();

    }

    @And("Get prices what is added")
    public void getPricesWhatIsAdded() {
        Driver.waitForPageToLoad(3);
        JSUtil.scrollInToViewJS(pages.priceWithoutCart);
        Driver.wait(2);
        pricewithoutCart=pages.priceWithoutCart.getText();


        priceWithout=Integer.parseInt(pricewithoutCart.replaceAll("[\\D]", ""));
        System.out.println("the price before"+ priceWithout);

//        StringBuffer str = new StringBuffer(pricewithoutCart);
//        price=str.insert(3,'.').toString();
//        System.out.println("price is "+ price);

        Driver.waitForClickablility(pages.addToCartSbmtBtn,2);
         JSUtil.clickElementByJS(pages.addToCartSbmtBtn);
         Driver.waitForClickablility(pages.noThanksBtn,2);
         JSUtil.clickElementByJS(pages.noThanksBtn);

    }

    @Then("Get prices in the shoppping cart")
    public void getPricesInTheShopppingCart() {
        Driver.waitForPageToLoad(2);
        priceInTheCart=pages.priceWithCart.getText();
        priceWith=Integer.parseInt(priceInTheCart.replaceAll("[\\D]", ""));
        System.out.println("the price after "+priceWith);


    }

    @And("Verify that prices he got are same with shopping cart")
    public void verifyThatPricesHeGotAreSameWithShoppingCart() {
        Assert.assertEquals(priceWithout,priceWith);
        Log.info("prices matched");
    }


}
