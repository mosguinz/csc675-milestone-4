package org.dao;

public class IncidentCategoriesDto extends BaseDto {

    private int id;
    private String categoryName;

    public IncidentCategoriesDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
