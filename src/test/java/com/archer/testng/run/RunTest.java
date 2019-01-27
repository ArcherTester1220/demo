package com.archer.testng.run;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class RunTest {
    public static void main(String[] args) {

        XmlSuite suite = new XmlSuite();
        suite.setName("java run");
        XmlTest test = new XmlTest(suite);
        test.setName("java test");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("com.archer.testng.retryanalyzer.AnnationRetryAnalyzer"));
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);


        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();

    }
}
