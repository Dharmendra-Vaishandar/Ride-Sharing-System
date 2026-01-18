package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.exception.DriverNotFoundException;
import com.airtribe.ridesharingsystem.interfaces.FareStrategy;
import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.FareReceipt;
import com.airtribe.ridesharingsystem.model.Ride;
import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RideServiceTest {

    private RideMatchingStrategy matchingStrategy;
    private FareStrategy fareStrategy;
    private RideService rideService;

    @BeforeEach
    void setUp() {
        matchingStrategy = Mockito.mock(RideMatchingStrategy.class);
        fareStrategy = Mockito.mock(FareStrategy.class);
        rideService = new RideService(matchingStrategy, fareStrategy);
    }

    @Test
    void requestRide_successfullyAssignsDriver() throws DriverNotFoundException {
        Rider rider = new Rider("R1", "Dharmendra",11);
        RideDriver driver = new RideDriver("D1", "Dharmendra", 10);
        List<RideDriver> drivers = List.of(driver);

        when(matchingStrategy.findDriver(rider, drivers)).thenReturn(driver);

        Ride ride = rideService.requestRide(rider, drivers, 10.0);

        assertNotNull(ride);
        assertEquals(rider, ride.getRider());
        assertEquals(driver, ride.getDriver());
        assertFalse(driver.isAvailable());
    }

    @Test
    void requestRide_throwsExceptionWhenDriverNotFound() {
        Rider rider = new Rider("R1", "Dharmendra",19);
        List<RideDriver> drivers = List.of();

        when(matchingStrategy.findDriver(rider, drivers)).thenReturn(null);

        DriverNotFoundException exception = assertThrows(
                DriverNotFoundException.class,
                () -> rideService.requestRide(rider, drivers, 5.0)
        );

        assertEquals("No drivers available at this time", exception.getMessage());
    }

    @Test
    void completeRide_generatesFareReceipt() {
        Rider rider = new Rider("R1", "Dharmendra",11);
        Ride ride = new Ride("RID1001", rider, 15.0);

        when(fareStrategy.calculateFare(ride)).thenReturn(300.0);

        FareReceipt receipt = rideService.completeRide(ride);

        assertNotNull(receipt);
        assertEquals("RID1001", receipt.getRideId());
        assertEquals(300.0, receipt.getAmount());
        verify(fareStrategy, times(1)).calculateFare(ride);
    }
}

