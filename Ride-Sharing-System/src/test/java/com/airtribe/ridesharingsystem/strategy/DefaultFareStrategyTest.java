package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.model.Ride;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultFareStrategyTest {

    private DefaultFareStrategy fareStrategy;

    @BeforeEach
    void setUp() {
        fareStrategy = new DefaultFareStrategy();
    }

    @Test
    void calculateFare_shouldReturnDistanceMultipliedByTen() {
        Rider rider = new Rider("R1", "Dharmendra",11);
        Ride ride = new Ride("RID001", rider, 12.5);

        double fare = fareStrategy.calculateFare(ride);

        assertEquals(125.0, fare);
    }

    @Test
    void calculateFare_shouldReturnZeroWhenDistanceIsZero() {
        Rider rider = new Rider("R1", "Dharmendra",12);
        Ride ride = new Ride("RID002", rider, 0.0);

        double fare = fareStrategy.calculateFare(ride);

        assertEquals(0.0, fare);
    }
}

