package org.dao;

public class UsersTransitAlertsDto extends BaseDto {

    private int userId;
    private int alertId;

    public UsersTransitAlertsDto() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

}
