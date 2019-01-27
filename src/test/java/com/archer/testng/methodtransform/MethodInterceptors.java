package com.archer.testng.methodtransform;

import com.google.common.collect.Lists;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodInterceptors implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<XmlClass> classes = context.getCurrentXmlTest().getXmlClasses();
        for (XmlClass xmlClass : classes) {
            System.out.println("执行类：" + xmlClass.getName());
        }
        List<IMethodInstance> result = Lists.newArrayList();
        for (IMethodInstance instance : methods) {
            ITestNGMethod method = instance.getMethod();
            Set<String> groups = new HashSet<String>();
            if (method.isTest()) { //如果是@Test注解
                for (String group : method.getGroups()) {
                    groups.add(group);  //获取@Test注解的所有组
                }
            }

            if (groups.contains("grp1"))  //只运行grp1组
                result.add(instance);

        }
        return result;
    }
}
