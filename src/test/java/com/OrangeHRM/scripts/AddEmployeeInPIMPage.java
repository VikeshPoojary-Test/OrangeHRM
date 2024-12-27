package com.OrangeHRM.scripts;

import com.orangehrm.BaseTest;
import com.orangehrm.common.constant.LeftNavBar;
import com.orangehrm.common.constant.PIMPageConstant;
import com.orangehrm.dataprovider.PIMPageData;
import com.orangehrm.pages.HRMLoginPage;
import com.orangehrm.pages.LeftNavigationBarPage;
import com.orangehrm.pages.PIMPage;
import com.orangehrm.utility.TestDataUtils;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.text.ParseException;

public class AddEmployeeInPIMPage extends BaseTest {


    @Test
    public void method(){

        HRMLoginPage hrmLoginPage = new HRMLoginPage();
        hrmLoginPage.loginToHRM();

        LeftNavigationBarPage leftNavigationBarPage = new LeftNavigationBarPage();
        leftNavigationBarPage.navigateTo(LeftNavBar.PIM);

        PIMPage pimPage = new PIMPage();
        PIMPageData pimPageData = TestDataUtils.getPIMPageData();

        pimPage.clickAddButton();
        pimPage.enterEmployeeName(pimPageData);
        pimPage.clickSaveButton();

        pimPage.clickLicenseExpiryDateButton();
        pimPage.selectDate("22/11/2024", "dd/MM/yyyy");



    }
}
