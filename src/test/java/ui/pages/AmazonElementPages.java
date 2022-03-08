package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.utilities.Driver;

import java.util.List;

public class AmazonElementPages {

    public AmazonElementPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   //us02
    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement amazonSignIn;

    @FindBy(id = "ap_email")
    public WebElement emailText;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "ap_password")
    public WebElement passwordText;

    @FindBy(id = "signInSubmit")
    public WebElement signInSubmitBtn;

    @FindBy (xpath = "//*[@class='a-list-item']")
    public WebElement invalidErrorMessage;

    //us03
    @FindBy(xpath = "//*[@class='hm-icon-label']")
    public WebElement allMenu;
    @FindBy(className = "a-button-input")
    public WebElement continueButton;

    @FindBy(id = "auth-error-message-box")
    public WebElement errorMessage;

    @FindBy(id = "nav-hamburger-menu")
    public WebElement allButton;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']//a")
    public List<WebElement> categoriMenu;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//a")
    public List<WebElement> subCategoriMenu;

    //us04
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(xpath ="(//input[@type='submit'])[1]")
    public WebElement searchSubmitBtn;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public WebElement searchResults;
    //us05
    @FindBy(xpath ="//span[text()='Featured']")
    public WebElement sortByFeatured;

    @FindBy(xpath ="//a[text()='Price: Low to High']")
    public WebElement lowToHighhOption;

    @FindBy(xpath ="//span[text()='Apple']")
    public WebElement filterBrandAppleOption;

    //us06
    @FindBy(xpath ="//span[text()='Glass Hot Water Kettle Electric for Tea and Coffee 1.7 Liter Fast Boiling Electric Kettle Cordless Water Boiler with Auto Shutoff & Boil Dry Protection Taylor Swoden']")
    public WebElement kettle1Option;

    @FindBy(xpath ="//span[@class='a-price aok-align-center reinventPricePriceToPayPadding priceToPay']")
    public WebElement priceWithoutCart;

    @FindBy(xpath ="//input[@id='add-to-cart-button']")
    public WebElement addToCartSbmtBtn;

    @FindBy(xpath ="(//span[text()=' No Thanks '])[1]")
    public WebElement noThanksBtn;

    @FindBy(xpath ="//span[@class='a-size-base a-color-base sc-price sc-white-space-nowrap sw-subtotal-amount a-text-bold']")
    public WebElement priceWithCart;



    //us07
    @FindBy(xpath ="//*[text()='Amazon Business']")
    public WebElement downPageLink;

    @FindBy(xpath ="(//a[@data-primary-create-btn='Create a free account'])[1]")
    public WebElement amazonBusinessText;

    //us08
    @FindBy(xpath ="//span[text()='Liengoron Women Fla…']")
    public WebElement shoppingCartSelectionItem;

    @FindBy(xpath ="(//span[@class='a-dropdown-prompt'])[1]")
    public WebElement shoppingCartSelectDropDown;

    @FindBy(xpath ="//a[@id='native_dropdown_selected_size_name_2']")
    public WebElement shoppingCartSize;

    @FindBy(xpath ="//input[@id='add-to-cart-button']")
    public WebElement shoppingCartAddToCart;

    @FindBy(xpath =" //*[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    public WebElement addedToCartText;

    @FindBy(xpath ="//span[@id='nav-cart-count']")
    public WebElement cartChecking;

    @FindBy(xpath ="(//input[@type='submit'])[4]")
    public WebElement deleteItem;

    @FindBy(xpath ="//h1[@class='a-spacing-mini a-spacing-top-base']")
    public WebElement cartEmptyText;

    //us09
    @FindBy(xpath ="//span[@id='left-nav-rid_2RWXGX3Q2D6AB']")
    public WebElement wishList;

    @FindBy(xpath ="//a[@id='itemName_I27TU7WZ0CYZ90']")
    public WebElement firstItemInwishList;

    @FindBy(xpath ="//a[@id='itemName_I36SBRKUHGX07J']")
    public WebElement secondItemInwishList;



















}
