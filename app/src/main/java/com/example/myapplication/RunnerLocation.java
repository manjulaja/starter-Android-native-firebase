package com.example.myapplication;

public class RunnerLocation {
    double lati;
    double longi;
    String id;
    int month;
    int date;
    int hr;
    int min;

    public RunnerLocation(double lati, double longi, int month, int date, int hr, int min, String id){
        this.id=id;
        this.lati=lati;
        this.longi=longi;
        this.month=month;
        this.date=date;
        this.hr=hr;
        this.min=min;
    }

    public double getLati() {
        return lati;
    }

    public double getLongi() {
        return longi;
    }

    public String getId() {
        return id;
    }

    public int getMonth() {
        return month;
    }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public int getDate() {
        return date;

    }
}
