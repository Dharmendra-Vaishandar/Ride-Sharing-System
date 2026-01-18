package com.airtribe.ridesharingsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RideBookingApplicationTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void main_shouldExecuteCompleteRideBookingFlowWithoutFailure() {

        // Simulate user input sequence
        String input = """
                1
                2
                3
                4
                5
                """;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run main method
        assertDoesNotThrow(() -> RideBookingApplication.main(new String[]{}));

        String output = outContent.toString();

        // ---- Assertions (VERY IMPORTANT) ----
        assertTrue(output.contains("Rider added Successfully"));
        assertTrue(output.contains("Driver added Successfully"));
        assertTrue(output.contains("Available for the Ride"));
        assertTrue(output.contains("Total Fare"));
        assertTrue(output.contains("Thanks for using Ride Sharing System"));
    }
}
