package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.interfaces.FareStrategy;
import com.airtribe.ridesharingsystem.model.Ride;

public class PeakHourFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance() * 15;
    }
}
