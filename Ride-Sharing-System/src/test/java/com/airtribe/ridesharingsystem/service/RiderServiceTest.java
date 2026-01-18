package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiderServiceTest {

    private RiderService riderService;

    @BeforeEach
    void setUp() {
        riderService = new RiderService();
    }

    @Test
    void registerRider_shouldStoreRiderSuccessfully() {
        Rider rider = new Rider("R1", "Ramu", 10);

        riderService.registerRider(rider);

        Rider fetchedRider = riderService.getRiderById("R1");
        assertNotNull(fetchedRider);
        assertEquals("R1", fetchedRider.getId());
    }

    @Test
    void getRiderById_shouldReturnNullWhenRiderDoesNotExist() {
        Rider fetchedRider = riderService.getRiderById("INVALID_ID");

        assertNull(fetchedRider);
    }

    @Test
    void registerRider_shouldOverwriteWhenSameIdIsUsed() {
        Rider rider1 = new Rider("R1", "Ramu", 10);
        Rider rider2 = new Rider("R2", "User2",11);

        riderService.registerRider(rider1);
        riderService.registerRider(rider2);

        Rider fetchedRider = riderService.getRiderById("R1");
        assertNotNull(fetchedRider);
        assertEquals("R1", fetchedRider.getId());
    }
}
