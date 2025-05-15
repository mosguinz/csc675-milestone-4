package org.dao;

public class StopsStationsDto extends BaseDto {

    private int id;
    private String location;

    public StopsStationsDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
