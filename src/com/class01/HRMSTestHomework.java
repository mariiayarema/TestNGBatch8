package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class HRMSTestHomework {
    WebDriver driver;

    @BeforeMethod
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void validAdminLogin() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        if (welcomeMessage.isDisplayed()) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail");
        }
    }

    @Test
    public void titleValidation() {
        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title is valid. Test Pass.");
        } else {
            System.out.println("Title is not matched.Test Failed");
        }

    }

    @Test
    public void logoValidation() {
        WebElement logoElement = driver.findElement(By.xpath("//img[contains(@src, 'syntax.png')]"));
        if (logoElement.isDisplayed()) {
            System.out.println("Logo is Displayed.Test Pass");
        } else {
            System.out.println("Logo isn't Displayed.Test Fail");
        }
    }

    @Test
    public void invalidCredentials() {
        driver.findElement(By.id("txtUsername")).sendKeys("Syntax");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("btnLogin")).click();
        WebElement errorMessage = driver.findElement(By.id("spanMessage"));
        String errorText = errorMessage.getText();
        if (errorMessage.isDisplayed() && errorText.equals("Invalid credentials")) {
            System.out.println("Error message “Invalid credentials” is displayed when user enters invalid credentials.Test Pass");
        } else {
            System.out.println("Error message “Invalid credentials” isn't displayed when user enters invalid credentials.Test Fail");
        }
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

