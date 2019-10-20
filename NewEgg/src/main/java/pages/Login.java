package pages;

import base.MainAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login extends MainAPI {

    @FindBy(xpath = "//a[@class='top-nav-tab-name logout']")
    WebElement login;
    @FindBy(xpath = "//input[@id='UserName']")
    WebElement email;
    @FindBy(xpath = "//input[@id='UserPwd']")
    WebElement password;
    @FindBy(xpath = "//button[@id='submitLogin']")
    WebElement signinbutton;

    //Search Elements
    @FindBy(xpath = "//input[@id='haQuickSearchBox']")
    WebElement searchbox;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-mini search-bar-btn']")
    WebElement clickSearchButton;

    //Micro SD Card Elements
    @FindBy(partialLinkText = "SanDisk 512GB Extreme microSDXC UHS-I/U3 A2 Memory Card with Adapter, Speed Up to 160MB/s (SDSQXA1-512G-GN6MA)")
    WebElement sandisk149;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-wide']")
    WebElement addToCart;
    @FindBy(xpath = "//div[@id='custom']//a[@class='fa fa-close centerPopup-close button-decline']")
    WebElement closePopUp;
    @FindBy(xpath = "//span[@class='message-title']")
    WebElement cartMessage;

    // THE LOST LEGACY ELEMENTS
    @FindBy(xpath = "//button[@class='btn']")
    WebElement continueShopping;
    @FindBy(xpath = "//a[contains(text(),'UNCHARTED: The Lost Legacy - PlayStation 4')]")
    WebElement theLostLegacy;

    // INSTEON Thermostat (2441TH) Elements
    @FindBy(xpath = "//span[@class='result-message-error']")
    WebElement errorMessage;


    public void loginAccount (){
        login.click();
        email.sendKeys("ctschallenge18@gmail.com");
        password.sendKeys("Challenge18");
        signinbutton.click();

    }

    public void ItemsAddToTheCart() throws InterruptedException {

        searchbox.sendKeys("Micro SD Card");
        clickSearchButton.click();
        Actions action = new Actions(driver);
        action.contextClick(sandisk149).perform();
        sandisk149.click();
        addToCart.click();
        closePopUp.click();
        Assert.assertTrue(cartMessage.getText().equals("ITEM HAS BEEN ADDED TO CART."));
        System.out.println("Micro SD Card Has Been Added To The Cart");



        // ADD Uncharted: The Lost Legacy on Cart
        continueShopping.click();
        searchbox.sendKeys("Uncharted: The Lost Legacy");
        clickSearchButton.click();
        theLostLegacy.click();
        addToCart.click();
        Assert.assertTrue(cartMessage.getText().equals("ITEM HAS BEEN ADDED TO CART."));
        System.out.println("Uncharted: The Lost Legacy Has Been Added To The Cart.");


        // ADD INSTEON Thermostat (2441TH) TO THE CART

        continueShopping.click();
        searchbox.sendKeys("INSTEON Thermostat (2441TH)");
        clickSearchButton.click();
        Assert.assertTrue(driver.getTitle().equals("INSTEON Thermostat (2441TH) - Newegg.com"));
        System.out.println(driver.getTitle());
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().equals("We have found 0 items that match \"INSTEON Thermostat (2441TH)\"."));






    }



}
