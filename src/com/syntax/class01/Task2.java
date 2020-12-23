package com.syntax.class01;

import org.testng.annotations.*;

public class Task2 {
    @BeforeClass
    public void yearStart(){
        System.out.println("Its beginning of 2020");
    }
    @Test
    public void spring(){
        System.out.println("Its spring now");
    }
    @Test
    public void winter(){
        System.out.println("Its winter now");
    }
    @Test
    public void fall(){
        System.out.println("Its fall now");
    }
    @Test
    public void summer(){
        System.out.println("Its summer now");
    }
    @BeforeMethod
    public void whatSeason(){
        System.out.println("What seazon is now?");
    }
    @AfterMethod
    public void nextSeason(){
        System.out.println("Lets go to next season");
    }
    @AfterClass
    public void yearEnd(){
        System.out.println("Its the end of 2020");
    }
}
