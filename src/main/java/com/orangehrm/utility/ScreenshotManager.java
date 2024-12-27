package com.orangehrm.utility;

import com.orangehrm.common.WebdriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {
    public void captureScreenshot(){
        File srcFile = ((TakesScreenshot) WebdriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File dstFile = new File(System.getProperty("user.dir")+"/src/test/ScreenShots/test.png");

        try {
            FileUtils.copyFile(srcFile, dstFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getScreenShotWithBase64(){
        return  ((TakesScreenshot) WebdriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
