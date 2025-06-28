package com.orangehrm.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    static ExtentReports extentReports;
    static String extentReportName = null;

    public static ExtentReports getReport(String testCaseName) {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            setupExtentReport(testCaseName);
        }
        return extentReports;
    }

    public static ExtentReports setupExtentReport(String testCaseName) {
        String reportPath = System.getProperty("user.dir") + "/target/results";

        String filePath =reportPath+File.separator + setExtentReportName() + ".html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Vikesh S D");

        reporter.config().setReportName(testCaseName);
        reporter.config().setTheme(Theme.DARK);

        return extentReports;
    }

    public static String setExtentReportName() {
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        extentReportName = "OrangrHRM" + "_" + date;
        return extentReportName;
    }

    public synchronized static ExtentTest getTest() {
        return extentTest.get();
    }

    public synchronized static ExtentTest createTest(String name, String description) {
        ExtentTest test = extentReports.createTest(name, description);
        extentTest.set(test);
        return getTest();
    }


    public synchronized static void logReport(Status status, String message, boolean takeScreenshot) {
        if (takeScreenshot) {
            ScreenshotManager screenshotManager = new ScreenshotManager();
            getTest().log(status, message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotManager.getScreenShotWithBase64()).build());
        } else {
            getTest().log(status, message);
            message = message.replace("<span onclick=\"$(this).next().toggle();\">Show/Hide Stacktrace</span><p>style=" +
                    "\"displays: none;\">", "");
        }
    }

    public static void flushReport() {
        extentReports.flush();
    }
}

