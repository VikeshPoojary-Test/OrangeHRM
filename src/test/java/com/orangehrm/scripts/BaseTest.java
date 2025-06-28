package com.orangehrm.scripts;

import com.orangehrm.common.WebdriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    /**
     * This method is executed before each test method.
     * It navigates to the specified URL and maximizes the browser window.
     */
    @BeforeMethod
    public void beforeMethod() {
        // Navigate to the specified URL
        WebDriver driver = WebdriverManager.createWebdriver();
        String url = WebdriverManager.getURL();
        driver.get(url);

        // Maximize the browser window
        WebdriverManager.getDriver().manage().window().maximize();
    }

    /**
     * This method is executed after each test method.
     * It closes the browser window after each test.
     */
    @AfterMethod
    public void afterMethod() {
        // Close the browser window
        WebdriverManager.getDriver().quit();
    }

}
