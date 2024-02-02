package com.ortega.scdn.utils;

import com.ortega.scdn.models.Location;

public class DistanceCalculator {

    private static final double EARTH_RADIUS = 6371;

    public static double distanceBetweenTwoPoints(Location p1, Location p2) {

        double dLat = Math.toRadians(p2.getLatitude() - p1.getLongitude()); // Get difference between lat for p1 and p2
        double dLon = Math.toRadians(p2.getLongitude() - p1.getLatitude()); // Get difference between long for p1 and p2

        // Square of sinus function
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(p1.getLatitude())) * Math.cos(Math.toRadians(p2.getLatitude())) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        // Get center angle between two points
        double center = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * center;

    }
}

