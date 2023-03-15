package com.misaka.work.bean;

public class UserDate {
    String day;
    String mouth;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    String year;
    String currentTime;

    public UserDate(String day, String mouth, String year, String currentTime) {
        this.day = day;
        this.mouth = mouth;
        this.year = year;
        this.currentTime = currentTime;
    }

    public UserDate(String day, String mouth, String year) {
        this.day = day;
        this.mouth = mouth;
        this.year = year;
    }

    public UserDate() {
    }
}
