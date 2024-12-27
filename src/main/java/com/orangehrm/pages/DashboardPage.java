package com.orangehrm.pages;

import com.orangehrm.BasePage;
import com.orangehrm.common.WebdriverManager;
import com.orangehrm.common.constant.DashboardWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

public class DashboardPage extends BasePage {
    private final By dashBoardWidget = By.cssSelector("div > .orangehrm-dashboard-widget.oxd-sheet");
    private final By widgetName = By.cssSelector(".orangehrm-dashboard-widget-name> .oxd-text.oxd-text--p");
    private final By myAction_Tabs = By.cssSelector(".orangehrm-todo-list-item");
    private final By quickLaunch_Tabs = By.cssSelector(".orangehrm-quick-launch-icon");

    List<WebElement> widget_List = locateElements(dashBoardWidget);
    List<WebElement> widgetName_List = locateElements(widgetName);
    List<WebElement> MyActionTabs_List = locateElements(myAction_Tabs);
    List<WebElement> quickLaunchTabs_List = locateElements(quickLaunch_Tabs);

    public void select_MyActionWidget_Tabs(DashboardWidget dashboardWidgetName, String Tab_Name){
        IntStream.range(0, widget_List.size()).filter(i -> widgetName_List.get(i).getText()
                .equalsIgnoreCase(dashboardWidgetName.getValue()))
                .flatMap(i -> IntStream.range(0, MyActionTabs_List.size()))
                .filter(j -> MyActionTabs_List.get(j).getText()
                .contains(Tab_Name)).forEach(j -> MyActionTabs_List.get(j).click());
    }

    public void select_QuickLaunchWidget_Tabs(DashboardWidget dashboardWidgetName, String Tab_Name){
        IntStream.range(0, widget_List.size()).filter(i -> widgetName_List.get(i).getText()
                .equalsIgnoreCase(dashboardWidgetName.getValue()))
                .flatMap(i -> IntStream.range(0, quickLaunchTabs_List.size()))
                .filter(j -> quickLaunchTabs_List.get(j).getText()
                .contains(Tab_Name)).forEach(j -> quickLaunchTabs_List.get(j).click());
    }


}
