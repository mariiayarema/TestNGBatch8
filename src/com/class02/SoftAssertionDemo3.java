package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionDemo3 {
    //As an admin i should be able to login into HRMS
      //logo isDisplayed
       //user is successfully logged in

    WebDriver driver;

    @BeforeMethod
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void logoAndValidLogin() {
          //verifying that logo is displayed
        WebElement logoElement = driver.findElement(By.xpath("//img[contains(@src, 'syntax.png')]"));

        //creating an object of soft assertion
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(!logoElement.isDisplayed(),"Logo is not displayed");
       
          //entering valid credentials to login
        String username="Admin";
        driver.findElement(By.id("txtUsername")).sendKeys(username);


        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

          //validating that we are logged in
        WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        softAssert.assertTrue(!welcomeMessage.isDisplayed(),"Welcome message is not displayed");
        softAssert.assertEquals(welcomeMessage.getText(),"Welcome "+username);
        System.out.println("End of test case");

        //to see  any fail assertion we use assertAll() in the end of our test
        softAssert.assertAll();

    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}


