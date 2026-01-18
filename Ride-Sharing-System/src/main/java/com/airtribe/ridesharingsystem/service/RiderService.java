package com.airtribe.ridesharingsystem.service;

import com.airtribe.ridesharingsystem.model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderService {

    private final Map<String, Rider> riders = new HashMap<>();

    public void registerRider(Rider rider) {
        riders.put(rider.getId(), rider);
    }

    public Rider getRiderById(String id) {
        return riders.get(id);
    }
}
