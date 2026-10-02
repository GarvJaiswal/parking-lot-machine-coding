package org.example.strategy;

import org.example.models.ParkingSpot;
import org.example.models.Vehicle;

public interface ParkingSpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(Vehicle vehicle);
}
