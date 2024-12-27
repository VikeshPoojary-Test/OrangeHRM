package com.orangehrm.pages;

import com.orangehrm.BasePage;
import com.orangehrm.common.constant.AdminPageConstants;
import com.orangehrm.common.constant.PIMPageConstant;
import com.orangehrm.dataprovider.PIMPageData;
import com.orangehrm.utility.DateTimeUtility;
import org.openqa.selenium.By;

import java.util.Optional;

public class PIMPage extends BasePage {
    private final By employeeName_field = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private final By employeeID_Field = By.xpath("(//input[@placeholder='Type for hints...'])[2]");
    private final By employmentStatus_Button = By.cssSelector("div:nth-of-type(3) > .oxd-input-field-bottom-space.oxd-input-group .bi-caret-down-fill.oxd-icon.oxd-select-text--arrow");
    private final By includeButton =By.cssSelector("div:nth-of-type(4) > .oxd-input-field-bottom-space.oxd-input-group .bi-caret-down-fill.oxd-icon.oxd-select-text--arrow");
    private final By supervisorName_Field = By.cssSelector("[class] .oxd-grid-item--gutters:nth-of-type(5) [placeholder]");
    private final By jobTitle_Button = By.xpath("//div[@class='oxd-form-row']/div/div[6]/div//i");
    private final By subUnit_Button = By.cssSelector("[class] .oxd-grid-item--gutters:nth-of-type(7) .oxd-select-text--arrow");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By resetButton = By.xpath("//button[@type='reset']");

    private final By employeeFirstName_AddPage = By.cssSelector("[name='firstName']");
    private final By employeeMiddleName_AddPage = By.cssSelector("[name='middleName']");
    private final By employeeLastName_AddPage = By.cssSelector("[name='lastName']");
    private final By employeeID_AddPage = By.xpath("//input[@fdprocessedid='ocij5']");
    private final By createLoginDetails_RadioButton = By.cssSelector(".--label-right.oxd-switch-input");
    private final By userNameField_AddPage = By.xpath("//label[text()[contains(.,'Username')]]/parent::div/parent::div//input");
    private final By passwordField_AddPage = By.xpath("//label[text()[contains(.,'Password')] and text()[not(contains(.,'Confirm'))]]/parent::div/parent::div//input");
    private final By confirmPasswordFiled = By.xpath("//label[text()[contains(.,'Confirm Password')]]/parent::div/parent::div//input");

    private final By saveButton_AddPAge = By.xpath("//button[text()[contains(. ,'Save')]]");
    private final By cancelButton_AddPAge = By.xpath("//button[text()[contains(. ,'Cancel')]]");
    private final By addButton = By.xpath("//Button[text()[contains(. ,'Add')]]");

    private final By tableRows = By.cssSelector("div > div[role='row']");
    private final By table_IDValue = By.cssSelector("div[role='row'] > div:nth-of-type(2)");
    private final By table_FirstNameValue = By.cssSelector("div[role='row'] > div:nth-of-type(3)");
    private final By table_LastNameValue = By.cssSelector("div[role='row'] > div:nth-of-type(4)");
    private final By table_JobTitleValue = By.cssSelector("div[role='row'] > div:nth-of-type(5)");
    private final By table_EmploymentStatusValue = By.cssSelector("div[role='row'] > div:nth-of-type(6)");
    private final By table_SubUnitValue = By.cssSelector("div[role='row'] > div:nth-of-type(7)");
    private final By table_SupervisorNameValue = By.cssSelector("div[role='row'] > div:nth-of-type(8)");
    private final By table_RowEditButton = By.xpath("//div[@role='row']//button[1]");
    private final By table_RowDeleteButton = By.xpath("//div[@role='row']//button[2]");

    private final By getSuggestionDropdown = By.cssSelector(".oxd-autocomplete-dropdown .oxd-autocomplete-option");
    private final By divDropdownValues = By.cssSelector("div[role='listbox'] > div");

    // Personal Details
    private final By driverLicenseNumber_Field = By.xpath("//label[text()[contains(.,'Driver')]]/parent::div/parent::div//input");
    private final By nationalityDropdown_Button = By.xpath("//label[text()[contains(.,'Nationality')]]/parent::div/parent::div//div[@class='oxd-select-text--after']");
    private final By maritalStatusDropdown_Button = By.xpath("//label[text()[contains(.,'Marital')]]/parent::div/parent::div//div[@class='oxd-select-text--after']");
    private final By dateOfBirth_CalenderButton = By.xpath("//label[text()[contains(.,'Birth')]]/parent::div/parent::div//div[@class='oxd-date-input']/i");
    private final By bloodTypeDropdown_Button = By.xpath("//label[text()[contains(.,'Blood')]]/parent::div/parent::div//div[@class='oxd-select-text--after']/i");
    private final By licenseExpiryDate_CalenderButton = By.cssSelector("div:nth-of-type(2) > .oxd-input-field-bottom-space.oxd-input-group .bi-calendar.oxd-date-input-icon.oxd-icon");

    // Calender
    private final By previousButton_Calender = By.cssSelector(".oxd-calendar-header > button:nth-of-type(1)");
    private final By nextButton_Calender = By.cssSelector(".oxd-calendar-header > button:nth-of-type(2)");
    private final By selectCalenderDate = By.cssSelector(".oxd-calendar-date-wrapper");
    private final By presentDateWebElement = By.cssSelector(".oxd-calendar-selector");

    //Contact Details
    private final By addressStreet1_Field = By.xpath("//label[text()[contains(.,'1')]]/parent::div/parent::div/div/input");
    private final By addressStrret2_Field = By.xpath("//label[text()[contains(.,'2')]]/parent::div/parent::div/div/input");
    private final By addressCity_Field = By.xpath("//label[text()[contains(.,'City')]]/parent::div/parent::div/div/input");
    private final By addressState_Field = By.xpath("//label[text()[contains(.,'Sta')]]/parent::div/parent::div/div/input");
    private final By addressZip_Field = By.xpath("//label[text()[contains(.,'Zip')]]/parent::div/parent::div/div/input");
    private final By addressCountryDropdown_Button = By.xpath("//label[text()[contains(.,'Country')]]/parent::div/parent::div//div[@class='oxd-select-wrapper']//i");
    private final By telephoneHome_Field = By.xpath("//label[text()[contains(.,'Home')]]/parent::div/parent::div/div/input");
    private final By telephoneMobile_Field = By.xpath("//label[text()[contains(.,'Mobile')]]/parent::div/parent::div/div/input");
    private final By telephoneWork_Field = By.xpath("//label[text()[contains(.,'Work')]]/parent::div/parent::div/div/input");
    private final By workEmail_Field = By.xpath("//label[text()[contains(.,'Work Email')]]/parent::div/parent::div/div/input");
    private final By personalEmail_Field = By.xpath("//label[text()[contains(.,'Other Email')]]/parent::div/parent::div/div/input");

    // Emergency Contact
    private final By emergencyName_Field = By.xpath("//label[text()[contains(.,'Name')]]/parent::div/parent::div/div/input");
    private final By emergencyRelationship_Field = By.xpath("//label[text()[contains(.,'Relationship')]]/parent::div/parent::div/div/input");
    private final By emergencyTelephone_Field = By.xpath("//label[text()[contains(.,'Home')]]/parent::div/parent::div/div/input");
    private final By emergencyMobile_Field = By.xpath("//label[text()[contains(.,'Mobile')]]/parent::div/parent::div/div/input");

    // Dependent

    DateTimeUtility dateTimeUtility = new DateTimeUtility();

    private By navBar(String navBar) {
        return By.linkText(navBar);
    }

    public void navigateToSubTabs(PIMPageConstant pimPageConstant) {
        click(navBar(pimPageConstant.getValue()));
    }

    public void enterSearchEmployeeName(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getEmployeeName()).ifPresent(employeeName
                ->selectFirst_DataFromAutoSuggestiveField(employeeName_field, getSuggestionDropdown,employeeName));
    }

    public void enterSearchEmployeeID(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getEmployeeID()).ifPresent(employeeID
                -> passValue(employeeID_Field, employeeID));
    }

    public void selectSearchEmployeeStatus(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getEmploymentStatus()).ifPresent(status
                -> getValueFromDivDropDown(employmentStatus_Button, divDropdownValues,status));
    }

    public void selectSearchInclude(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getInclude()).ifPresent(include
                -> getValueFromDivDropDown(includeButton, divDropdownValues,include));
    }

    public void enterSupervisorName(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getSupervisorName()).ifPresent(supervisorName
                -> selectFirst_DataFromAutoSuggestiveField(supervisorName_Field, getSuggestionDropdown, supervisorName));
    }

    public void selectJobTitle(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getJobTitle()).ifPresent(jobTitle
                -> getValueFromDivDropDown(jobTitle_Button, divDropdownValues, jobTitle));
    }

    public void selectSubunit(PIMPageData pimPageData){
        Optional.ofNullable(pimPageData.getSubType()).ifPresent(subunit
                -> getValueFromDivDropDown(subUnit_Button, divDropdownValues, subunit));
    }

    public void clickSearchButton(){
        click(searchButton);
    }

    public void clickResetButton(){
        click(resetButton);
    }

    public void clickAddButton(){
        click(addButton);
    }

    public void enterEmployeeName(PIMPageData pimPageData){
        passValue(employeeFirstName_AddPage,pimPageData.getEmployeeName());
        passValue(employeeLastName_AddPage, pimPageData.getEmployeeLastName());
    }

    public void clickCreateLoginDetails_RadioButton(){
        click(createLoginDetails_RadioButton);
    }

    public void enterUserName(PIMPageData pimPageData){
        passValue(userNameField_AddPage,pimPageData.getUserName());
    }

    public void enterPassword(PIMPageData pimPageData){
        passValue(passwordField_AddPage, pimPageData.getPassword());
        passValue(confirmPasswordFiled, pimPageData.getPassword());
    }

    public void clickSaveButton(){
        click(saveButton_AddPAge);
    }

    public void clickCancelButton(){
        click(cancelButton_AddPAge);
    }

    public void enterDriverLicenseNumber(PIMPageData pimPageData){
        passValue(driverLicenseNumber_Field, pimPageData.getLicenseNumber());
    }

    public void clickLicenseExpiryDateButton() {
        click(licenseExpiryDate_CalenderButton);
    }

    public void selectNationality(PIMPageData pimPageData){
        getValueFromDivDropDown(nationalityDropdown_Button, divDropdownValues, pimPageData.getNationality());
    }

    public void selectMaritalStatus(PIMPageData pimPageData){
        getValueFromDivDropDown(maritalStatusDropdown_Button, divDropdownValues, pimPageData.getMaritalStatus());
    }

    public void clickDateOfBirth(){
        click(dateOfBirth_CalenderButton);
    }

    public void selectDate(String targetDate, String dateFormat){
        dateTimeUtility.selectDate(targetDate,dateFormat, presentDateWebElement,
                previousButton_Calender, nextButton_Calender, selectCalenderDate);
    }

    // Contact Details page operation
    public void enterStreetAddress(PIMPageData pimPageData){
        passValue(addressStreet1_Field,pimPageData.getStreet1Address());
        passValue(addressStrret2_Field, pimPageData.getStreet2Address());
    }

    public void enterCity(PIMPageData pimPageData){
        passValue(addressCity_Field, pimPageData.getContactCity());
    }

    public void enterZipCode(PIMPageData pimPageData){
        passValue(addressZip_Field, pimPageData.getContactZip());
    }

    public void selectCountry(PIMPageData pimPageData){
        getValueFromDivDropDown(addressCountryDropdown_Button, divDropdownValues,pimPageData.getContactCountry());
    }

    public void enterWorkEmail(PIMPageData pimPageData){
        passValue(workEmail_Field, pimPageData.getWorkEmail());
    }

    public void enterPersonalEmail(PIMPageData pimPageData){
        passValue(personalEmail_Field, pimPageData.getPersonalEmail());
    }
}
