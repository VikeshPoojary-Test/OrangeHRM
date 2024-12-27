package com.orangehrm.common.constant;

public enum DashboardWidget {

    TIME_AT_WORK("Time at Work"),
    MY_ACTIONS("My Actions"),
    QUICK_LAUNCH("Quick Launch"),
    BUZZ_LATEST_POST("Buzz Latest Posts"),
    EMPLOYEES_ON_LEAVE_TODAY("Employees on Leave Today"),
    EMPLOYEE_DISTRIBUTION_BY_SUB_UNIT("Employee Distribution by Sub Unit"),
    EMPLOYEE_DISTRIBUTION_BY_LOCATION("Employee Distribution by Location");

    private final String value;

    DashboardWidget(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
