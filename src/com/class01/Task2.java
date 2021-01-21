package com.class01;

import org.testng.annotations.*;

public class Task2 {
    @BeforeClass(alwaysRun = true)
    public void yearStart(){
        System.out.println("Its beginning of 2020");
    }
    @Test(groups = "smoke")
    public void spring(){
        System.out.println("Its spring now");
    }
    @Test(groups = "regression")
    public void winter(){
        System.out.println("Its winter now");
    }
    @Test(groups = "regression")
    public void fall(){
        System.out.println("Its fall now");
    }
    @Test(groups = "regression")
    public void summer(){
        System.out.println("Its summer now");
    }
    @BeforeMethod(alwaysRun = true)
    public void whatSeason(){
        System.out.println("What season is now?");
    }
    @AfterMethod(alwaysRun = true)
    public void nextSeason(){
        System.out.println("Lets go to next season");
    }
    @AfterClass(alwaysRun = true)
    public void yearEnd(){
        System.out.println("Its the end of 2020");
    }
}
