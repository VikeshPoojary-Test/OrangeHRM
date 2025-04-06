package com.orangehrm;

import com.aventstack.extentreports.Status;
import com.orangehrm.common.WebdriverManager;
import com.orangehrm.utility.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BasePage extends ExtentReportManager {

    protected WebDriverWait webDriverWait;

    public BasePage() {
        webDriverWait = new WebDriverWait(WebdriverManager.getDriver(), Duration.ofSeconds(20));
    }


    /**
     * Clicks on the web element located by the specified locator.
     *
     * @param locator the By locator to find the web element to be clicked
     */
    public void click(By locator) {
        waitAndGetElement(locator).click();
    }

    /**
     * Clicks on the provided web element.
     *
     * @param webElement the web element to be clicked
     */
    public void click(WebElement webElement) {
        // Click on the provided web element
        webElement.click();
    }

    public void passValue(By locator, String value) {
        waitAndGetElement(locator).sendKeys(value);
    }

    public void selectFromDropdown(By locator, String name) {
        Select select = new Select(WebdriverManager.getDriver().findElement(locator));
        select.selectByVisibleText(name);
    }

    public String getValue(By locator) {
        return waitAndGetElement(locator).getText();
    }

    public void clearField(By locator){
        waitAndGetElement(locator).sendKeys(Keys.CONTROL+"a");
        waitAndGetElement(locator).sendKeys(Keys.DELETE);
    }

    public void isSelected(By locator){
        waitAndGetElement(locator).isSelected();
    }

    public void switchDriverToNewWindow(String title) {
        Set<String> windowHandles = WebdriverManager.getDriver().getWindowHandles();
        for (String s : windowHandles) {
            WebdriverManager.getDriver().switchTo().window(s);
            String currentTitle = WebdriverManager.getDriver().getTitle();
            if (currentTitle != null && title.contains(currentTitle)) {
                break;
            }
        }
    }

    public List<String> splitString(String seperator, By locator) {
        return Arrays.stream(getValue(locator).split(seperator)).map(String::trim).collect(Collectors.toList());
    }

    public List<WebElement> locateElements(By locator) {
        return WebdriverManager.getDriver().findElements(locator);
    }

    public WebElement locateElement(By locator) {
        return WebdriverManager.getDriver().findElement(locator);
    }

    public void getValueFromWebElementList_Dropdown(By webElement, String value) {
        List<WebElement> webElement_List = getElements(webElement);
        webElement_List.stream().filter(element -> element.getText().equalsIgnoreCase(value))
                .findFirst().ifPresent(WebElement::click);
    }

    public WebElement getElement(By locator) {
        return WebdriverManager.getDriver().findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return WebdriverManager.getDriver().findElements(locator);
    }

    public WebElement waitAndGetElement(By locator) {
        webDriverWait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.visibilityOfElementLocated(locator)));
        return getElement(locator);
    }

    public List<WebElement> waitAndGetAllElements(By locator) {
        webDriverWait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator)
                , ExpectedConditions.presenceOfAllElementsLocatedBy(locator)));
        return getElements(locator);

    }

    public boolean waitTillMultipleElementLoad(By locator) {
        WebDriver driver = WebdriverManager.getDriver();
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(30));
        return fluentWait.until(args -> {
            try {
                return WebdriverManager.getDriver().findElements(locator).size() > 1;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public boolean waitTillElementLoad(By locator) {
        WebDriver driver = WebdriverManager.getDriver();
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(30));
        return fluentWait.until(args -> {
            try {
                return WebdriverManager.getDriver().findElements(locator).size() >= 1;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void moveToElementAndCLick(By locator){
        Actions action = new Actions(WebdriverManager.getDriver());
        action.moveToElement(waitAndGetElement(locator)).click().build().perform();

    }

    public void selectFirst_DataFromAutoSuggestiveField(By fieldLocator, By suggestionsList, String searchItem){
        passValue(fieldLocator, searchItem);
        waitTillMultipleElementLoad(suggestionsList);
        waitAndGetAllElements(suggestionsList).getFirst().click();
    }

    public void selectDataFromAutoSuggestiveField(By fieldLocator, By suggestionsList, String searchItem){
        passValue(fieldLocator, searchItem);
        waitTillMultipleElementLoad(suggestionsList);
        List<WebElement> list = waitAndGetAllElements(suggestionsList);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equalsIgnoreCase(searchItem)){
                click(list.get(i));
            } else {
                logReport(Status.FAIL,"Unable to find the data in suggestions", true);
            }
        }
    }

    public void getValueFromDivDropDown(By divDropdown, By dropdownValue, String selectValue){
        click(divDropdown);
        getValueFromWebElementList_Dropdown(dropdownValue, selectValue);
    }

}