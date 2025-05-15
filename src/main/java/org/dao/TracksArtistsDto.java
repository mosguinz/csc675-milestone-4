package org.dao;

public class TracksArtistsDto extends BaseDto {

    private int trackId;
    private int artistId;

    public TracksArtistsDto() {
        super();
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

}
