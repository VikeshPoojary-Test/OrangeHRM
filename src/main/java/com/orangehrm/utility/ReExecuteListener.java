package com.orangehrm.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReExecuteListener implements IRetryAnalyzer {
    int retryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        System.out.println("Test case:" + result.getName());
        if (retryCount < Integer.parseInt(PropertyReader.getConfigProperty("maxRetryCount").trim())) {
            retryCount++;
            return true;
        }
        return false;
    }
}
