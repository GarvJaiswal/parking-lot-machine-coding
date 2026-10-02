package org.example.repositories;

import org.example.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap = new HashMap<Long, Vehicle>(); //  gates table in memory
    private Long vehicleId = 0L;

    public Vehicle save(Vehicle vehicle) {
        //TODO
        return null;
    }

    public Optional<Vehicle> findById(Long id) {
        //TODO
        return null;
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return Optional.empty();
    }
}