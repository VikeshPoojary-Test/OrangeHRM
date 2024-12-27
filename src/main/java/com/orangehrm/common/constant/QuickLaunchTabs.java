package com.orangehrm.common.constant;

public enum QuickLaunchTabs {
    ASSIGN_LEAVE("Assign Leave"),
    LEAVE_LIST("leave List"),
    TIMESHEETS("Timesheets"),
    APPLY_LEAVE("Apply Leave"),
    MY_LEAVE("My Leave"),
    MY_TIMESHEETS("My Timesheets");

    private final String value;

    QuickLaunchTabs(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
