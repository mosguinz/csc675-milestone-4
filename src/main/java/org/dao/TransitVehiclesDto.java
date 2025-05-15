package org.dao;

public class TransitVehiclesDto extends BaseDto {

    private int id;
    private String vehicleType;
    private int capacity;
    private String realTimeLocation;
    private int routeId;

    public TransitVehiclesDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRealTimeLocation() {
        return realTimeLocation;
    }

    public void setRealTimeLocation(String realTimeLocation) {
        this.realTimeLocation = realTimeLocation;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

}
