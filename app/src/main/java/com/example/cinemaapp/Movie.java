package com.example.cinemaapp;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private String duration;
    private String whichHour;
    private String price;

    public Movie(String name, String duration, String whichHour,String price) {
        this.name = name;
        this.duration = duration;
        this.whichHour = whichHour;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getWhichHour() {
        return whichHour;
    }

    public void setWhichHour(String whichHour) {
        this.whichHour = whichHour;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
