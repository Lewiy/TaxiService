package com.lewgmail.romanenko.taxiservice.model.DTO;

/**
 * Created by Lev on 01.12.2016.
 */

public class DataGoogleMapDTO {

    private int distance;
    private String duration;
    private int durationSec;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getDurationSec() {
        return durationSec;
    }

    public void setDurationSec(int durationSec) {
        this.durationSec = durationSec;
    }


}
