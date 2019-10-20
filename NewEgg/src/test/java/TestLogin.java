import base.MainAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;

public class TestLogin extends MainAPI {

    Login log;
    @BeforeMethod
    public void initialize() {
        log = PageFactory.initElements(driver, Login.class);
    }


    @Test
    public void testLoginAccount() {
        log.loginAccount();
        System.out.println("pages.Login Successful");

    }
    @Test
    public void testSearchItem() throws InterruptedException {
        log.loginAccount();
        log.ItemsAddToTheCart();
//        String actual = log.searchItem();
//        String expected = "Item has been added to cart.";
//        Assert.assertEquals (actual,expected);

    }
}
