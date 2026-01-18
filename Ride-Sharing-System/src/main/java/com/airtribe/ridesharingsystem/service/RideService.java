package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.exception.DriverNotFoundException;
import com.airtribe.ridesharingsystem.interfaces.FareStrategy;
import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.FareReceipt;
import com.airtribe.ridesharingsystem.model.Ride;
import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RideService {

    private final RideMatchingStrategy matchingStrategy;
    private final FareStrategy fareStrategy;
    private final List<Ride> rides = new ArrayList<>();

    public RideService(RideMatchingStrategy matchingStrategy,
                       FareStrategy fareStrategy) {
        this.matchingStrategy = matchingStrategy;
        this.fareStrategy = fareStrategy;
    }

    public Ride requestRide(Rider rider, List<RideDriver> drivers, double distance) throws DriverNotFoundException {
        Ride ride = new Ride(UUID.randomUUID().toString(), rider, distance);

        RideDriver driver = matchingStrategy.findDriver(rider, drivers);
        if (driver == null) {
            throw new DriverNotFoundException("No drivers available at this time");
        }

        driver.setAvailable(false);
        ride.assignDriver(driver);
        rides.add(ride);
        return ride;
    }

    public FareReceipt completeRide(Ride ride) {
        ride.completeRide();
        double fare = fareStrategy.calculateFare(ride);
        return new FareReceipt(ride.getId(), fare);
    }
}