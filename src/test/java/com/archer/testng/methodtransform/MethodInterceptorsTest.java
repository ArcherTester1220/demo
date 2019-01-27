package com.archer.testng.methodtransform;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MethodInterceptors.class)
public class MethodInterceptorsTest {

    @BeforeClass
    public void bfClass() {
        System.out.println("BeforeClass");
    }

    @Test(groups = "grp1")
    public void test1() {
        System.out.println("test1");
    }

    @Test(groups = "grp2")
    public void test2() {
        System.out.println("test2");
    }

    @Test(groups = "grp2")
    public void test3() {
        System.out.println("test3");
    }

    @AfterClass
    public void afClass() {
        System.out.println("AfterClass");
    }

}
