package com.airtribe.ridesharingsystem.model;

public class Rider {
    private final String id;
    private final String name;
    private final int location;

    public Rider(String id, String name, int location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
