package com.orangehrm.pages;

import com.aventstack.extentreports.Status;
import com.orangehrm.BasePage;
import com.orangehrm.common.constant.AdminPageConstants;
import com.orangehrm.common.constant.LeftNavBar;
import com.orangehrm.dataprovider.AdminPageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class AdminPage extends BasePage {

    private final By searchUserName_Field = By.cssSelector(".oxd-form .oxd-input");
    private final By userRole_Dropdown = By.xpath("//label[text()='User Role']/parent::div[contains(@class,'input')]/following-sibling::div");
    private final By status_Dropdown = By.xpath("//div/div[4]/div/div[2]/div[@class='oxd-select-wrapper']");
    private final By employeeName_DynamicField = By.cssSelector("[placeholder='Type for hints\\.\\.\\.']");
    private final By employeeNameList = By.cssSelector(".oxd-autocomplete-dropdown [role='option']");

    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By userDropdownValue = By.cssSelector("div[role='listbox'] > div");

    private final By addUser_Button = By.xpath("//div[@class='orangehrm-header-container']/button");
    private final By addUserRole_Button = By.cssSelector(".oxd-form .oxd-grid-item--gutters:nth-of-type(1) .oxd-select-text--arrow");
    private final By addUserStatus_Button = By.cssSelector(".oxd-form .oxd-grid-item--gutters:nth-of-type(3) .oxd-select-text--arrow");
    private final By addUserEmployeeName_field = By.cssSelector("[placeholder='Type for hints\\.\\.\\.']");
    private final By addUserName_Field = By.xpath("//div/div[4]/div/div[2]/input");
    private final By addUserPassword_Field = By.cssSelector(".user-password-cell [type]");
    private final By addUserConfirmPass_Field = By.cssSelector(".oxd-grid-item--gutters:nth-of-type(2) [type]");
    private final By addUserCancel_Button = By.xpath("//form[@class='oxd-form']//button[@type='button']");
    private final By addUserSave_Button = By.xpath("//form[@class='oxd-form']//button[@type='submit']");

    private final By userTable = By.cssSelector(".oxd-table-body .oxd-table-card .oxd-table-row--with-border");
    private By tableHeader = null;
    private final By Table_userName = By.cssSelector("[role='cell']:nth-of-type(2)");
    private final By table_UserRole = By.cssSelector("[role='cell']:nth-of-type(3)");
    private final By table_EmployeeName = By.cssSelector("[role='cell']:nth-of-type(4)");
    private final By table_Status = By.cssSelector("[role='cell']:nth-of-type(5)");
    private final By table_DeleteBtn = By.cssSelector("div > button:nth-of-type(1)");
    private final By table_EditBtn = By.cssSelector("div > button:nth-of-type(2)");
    private final By changePassword_Checkbox = By.xpath(".oxd-checkbox-wrapper label");
    private final By cancelDelete_Button = By.xpath("//Button[text()[contains(.,'No')]]");
    private final By yesDelete_Button = By.xpath("//Button[text()[contains(.,'Yes')]]");

    private final By popup = By.cssSelector("#oxd-toaster_1");

    private By navBar(String navBar) {
        return By.linkText(navBar);
    }

    /***
     * This is to Navigate to different pages using the Nav bar
     * @param leftNavBar : Left Navigation Bar
     */
    public void navigateTo(LeftNavBar leftNavBar) {
        click(navBar(leftNavBar.getValue()));
    }

    /***
     * This method is used to search a user in Admin page
     * @param adminPageConstants : tabs present in admin page
     * @param subTabName : These are the sub tabs present under the admin page tabs
     */
    public void selectSubTabs(AdminPageConstants adminPageConstants, String subTabName) {
        click(navBar(adminPageConstants.getValue()));
    }

    public void selectUserRoleFromDropdown(String roleName) {
        click(userRole_Dropdown);
        getValueFromWebElementList_Dropdown(userDropdownValue, roleName);
    }

    public void selectUserStatusFromDropdown(String userStatus){
        click(status_Dropdown);
        getValueFromWebElementList_Dropdown(userDropdownValue, userStatus);
    }

    public void selectFromEmployeeNameField(String employeeName) {
        passValue(employeeName_DynamicField, employeeName);
        waitTillMultipleElementLoad(employeeNameList);
        waitAndGetAllElements(employeeNameList).getFirst().click();
    }

    /***
     * This method is to search User based on UserName, UserRole, EmployeeName and Status
     * @param adminPageData : This gives required data from AdminPageData
     */
    public void searchSystemUsers(AdminPageData adminPageData) {
        Optional.ofNullable(adminPageData.getUserName()).ifPresent(userName -> passValue(searchUserName_Field, userName));

        Optional.ofNullable(adminPageData.getUserRole()).ifPresent(this::selectUserRoleFromDropdown);

        Optional.ofNullable(adminPageData.getEmployeeName()).ifPresent(this::selectFromEmployeeNameField);

        Optional.ofNullable(adminPageData.getUserStatus()).ifPresent(this::selectUserStatusFromDropdown);

        click(searchButton);
    }

    /***
     * This method is to search User based on UserName
     *  @param adminPageData : This gives required data from AdminPageData
     */
    public void searchSystemUsers_ByUserName(String adminPageData) {
        Optional.ofNullable(adminPageData).ifPresent(userName -> passValue(searchUserName_Field, userName));
        click(searchButton);
    }

    /***
     *This method is to search User based on User Role
     * @param adminPageData : This gives required data from AdminPageData
     */
    public void searchSystemUsers_ByUserRole(AdminPageData adminPageData) {
        Optional.ofNullable(adminPageData.getUserRole()).ifPresent(userRole -> selectFromDropdown(userRole_Dropdown, userRole));
        click(searchButton);
    }

    /***
     * This method is to search User based on Employee Name
     * @param adminPageData : This gives required data from AdminPageData
     */
    public void searchSystemUsers_ByEmployeeName(AdminPageData adminPageData) {
        Optional.ofNullable(adminPageData.getEmployeeName()).ifPresent(employeeName -> selectFromDropdown(employeeName_DynamicField, employeeName));
        click(searchButton);
    }

    /***
     * This method is to search User based on User Status
     * @param adminPageData : This gives required data from AdminPageData
     */
    public void searchSystemUsers_ByUserStatus(AdminPageData adminPageData) {
        Optional.ofNullable(adminPageData.getUserStatus()).ifPresent(userStatus -> selectFromDropdown(status_Dropdown, userStatus));
        click(searchButton);
    }

    public void clickAddUserButton() {
        click(addUser_Button);
    }

    public void addUser(AdminPageData adminPageData) {
        // click on user role dropdown and choose the role
        click(userRole_Dropdown);
        getValueFromWebElementList_Dropdown(userDropdownValue, adminPageData.getUserRole());

        // Pass the Username
        passValue(addUserName_Field, adminPageData.getUserName());
        logReport(Status.PASS, "Username is : " + adminPageData.getUserName(), true);

        // Choose user status from the dropdown
        click(addUserStatus_Button);
        getValueFromWebElementList_Dropdown(userDropdownValue, adminPageData.getUserStatus());

        // Pass Employee Name and Password
        passValue(addUserEmployeeName_field, adminPageData.getEmployeeName());
        waitTillMultipleElementLoad(employeeNameList);
        waitAndGetAllElements(employeeNameList).getFirst().click();

        passValue(addUserPassword_Field, adminPageData.getPassWord());
        passValue(addUserConfirmPass_Field, adminPageData.getPassWord());

        // Save the changes
        click(addUserSave_Button);
    }

    public void verifyUserDataChanges(AdminPageData adminPageData, AdminPageConstants adminPageConstants, Boolean isEdited) throws InterruptedException {
        String pageData = null;
        if (adminPageConstants.equals(AdminPageConstants.USERNAME)) {
            if(isEdited){
                tableHeader = Table_userName;
                pageData = adminPageData.getEditUserName();
            } else {
                tableHeader = Table_userName;
                pageData = adminPageData.getUserName();
            }
        } else if (adminPageConstants.equals(AdminPageConstants.EMPLOYEENAME)) {
            tableHeader = table_EmployeeName;
            pageData = adminPageData.getEmployeeName();
        } else if (adminPageConstants.equals(AdminPageConstants.USERROLE)) {
            tableHeader = table_UserRole;
            pageData = adminPageData.getUserRole();
        } else if (adminPageConstants.equals(AdminPageConstants.STATUS)) {
            tableHeader = table_Status;
            pageData = adminPageData.getUserStatus();
        }


        List<WebElement> list = waitAndGetAllElements(userTable);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).findElement(tableHeader).getText());
            if (list.get(i).findElement(tableHeader).getText().equalsIgnoreCase(pageData)) {
                logReport(Status.PASS, "Data Verified", false);
            }
        }
    }

    public void editUser(AdminPageData adminPageData, Boolean isPassWordChange) {
        WebElement userTableDriver = waitAndGetElement(userTable);
        userTableDriver.findElement(table_EditBtn).click();

        waitTillElementLoad(addUserSave_Button);

        clearField(addUserName_Field);
        passValue(addUserName_Field,adminPageData.getEditUserName());

        if(isPassWordChange){
            moveToElementAndCLick(changePassword_Checkbox);
            passValue(addUserPassword_Field, adminPageData.getPassWord());
            passValue(addUserConfirmPass_Field, adminPageData.getPassWord());
        } else {
            System.out.println("Checkbox is not selected");
        }
        click(addUserSave_Button);
    }

    public void deleteUser(){
        WebElement userTableDriver = waitAndGetElement(userTable);
        userTableDriver.findElement(table_DeleteBtn).click();
        click(yesDelete_Button);
    }

    public void getPopUpText() {
        String s = getValue(popup);
        System.out.println(s);
    }
}

