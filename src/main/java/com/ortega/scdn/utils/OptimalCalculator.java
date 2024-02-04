package com.ortega.scdn.utils;

import com.ortega.scdn.models.Location;

public class OptimalCalculator {

    private static final double EARTH_RADIUS = 6371;

    public static double getDistanceBetweenTwoLocation(Location p1, Location p2) {

        double dLat = Math.toRadians(p2.getLat() - p1.getLat());
        double dLon = Math.toRadians(p2.getLon() - p1.getLon());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(p1.getLat())) * Math.cos(Math.toRadians(p2.getLat())) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;

    }

    public static double getScore(double distance, double latency, double bandwidth) {
        // get score of server by sum distance, latency and bandwidth
        return distance + latency + bandwidth;
    }
}

