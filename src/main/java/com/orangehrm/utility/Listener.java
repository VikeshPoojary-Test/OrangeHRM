package com.orangehrm.utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        ExtentReportManager.createTest(result.getName(),result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        ExtentReportManager.getTest().pass(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        ExtentReportManager.getTest().fail(result.getThrowable());
        System.out.println("Test Failed : " + result.getMethod().getMethodName());
        ScreenshotManager screenshotManager = new ScreenshotManager();
        ExtentReportManager.getTest().fail(result.getName(),
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotManager.getScreenShotWithBase64()).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        ExtentReportManager.getReport(context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        ExtentReportManager.flushReport();
    }
}
