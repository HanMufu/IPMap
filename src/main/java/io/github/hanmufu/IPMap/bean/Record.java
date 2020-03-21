package io.github.hanmufu.IPMap.bean;

import java.util.Date;

public class Record {
    private String IPAddress;
    private float lon;
    private float lat;
    private Date date;

    public Record(String IPAddress, float lon, float lat, Date date) {
        this.IPAddress = IPAddress;
        this.lon = lon;
        this.lat = lat;
        this.date = date;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    public Date getDate() {
        return date;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
