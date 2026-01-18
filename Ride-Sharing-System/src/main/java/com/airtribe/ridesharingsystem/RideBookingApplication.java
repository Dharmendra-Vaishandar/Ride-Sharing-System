package com.airtribe.ridesharingsystem;

import com.airtribe.ridesharingsystem.interfaces.FareStrategy;
import com.airtribe.ridesharingsystem.interfaces.RideMatchingStrategy;
import com.airtribe.ridesharingsystem.model.FareReceipt;
import com.airtribe.ridesharingsystem.model.Ride;
import com.airtribe.ridesharingsystem.model.RideDriver;
import com.airtribe.ridesharingsystem.model.Rider;
import com.airtribe.ridesharingsystem.service.RideDriverService;
import com.airtribe.ridesharingsystem.service.RideService;
import com.airtribe.ridesharingsystem.service.RiderService;
import com.airtribe.ridesharingsystem.strategy.LeastActiveDriverStrategy;
import com.airtribe.ridesharingsystem.strategy.PeakHourFareStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RideBookingApplication {

    public static void main(String[] args) {

        boolean rideBooking = true;
        RiderService riderService = new RiderService();
        RideDriverService driverService = new RideDriverService();

        Map<String, Integer> driverRideCount = new HashMap<>();

        RideMatchingStrategy matchingStrategy = new LeastActiveDriverStrategy(driverRideCount);

        FareStrategy fareStrategy = new PeakHourFareStrategy();

        RideService rideService = new RideService(matchingStrategy, fareStrategy);

        Scanner sc = new Scanner(System.in);

        while (rideBooking) {
            System.out.println("""
                    1. Add Rider
                    2. Add Driver
                    3. View Available Drivers
                    4. Request Ride
                    5. Exit
                    """);

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        riderService.registerRider(
                            new Rider("R1", "Dharmendra", 10)
                    );
                        System.out.println("Rider added Successfully");
                    }

                    case 2 -> {
                        driverService.registerDriver(
                            new RideDriver("D1", "Rahul", 12)
                    );
                        System.out.println("Driver added Successfully");
                    }

                    case 3 -> driverService.getAvailableDrivers()
                            .forEach(d -> System.out.println(d.getName()+" is Available for the Ride"));

                    case 4 -> {
                        Rider rider = riderService.getRiderById("R1");
                        Ride ride = rideService.requestRide(
                                rider,
                                driverService.getAvailableDrivers(),
                                8
                        );
                        FareReceipt receipt = rideService.completeRide(ride);
                        System.out.println("Total Fare: " + receipt.getAmount());
                    }

                    case 5 -> {
                        System.out.println("Thanks for using Ride Sharing System !!!");
                        rideBooking = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
