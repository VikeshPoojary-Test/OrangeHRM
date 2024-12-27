package com.orangehrm.common.constant;

public enum PIMPageConstant {
    CONFIGURATION("Configuration "),
    EMPLOYEE_LIST("Employee List"),
    ADD_EMPLOYEE("Add Employee"),
    REPORTS("Reports"),
    CONFIGURATION_OPTIONAL_FILEDS("Optional Fields"),
    CONFIGURATION_CUSTOM_FIELDS("Custom Fields"),
    CONFIGURATION_DATA_IMPORT("Data Import"),
    CONFIGURATION_REPORTING_METHODS("Reporting Methods"),
    CONFIGURATION_TERMINATION_REASONS("Termination Reasons"),

    PERSONAL_DETAILS("Personal Details"),
    CONTACT_DETAILS("Contact Details"),
    EMERGENCY_CONTACTS("Emergency Contacts"),
    DEPENDENTS("Dependents"),
    IMMIGRATION("Immigration"),
    JOB("Job"),
    SALARY("Salary"),
    REPORT_TO("Report-to"),
    QUALIFICATION("Qualifications"),
    MEMBERSHIPS("Memberships");


    private final String value;

    PIMPageConstant(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
