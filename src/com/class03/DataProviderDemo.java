package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

@Test(dataProvider = "loginData",groups  ="regression")
public void multipleLogin(String username,String password) {
    driver.findElement(By.id("txtUsername")).sendKeys(username);
    driver.findElement(By.id("txtPassword")).sendKeys(password);
    driver.findElement(By.id("btnLogin")).click();
    WebElement welcomeMessage = driver.findElement(By.id("welcome"));
    Assert.assertTrue(welcomeMessage.isDisplayed(),"Welcome message is displayed");
    Assert.assertEquals(welcomeMessage.getText(),"Welcome "+username);
}

    //public-->protected-->default-->private

    //  We can give a name to Data Provider --> @DataProvider( name="DataProviderDemo");
    // If we are not giv name, by default Test method will accept method name -->@Test(dataProvider = "loginData")

    @DataProvider
        public Object[][] loginData(){

            Object[][] data=new Object [3][2];
            data[0][0]="Admin";
            data[0][1]="Hum@nhrm123";

            data[1][0]="James";
            data[1][1]="Syntax123!";

            data[2][0]="Burju";
            data[2][1]="Syntax123!";

        return data;
        }

    //We call it data driven testing

}