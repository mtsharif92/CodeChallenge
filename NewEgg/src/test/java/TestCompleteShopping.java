import base.MainAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompleteShopping;

public class TestCompleteShopping extends MainAPI {

    CompleteShopping log;
    @BeforeMethod
    public void initialize() {
        log = PageFactory.initElements(driver, CompleteShopping.class);
    }


    @Test
    public void testLoginAccount() {
        log.loginAccount();
        System.out.println("Account CompleteShopping Successful");

    }
    @Test
    public void testSearchItem() {
        log.loginAccount();
        log.ItemsAddToTheCart();

    }
    @Test
    public void testRemoveItems(){
        log.loginAccount();
        log.ItemsAddToTheCart();
        log.removeItemFromCart();
    }


    // Complete Shopping test From Login To Logout

    @Test(priority = 1)
    public void textContinueToBilling(){
        log.loginAccount();
        log.ItemsAddToTheCart();
        log.removeItemFromCart();
        log.updateQuantity();
        log.checkout();
        log.logout();

    }
    @Test
    public void testLogout(){
        log.loginAccount();
        log.logout();
    }
}
