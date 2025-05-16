package org.dto;

/**
 * EmployeeDto
 * <p>
 * Data Transfer Object for Employee
 * <p>
 * Modifications:
 * <p>
 * 04/20/2024 - jhui - Created
 */
public class EmployeeDto extends BaseDto {
    int employeeId;
    String lastName;
    String firstName;
    String email;
    String streetAddress;
    String city;
    String state;
    String country;
    int departmentId;

    public EmployeeDto() {
        super();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int id) {
        employeeId = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String addr) {
        email = addr;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String addr) {
        streetAddress = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        city = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String name) {
        state = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String name) {
        country = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int id) {
        departmentId = id;
    }
}
