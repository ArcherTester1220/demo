package com.archer.testng;

import org.testng.annotations.*;

@Test(groups = "Tomandy")
public class TestNGHelloWorld {

    @BeforeSuite
    public void bfSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void bfTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void bfClass() {
        System.out.println("Before Class");
    }


    @BeforeGroups(groups = {"Tom"})
    public void bfGroups() {
        System.out.println("Before Groups");
    }

    @BeforeMethod(alwaysRun = true, dependsOnGroups = "bfSute")
    public void bfMethod() {
        System.out.println("Before Method");
    }

    @Test(groups = "Tom")
    public void helloWorld() {
        System.out.println("My First TestNG");
    }

    @AfterGroups
    public void afGroups() {
        System.out.println("After Groups");
    }

    @AfterTest
    public void afTest() {
        System.out.println("After Test");
    }

    @AfterClass
    public void afClass() {
        System.out.println("After Class");
    }

    @AfterSuite
    public void afSuite() {
        System.out.println("After Suite");
    }
}
