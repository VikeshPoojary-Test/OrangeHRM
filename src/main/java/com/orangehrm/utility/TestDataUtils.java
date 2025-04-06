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


    /**
     * Generates a PIMPageData object populated with random test data.
     *
     * This method utilizes the Faker library to generate random values for
     * various fields in the PIMPageData object, including employee details,
     * search criteria, login credentials, contact details, address, and emails.
     *
     * @return a PIMPageData object with randomly populated fields
     */

    public static PIMPageData getPIMPageData(){
        PIMPageData pimPageData = new PIMPageData();

        // Employee Details
         pimPageData.setEmployeeName(faker.name().firstName());
         pimPageData.setEmployeeLastName(faker.name().lastName());

        // Search Criteria
         pimPageData.setInclude("Current and Past Employees");

        // Login Credentials
         pimPageData.setUserName(faker.name().username());
         pimPageData.setPassword(faker.internet().password(10,12,true,true, true));

        // Contact Details
         pimPageData.setLicenseNumber(faker.phoneNumber().phoneNumber());
         pimPageData.setNationality(faker.nation().nationality());
         pimPageData.setMaritalStatus("Single");

        // Address
         pimPageData.setStreet1Address(faker.address().streetAddress());
         pimPageData.setStreet2Address(faker.address().streetAddress(true));
         pimPageData.setContactCity(faker.address().cityName());
         pimPageData.setContactZip(faker.address().zipCode());
         pimPageData.setContactState(faker.address().state());
         pimPageData.setContactCountry(faker.address().country());

        // Email
         pimPageData.setWorkEmail(faker.internet().emailAddress());
         pimPageData.setPersonalEmail(faker.internet().emailAddress());

         return pimPageData;
    }
}
