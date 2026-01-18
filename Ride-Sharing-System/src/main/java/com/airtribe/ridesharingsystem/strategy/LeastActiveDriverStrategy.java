package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.List;
import java.util.Map;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {

    private final Map<String, Integer> driverRideCount;

    public LeastActiveDriverStrategy(Map<String, Integer> driverRideCount) {
        this.driverRideCount = driverRideCount;
    }

    @Override
    public RideDriver findDriver(Rider rider, List<RideDriver> drivers) {

        RideDriver selectedDriver = null;
        int minRides = Integer.MAX_VALUE;

        for (RideDriver driver : drivers) {
            if (!driver.isAvailable()) continue;

            int rides = driverRideCount.getOrDefault(driver.getId(), 0);
            if (rides < minRides) {
                minRides = rides;
                selectedDriver = driver;
            }
        }
        return selectedDriver;
    }
}
