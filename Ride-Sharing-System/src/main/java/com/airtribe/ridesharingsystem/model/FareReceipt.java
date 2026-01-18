package com.airtribe.ridesharingsystem.model;

import java.time.LocalDateTime;

public class FareReceipt {
    public String getRideId() {
        return rideId;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    private final String rideId;
    private final double amount;
    private final LocalDateTime generatedAt;

    public FareReceipt(String rideId, double amount) {
        this.rideId = rideId;
        this.amount = amount;
        this.generatedAt = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }
}
