package com.archer.testng.annationtransform;

import org.testng.IAnnotationTransformer3;
import org.testng.annotations.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnationTestTransform3 implements IAnnotationTransformer3 {
    @Override
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    }

    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
        if (annotation.getName().equals("tom"))  //匹配名为data的DataProvider
            annotation.setParallel(true); //设置并行
    }

    @Override
    public void transform(IFactoryAnnotation annotation, Method method) {
        System.out.println("注入DataProvider:" + annotation.getDataProvider());
//        annotation.setDataProvider("data");
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setInvocationCount(2);//2 times
        System.out.println("执行方法：" + testMethod.getName());
        System.out.println();
    }

    @Override
    public void transform(IListenersAnnotation annotation, Class testClass) {

    }
}
