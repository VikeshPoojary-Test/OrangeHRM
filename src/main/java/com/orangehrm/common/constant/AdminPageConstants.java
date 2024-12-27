package com.orangehrm.common.constant;

public enum AdminPageConstants {
    JOB("Job"),
    USER_MANAGEMENT("User Management"),
    ORGANIZATION("Organization"),
    QUALIFICATION("Qualifications"),
    NATIONALITIES("Nationalities"),
    CORPORATE_BRANDING("Corporate Branding"),
    CONFIGURATION("Configuration"),

    // User Table Headers
    USERNAME("Username"),
    USERROLE("User Role"),
    EMPLOYEENAME("Employee Name"),
    STATUS("Status");

    private final String value;

    AdminPageConstants(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
