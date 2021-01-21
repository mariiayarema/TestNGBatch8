package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.nio.channels.SelectableChannel;

public class Homework {
    WebDriver driver;

    @BeforeClass
    public void lunchBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        String url = "http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test()
    public void logInToApplication() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
    }


    @Test(dependsOnMethods = "logInToApplication")
    public void addingEmployeeVerification() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//b[text() = 'PIM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text() = 'Add Employee']")).click();
        Thread.sleep(2000);

        WebElement fullNameElement=driver.findElement(By.xpath("//label[text()='Full Name']"));
        WebElement employeeIdElement=driver.findElement(By.xpath("//label[text()='Employee Id']"));
        WebElement photographElement=driver.findElement(By.xpath("//label[text()='Photograph']"));


        Assert.assertTrue(fullNameElement.isDisplayed(),"Full Name is Displayed");
        Assert.assertTrue(employeeIdElement.isDisplayed(),"Employee id is Displayed");
        Assert.assertTrue(photographElement.isDisplayed(),"Photographer is Displayed");

    }

    @Test(dependsOnMethods = "addingEmployeeVerification")
    public void addEmployee() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        driver.findElement(By.id("firstName")).sendKeys("Ievgenii");
        Thread.sleep(2000);

        driver.findElement(By.id("lastName")).sendKeys("Markadanov");
        Thread.sleep(2000);
        WebElement photograph=driver.findElement(By.xpath("//label[text()='Photograph']"));
        Thread.sleep(2000);
        photograph.sendKeys("/Users/mariiayarema/Downloads/images.jpeg");
        Thread.sleep(2000);
    }

//        @AfterClass
//        public void closeBrowser() {
//            driver.quit();
//        }

}