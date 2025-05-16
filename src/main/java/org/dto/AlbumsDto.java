package org.dto;

public class AlbumsDto extends BaseDto {

    private int id;
    private String title;
    private java.time.LocalDateTime releaseDate;

    public AlbumsDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.time.LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(java.time.LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

}
