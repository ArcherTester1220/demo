package com.archer.testng.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "test")
public class AnnotationTest {
    @BeforeClass
    public void bfClass() {
        System.out.println("介绍@Test标签");
    }

    @Test(description = "description 在测试报告中显示", groups = {"test1", "test2"})
    public String annationTest() {
        System.out.println(AnnotationTest.class.getName() + ":annationTest");
        Assert.assertEquals(1, 1);
        return "@Test annationTest";
    }

    @Test(description = "description 在测试报告中显示", groups = {"test3"}, dependsOnGroups = {"test1"})
    public String annationTestGroup() {
        System.out.println(AnnotationTest.class.getName() + ":annationTestGroup");
        return "@Test annationTestGroup";
    }

    @Test(invocationTimeOut = 4000, invocationCount = 5, threadPoolSize = 2)
    public String annationTestInvocation() {
        System.out.println(AnnotationTest.class.getName() + ":annationTestInvocation");
        return "@Test annationTestInvocation";
    }


    @Test(successPercentage = 9, invocationCount = 10)
    public String annationTestSuccessPercentage() {
        Assert.assertEquals(1, 1);
        System.out.println(AnnotationTest.class.getName() + ":annationTestSuccessPercentage");
        return "@Test annationTestSuccessPercentage";
    }

    @Test(timeOut = 5000)
    public String annationTesttimeOut() {
        System.out.println(AnnotationTest.class.getName() + ":annationTesttimeOut");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {

        }
        return "@Test annationTesttimeOut";
    }

    @Test(alwaysRun = true)
    public String annationTestalwAysRun() {
        System.out.println(AnnotationTest.class.getName() + ":annationTestalwAysRun");
        return "@Test annationTestalwAysRun";
    }

    @AfterClass
    public void afClass() {
        System.out.println("即使异常，也会执行，Finsh");
    }
}
