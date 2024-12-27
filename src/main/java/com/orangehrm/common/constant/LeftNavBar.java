package com.orangehrm.common.constant;

public enum LeftNavBar {

    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRCTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");

    private final String value;

    LeftNavBar(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
