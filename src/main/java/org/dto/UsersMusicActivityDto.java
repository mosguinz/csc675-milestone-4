package org.dto;

public class UsersMusicActivityDto extends BaseDto {

    private int userId;
    private int musicActivityId;

    public UsersMusicActivityDto() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMusicActivityId() {
        return musicActivityId;
    }

    public void setMusicActivityId(int musicActivityId) {
        this.musicActivityId = musicActivityId;
    }

}
