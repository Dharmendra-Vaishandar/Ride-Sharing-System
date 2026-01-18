package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeastActiveDriverStrategyTest {

    private Map<String, Integer> driverRideCount;
    private LeastActiveDriverStrategy strategy;
    private Rider rider;

    @BeforeEach
    void setUp() {
        driverRideCount = new HashMap<>();
        strategy = new LeastActiveDriverStrategy(driverRideCount);
        rider = new Rider("R1", "Dharmendra",11);
    }

    @Test
    void findDriver_shouldReturnDriverWithLeastRides() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Dharmendra", 10);
        RideDriver driver3 = new RideDriver("D3", "Dharmendra", 10);

        driverRideCount.put("D1", 5);
        driverRideCount.put("D2", 2);
        driverRideCount.put("D3", 7);

        RideDriver result = strategy.findDriver(rider, List.of(driver1, driver2, driver3));

        assertNotNull(result);
        assertEquals("D2", result.getId());
    }

    @Test
    void findDriver_shouldIgnoreUnavailableDrivers() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Dharmendra", 10);

        driverRideCount.put("D1", 0);
        driverRideCount.put("D2", 3);

        RideDriver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldReturnNullWhenNoDriversAvailable() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Dharmendra", 56);

        RideDriver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldTreatMissingRideCountAsZero() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Dharmendra", 10);

        driverRideCount.put("D2", 4); // D1 not present → default 0

        RideDriver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
        assertEquals("D1", result.getId());
    }
}

