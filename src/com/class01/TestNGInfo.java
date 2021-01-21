package com.class01;

import org.testng.annotations.Test;

public class TestNGInfo {

    @Test
    public void hello() {
        System.out.println("Hello");
    }

    @Test
    public void sayBye() {
        System.out.println("Bye");
    }

    @Test
    public void anotherMethod() {
        System.out.println("How are you today");

        //annotation that mark your method as test
    }
}