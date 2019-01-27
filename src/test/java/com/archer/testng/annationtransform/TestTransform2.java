package com.archer.testng.annationtransform;

import org.testng.annotations.Test;

public class TestTransform2 {
    private String str;

    public TestTransform2(String str) {
        this.str = str;
    }

    @Test()
    public void test1() {
        System.out.println("Test annotationTransformer!");
        System.out.println("DataProviderName:" + str);
    }
}
