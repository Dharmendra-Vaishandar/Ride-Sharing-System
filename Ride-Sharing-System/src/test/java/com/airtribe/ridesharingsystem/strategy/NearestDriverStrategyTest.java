package com.airtribe.ridesharingsystem.strategy;

import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NearestDriverStrategyTest {

    private NearestDriverStrategy strategy;
    private Rider rider;

    @BeforeEach
    void setUp() {
        strategy = new NearestDriverStrategy();
        rider = new Rider("R1", "Dharmendra",11);
    }

    @Test
    void findDriver_shouldReturnFirstAvailableDriver() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Dharmendra", 10);
        RideDriver driver3 = new RideDriver("D3", "Dharmendra", 10);

        RideDriver result = strategy.findDriver(rider, List.of(driver1, driver2, driver3));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldReturnNullWhenNoDriverIsAvailable() {
        RideDriver driver1 = new RideDriver("D1", "Dharmendra", 10);
        RideDriver driver2 = new RideDriver("D2", "Dharmendra", 10);

        RideDriver result = strategy.findDriver(rider, List.of(driver1, driver2));

        assertNotNull(result);
    }

    @Test
    void findDriver_shouldReturnNullForEmptyDriverList() {
        RideDriver result = strategy.findDriver(rider, List.of());

        assertNull(result);
    }

    @Test
    void findDriver_shouldReturnDriverWhenOnlyOneAvailable() {
        RideDriver driver = new RideDriver("D1", "Dharmendra", 10);

        RideDriver result = strategy.findDriver(rider, List.of(driver));

        assertNotNull(result);
        assertEquals("D1", result.getId());
    }
}
