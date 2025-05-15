package org.dao;

public class UserPreferencesDto extends BaseDto {

    private int id;
    private boolean notificationsEnabled;
    private boolean musicSharingVisibility;
    private String preferredRoutes;
    private String alertCustomization;

    public UserPreferencesDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public boolean getMusicSharingVisibility() {
        return musicSharingVisibility;
    }

    public void setMusicSharingVisibility(boolean musicSharingVisibility) {
        this.musicSharingVisibility = musicSharingVisibility;
    }

    public String getPreferredRoutes() {
        return preferredRoutes;
    }

    public void setPreferredRoutes(String preferredRoutes) {
        this.preferredRoutes = preferredRoutes;
    }

    public String getAlertCustomization() {
        return alertCustomization;
    }

    public void setAlertCustomization(String alertCustomization) {
        this.alertCustomization = alertCustomization;
    }

}
