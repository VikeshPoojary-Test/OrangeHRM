package com.OrangeHRM.scripts;

import com.aventstack.extentreports.Status;
import com.orangehrm.BaseTest;
import com.orangehrm.common.constant.AdminPageConstants;
import com.orangehrm.common.constant.LeftNavBar;
import com.orangehrm.dataprovider.AdminPageData;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.HRMLoginPage;
import com.orangehrm.utility.TestDataUtils;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void sample() throws InterruptedException {

        HRMLoginPage hrmLoginPage = new HRMLoginPage();
        hrmLoginPage.loginToHRM();

        AdminPageData adminPageData = TestDataUtils.getAdminPageData();

        AdminPage adminPage = new AdminPage();
        adminPage.navigateTo(LeftNavBar.ADMIN);
        adminPage.searchSystemUsers(adminPageData);

        adminPage.clickAddUserButton();
        adminPage.addUser(adminPageData);
        adminPage.getPopUpText();

        Thread.sleep(3000);
        adminPage.searchSystemUsers_ByUserName(adminPageData.getUserName());
        adminPage.verifyUserDataChanges(adminPageData, AdminPageConstants.USERNAME, false);
        adminPage.editUser(adminPageData, false);
        adminPage.getPopUpText();

        Thread.sleep(3000);
        adminPage.searchSystemUsers_ByUserName(adminPageData.getEditUserName());
        adminPage.verifyUserDataChanges(adminPageData, AdminPageConstants.USERNAME, true);
        adminPage.deleteUser();
        adminPage.getPopUpText();

    }
}
