package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class HW {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openBrowserAndUrl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        String url = "http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        //WebDriver menu=driver.findElement(By.id("menu_pim_addEmployee")).click();
        //JavascriptExecutor js=(JavascriptExecutor)driver;
        // js.executeScript("arguments[0].click();",menu);
        //menu.click()
        Thread.sleep(2000);
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

    @Test(dataProvider = "newEmployeeData", groups = "homework")
    public void addNewEmployee(String firstName, String lastName, String userName, String password) throws InterruptedException {

        driver.findElement(By.id("menu_pim_addEmployee")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        Thread.sleep(3000);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        Thread.sleep(3000);
        driver.findElement(By.id("chkLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("user_name")).sendKeys(userName);
        Thread.sleep(3000);
        driver.findElement(By.id("user_password")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.id("re_password")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.id("btnSave")).click();


    }



    @DataProvider
    public Object[][] newEmployeeData() {

        Object[][] employeeData = {
                {"Mariia", "Yarema", "MariiaYarema", "Mariia123!@#Y"},
                {"Ievgenii", "Markadanov", "IevgeniiMarkadanov", "Ievgenii123!@#M"},
                {"Olena", "Bogdan", "OlenaBogdan", "Olena123!@#B"},
                {"Sofiia", "Hrustay", "SofiiaHrustay", "Sofiia123!@#H"},
                {"Viktor", "Hnativ", "ViktorHnativ", "Viktor123!@#H"}
        };


        return employeeData;
    }


}
