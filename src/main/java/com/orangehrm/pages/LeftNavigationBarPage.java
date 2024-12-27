package com.orangehrm.pages;

import com.aventstack.extentreports.Status;
import com.orangehrm.BasePage;
import com.orangehrm.common.WebdriverManager;
import com.orangehrm.common.constant.LeftNavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

public class LeftNavigationBarPage extends BasePage {

    private final By navigationTabs = By.cssSelector(".oxd-sidepanel-body ul > li");

    public void navigateTo(LeftNavBar leftNavBar){
        click(By.linkText(leftNavBar.getValue()));
//        click(By.xpath(String.format("//p[text()='%s']",leftNavBar.getValue())));
    }

    public void verifyNavBar(LeftNavBar leftNavBar){
        List<WebElement> tabList = WebdriverManager.getDriver().findElements(navigationTabs);
        IntStream.range(0, tabList.size()).filter(i -> leftNavBar.getValue().equalsIgnoreCase(tabList.get(i).getText()))
                .forEach(i -> logReport(Status.PASS, "Tab present in Navigation bar", true));
    }
}
