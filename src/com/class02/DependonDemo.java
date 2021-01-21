package com.class02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependonDemo {

    @Test(priority = 1)
    public void logIn(){
        System.out.println("I am login in");
        Assert.assertTrue(false);
        //This test will fail
    }

    @Test(dependsOnMethods = "logIn")
    public void addEmployee(){
        System.out.println("I am adding employee");
        //This test will be ignored because its depends on logIn test and it fail
    }

    @Test()
    public void test3(){
        System.out.println("I am test 3");
    }
}
