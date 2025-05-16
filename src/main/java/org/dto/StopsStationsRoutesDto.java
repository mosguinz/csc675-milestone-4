package org.dto;

public class StopsStationsRoutesDto extends BaseDto {

    private int stopId;
    private int routeId;

    public StopsStationsRoutesDto() {
        super();
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

}
