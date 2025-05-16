package org.dto;

public class TransitSchedulesDto extends BaseDto {

    private int id;
    private int routeId;
    private java.time.LocalDateTime departureTime;
    private java.time.LocalDateTime arrivalTime;
    private String frequency;

    public TransitSchedulesDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public java.time.LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(java.time.LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public java.time.LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(java.time.LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

}
