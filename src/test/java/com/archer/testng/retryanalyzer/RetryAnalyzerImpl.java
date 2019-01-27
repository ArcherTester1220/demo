package com.archer.testng.retryanalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpl implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int matRetryCount = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < matRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
