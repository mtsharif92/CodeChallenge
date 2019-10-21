package pages;

import base.MainAPI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CompleteShopping extends MainAPI {

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

    //CART ELEMENS
    @FindBy(xpath = "//i[@class='top-nav-tab-icon fa fa-shopping-cart']")
    WebElement cart;
    @FindBy(xpath = "//table[2]//tbody[1]//tr[1]//td[3]//div[2]//button[2]")
    WebElement remove;
    @FindBy(xpath = "//td[@class='grand-total']//span[@class='amount'][contains(text(),'$149.99')] ")
    WebElement totalCost;

    // Quantity Box Elements
    @FindBy(xpath = "//input[@id='ITEM.9SIA12KA163933.1.0.0']")
    WebElement quantityBox;
    @FindBy(xpath = "//td[@class='grand-total']//span[@class='amount'][contains(text(),'$599.96')]")
    WebElement adjustedCost;

    //Checkout Elements
    @FindBy(xpath = "//a[@class='button button-primary has-icon-right']")
    WebElement checkoutButton;
    @FindBy(xpath = "//div[@class='additional-info-groupbox']//a[1]")
    WebElement billing;

    //Log Out Elements
    @FindBy(xpath = "//a[@class='header-logo-img']//img")
    WebElement newEgglogo;
    @FindBy(xpath = "//ins[contains(text(),'My Account')]")
    WebElement myAccount;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;



    public void loginAccount (){
        login.click();
        email.sendKeys("ctschallenge18@gmail.com");
        password.sendKeys("Challenge18");
        signinbutton.click();

    }

    public void ItemsAddToTheCart() {

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

        // Verified INSTEON Thermostat (2441TH) is not found in the market Place

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("INSTEON Thermostat (2441TH) - Newegg.com"));
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().equals("We have found 0 items that match \"INSTEON Thermostat (2441TH)\"."));
        System.out.println("There is no such Item in this name");

    }

    public void removeItemFromCart(){

        cart.click();
        remove.click();
        // Validate amount after remove Items
        Assert.assertTrue(totalCost.getText().equals("$149.99"));
        System.out.println(totalCost.getText());
        System.out.println("Total Updated Cost is = $149.99");

    }
    public void updateQuantity(){

        quantityBox.sendKeys(Keys.BACK_SPACE);
        quantityBox.sendKeys("4");
        quantityBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(adjustedCost.getText().equals("$599.96"));
        System.out.println("Total Updated Cost is = $599.96");

    }
    public void checkout(){
        checkoutButton.click();
        billing.click();
        billing.getText();
        System.out.println(billing.getText());


    }

    public void logout(){
        newEgglogo.click();
        myAccount.click();
        logout.click();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals("Newegg.com - Newegg shopping upgraded ™"));

    }



}
