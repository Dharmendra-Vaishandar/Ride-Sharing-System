package com.airtribe.ridesharingsystem.model;

public class RideDriver {
    private final String id;
    private final String name;
    private int currentLocation;
    private boolean available = true;

    public RideDriver(String id, String name, int currentLocation) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}