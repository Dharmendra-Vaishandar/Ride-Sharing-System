package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.model.RideDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideDriverService {
    private final Map<String, RideDriver> drivers = new HashMap<>();

    public void registerDriver(RideDriver driver) {
        drivers.put(driver.getId(), driver);
    }

    public List<RideDriver> getAvailableDrivers() {
        List<RideDriver> available = new ArrayList<>();
        for (RideDriver driver : drivers.values()) {
            if (driver.isAvailable()) {
                available.add(driver);
            }
        }
        return available;
    }
}


