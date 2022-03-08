package ui.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import ui.pages.AmazonElementPages;
import ui.utilities.ConfigReader;
import ui.utilities.Driver;
import ui.utilities.JSUtil;
import ui.utilities.Log;

public class DemoStepDEF {

    AmazonElementPages pages=new AmazonElementPages();
    String price;
    String priceInTheCart;
    String addedCartText;
    String deletedItemText;


    @Given("user goes to Amazon WebPage {string}")
    public void userGoesToAmazonWebPage(String url) {
        Driver.getDriver().get(url);
        Log.info("url e gitti");
    }

    @Then("clicks on ALL menu and clicks {string}")
    public void clicksOnALLMenuAndClicks(String firetablets) {
        pages.allMenu.click();
        for (int i=0; i< pages.categoriMenu.size(); i++){
            if (pages.categoriMenu.get(i).getText().equals(firetablets)){
                pages.categoriMenu.get(i).click();
            }
        }
    }

    @Then("selects tablets such as {string}")
    public void selectsTabletsSuchAs(String fire7) {
        for (int i=0; i< pages.subCategoriMenu.size(); i++){
            if (pages.subCategoriMenu.get(i).getText().equals(fire7)){
                pages.subCategoriMenu.get(i).click();
            }
        }
    }

    @And("gets the price and clicks on add To Cart")
    public void getsThePriceAndClicksOnAddToCart() {
        Driver.waitForPageToLoad(2);
       price= pages.priceWithoutCart.getText();
        System.out.println("the price is "+price);
        Driver.waitForClickablility(Driver.getDriver().findElement(By.xpath("//input[@name='submit.add-to-cart']")),2);
        JSUtil.clickElementByJS(Driver.getDriver().findElement(By.xpath("//input[@name='submit.add-to-cart']")));
        Driver.waitForClickablility(Driver.getDriver().findElement(By.xpath("//span[@class='a-button a-button-base abb-intl-decline']")),2);
         JSUtil.clickElementByJS(Driver.getDriver().findElement(By.xpath("//span[@class='a-button a-button-base abb-intl-decline']")));
    }


    @Then("verifies item is added to cart")
    public void verifiesItemIsAddedToCart() {
        addedCartText=pages.addedToCartText.getText();
        System.out.println("message is "+ addedCartText);
    }

    @Then("gets the price in the cart")
    public void getsThePriceInTheCart() {
        priceInTheCart=pages.priceWithCart.getText();
        System.out.println("price after added in the cart is "+priceInTheCart);
    }

    @And("verifies prices are same")
    public void verifiesPricesAreSame() {
        Assert.assertEquals
                ((Integer.parseInt(price.replaceAll("[\\D]", ""))),(Integer.parseInt(priceInTheCart.replaceAll("[\\D]", ""))));
        System.out.println("prices matched");
    }

    @Then("user goes back to the card")
    public void userGoesBackToTheCard() {

        JSUtil.clickElementByJS(Driver.getDriver().findElement(By.xpath("//span[@id='nav-cart-count']")));
        
    }

    @And("delete added item")
    public void deleteAddedItem() {
        Driver.waitForPageToLoad(2);
       JSUtil.clickElementByJS(Driver.getDriver().findElement(By.xpath("//input[@value='Delete']")));

        
    }

    @And("verifies item is deleted")
    public void verifiesItemIsDeleted() {
        deletedItemText=Driver.getDriver().findElement(By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']")).getText();
        System.out.println("the message is "+ deletedItemText);
        Assert.assertEquals("Your Amazon Cart is empty.",deletedItemText);
    }
}

