package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    protected static WebDriver driver;

    /**
     * This method will open a browser ,set up configuration and navigate to url
     */
    @BeforeMethod(alwaysRun = true)
    public static void setUp() {
        ConfigsReader.readProperties("/Users/mariiayarema/eclipse-workspace/TestNG/src/configs/configuration.properties");
        switch (ConfigsReader.getPropertyValue("browser").toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }
        driver.get(ConfigsReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * This method will close open browser
     */
    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
      if(driver!=null){
          driver.quit();
      }
    }
}
