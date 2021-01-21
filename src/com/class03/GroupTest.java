package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class GroupTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class annotation");
    }
    @Test(groups="smoke")
    public void testMethod(){
        System.out.println("I am a test method");
    }
    @Test(groups="regression")
    public void testMethod2(){
        System.out.println("I am second test");
    }
    @Test(groups="smoke")
    public void testMethod3(){
        System.out.println("I am third test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class method");
    }
}
