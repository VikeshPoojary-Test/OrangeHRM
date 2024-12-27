package com.orangehrm.utility;

import com.github.javafaker.Faker;
import com.orangehrm.dataprovider.AdminPageData;
import com.orangehrm.dataprovider.PIMPageData;

public class TestDataUtils {

    private static final Faker faker = new Faker();

    public static long getRandomNumber() {
        return faker.number().randomNumber();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static AdminPageData getAdminPageData() {
        AdminPageData adminPageData = new AdminPageData();

        adminPageData.setUserName(faker.name().name());
        adminPageData.setEmployeeName("a");
        adminPageData.setUserRole("Admin");
        adminPageData.setPassWord(faker.internet().password());
        adminPageData.setUserStatus("Enabled");
        adminPageData.setEditUserName(faker.name().name());

        return adminPageData;
    }

    public static PIMPageData getPIMPageData(){
        PIMPageData pimPageData = new PIMPageData();

         pimPageData.setEmployeeName(faker.name().firstName());
         pimPageData.setEmployeeLastName(faker.name().lastName());
         pimPageData.setInclude("Current and Past Employees");
         pimPageData.setUserName(faker.name().username());
         pimPageData.setPassword(faker.internet().password(10,12,true,true, true));

         pimPageData.setLicenseNumber(faker.phoneNumber().phoneNumber());
         pimPageData.setNationality(faker.nation().nationality());
         pimPageData.setMaritalStatus("Single");

         pimPageData.setStreet1Address(faker.address().streetAddress());
         pimPageData.setStreet2Address(faker.address().streetAddress(true));
         pimPageData.setContactCity(faker.address().cityName());
         pimPageData.setContactZip(faker.address().zipCode());
         pimPageData.setContactState(faker.address().state());
         pimPageData.setContactCountry(faker.address().country());
         pimPageData.setWorkEmail(faker.internet().emailAddress());
         pimPageData.setPersonalEmail(faker.internet().emailAddress());

         return pimPageData;
    }
}
