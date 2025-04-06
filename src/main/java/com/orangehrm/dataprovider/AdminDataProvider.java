package com.orangehrm.dataprovider;

import com.orangehrm.utility.TestDataUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class AdminDataProvider {
    @DataProvider(name = "adminData")
    public Object[][] adminData() {
        List<AdminPageData> ObjectList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            AdminPageData adminPageData = TestDataUtils.getAdminPageData();
            ObjectList.add(adminPageData);
        }
            Object[][] mainObject = new Object[ObjectList.size()][1];
            for (int i = 0; i < ObjectList.size(); i++) {
                mainObject[i][0] = ObjectList.get(i);
            }
            return mainObject;

    }
}
