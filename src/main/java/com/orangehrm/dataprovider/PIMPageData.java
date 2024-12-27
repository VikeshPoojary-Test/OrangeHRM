package com.orangehrm.dataprovider;

import lombok.Data;

@Data
public class PIMPageData {
    private String employeeName;
    private String employeeLastName;
    private String employeeID;
    private String employmentStatus;
    private String include;
    private String supervisorName;
    private String subType;
    private String jobTitle;

    private String userName;
    private String password;

    private String licenseNumber;
    private String nationality;
    private String maritalStatus;

    //Contact Details Page
    private String street1Address;
    private String street2Address;
    private String contactCity;
    private String contactState;
    private String contactZip;
    private String contactCountry;
    private String workEmail;
    private String personalEmail;

}
