package com.orangehrm;

import com.orangehrm.common.WebdriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BasePage {
    @BeforeMethod
    public void beforeMethod(){
        WebdriverManager.getURL();
        WebdriverManager.getDriver().manage().window().maximize();
    }

//    @AfterMethod
//    public void afterMethod(){
//        WebdriverManager.getDriver().quit();
//    }
}
