package com.airtribe.ridesharingsystem.interfaces;

import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    RideDriver findDriver(Rider rider, List<RideDriver> rideDrivers);
}


