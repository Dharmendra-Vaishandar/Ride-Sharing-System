package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy {

    @Override
    public RideDriver findDriver(Rider rider, List<RideDriver> rideDrivers) {
        for (RideDriver driver : rideDrivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }
}
