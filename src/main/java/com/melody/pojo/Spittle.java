package com.melody.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * @author 40431
 */
public class Spittle {

    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(){}

    public Spittle(String message, Date time) {
        this(message,time,null,null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = 123456L;
        this.message = message;
        this.time = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId(){
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Spittle)) {
            return false;
        }
        Spittle spittle = (Spittle) o;
        return Objects.equals(id, spittle.id) &&
                Objects.equals(message, spittle.message) &&
                Objects.equals(time, spittle.time) &&
                Objects.equals(latitude, spittle.latitude) &&
                Objects.equals(longitude, spittle.longitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, message, time, latitude, longitude);
    }
}
