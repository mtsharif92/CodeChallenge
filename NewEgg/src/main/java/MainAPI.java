import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class MainAPI {

    public static WebDriver driver = null;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mdths\\IdeaProjects\\CognigentCodeChallenge\\NewEgg\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.newegg.com/");
        // driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void cleanUp(){
        driver.close();
    }



}
