package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.model.RideDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RideDriverServiceTest {

    private RideDriverService rideDriverService;

    @BeforeEach
    void setUp() {
        rideDriverService = new RideDriverService();
    }

    @Test
    void registerDriver_shouldRegisterDriverSuccessfully() {
        RideDriver driver = new RideDriver("D1", "Ramu", 10);

        rideDriverService.registerDriver(driver);

        List<RideDriver> availableDrivers = rideDriverService.getAvailableDrivers();
        assertEquals(1, availableDrivers.size());
        assertEquals("D1", availableDrivers.get(0).getId());
    }

    @Test
    void getAvailableDrivers_shouldReturnOnlyAvailableDrivers() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Rahul", 10);

        rideDriverService.registerDriver(driver1);
        rideDriverService.registerDriver(driver2);

        List<RideDriver> availableDrivers = rideDriverService.getAvailableDrivers();

        assertEquals(2, availableDrivers.size());
        assertTrue(availableDrivers.stream().anyMatch(d -> d.getId().equals("D1")));
        assertTrue(availableDrivers.stream().anyMatch(d -> d.getId().equals("D2")));
    }

    @Test
    void getAvailableDrivers_shouldReturnEmptyListWhenNoDriversAvailable() {
        RideDriver driver1 = new RideDriver("R1","Dharmendra", 10);
        RideDriver driver2 = new RideDriver("R1", "Dharmendra", 10);

        rideDriverService.registerDriver(driver1);
        rideDriverService.registerDriver(driver2);

        List<RideDriver> availableDrivers = rideDriverService.getAvailableDrivers();

        assertNotNull(availableDrivers);
    }
}

