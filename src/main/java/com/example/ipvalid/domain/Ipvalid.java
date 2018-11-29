package com.example.ipvalid.domain;

import java.sql.Timestamp;
import java.util.Calendar;

public class Ipvalid {

    private long id;
    private long ipAddress;
    private String status;
    private Timestamp calendar;

    public Ipvalid() {
        super();
    }

    public Ipvalid(long ipAddress, String status) {
        this.ipAddress = ipAddress;
        this.status = status;
    }

    public Ipvalid(long id, long ipAddress, String status) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public long getIpAddress() {
        return ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getCalendar() {
        return calendar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIpAddress(long ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCalendar(Timestamp calendar) {
        this.calendar = calendar;
    }

}
