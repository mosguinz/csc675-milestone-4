package org.dto;

public class TransitRoutesUsersDto extends BaseDto {

    private int routeId;
    private int userId;

    public TransitRoutesUsersDto() {
        super();
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
