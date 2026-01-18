package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.model.Ride;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeakHourFareStrategyTest {

    private PeakHourFareStrategy fareStrategy;

    @BeforeEach
    void setUp() {
        fareStrategy = new PeakHourFareStrategy();
    }

    @Test
    void calculateFare_shouldReturnDistanceMultipliedByFifteen() {
        Rider rider = new Rider("R1", "Dharmendra",11);
        Ride ride = new Ride("RID2001", rider, 10.0);

        double fare = fareStrategy.calculateFare(ride);

        assertEquals(150.0, fare);
    }

    @Test
    void calculateFare_shouldReturnZeroWhenDistanceIsZero() {
        Rider rider = new Rider("R1", "Dharmendra",11);
        Ride ride = new Ride("RID2002", rider, 0.0);

        double fare = fareStrategy.calculateFare(ride);

        assertEquals(0.0, fare);
    }
}
