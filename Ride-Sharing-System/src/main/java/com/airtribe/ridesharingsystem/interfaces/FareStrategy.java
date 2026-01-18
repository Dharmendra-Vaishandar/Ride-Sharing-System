package com.airtribe.ridesharingsystem.interfaces;

import com.airtribe.ridesharingsystem.model.Ride;

public interface FareStrategy {
    double calculateFare(Ride ride);
}
