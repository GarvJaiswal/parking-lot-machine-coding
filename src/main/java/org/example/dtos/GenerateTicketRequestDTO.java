package org.example.dtos;

import org.example.models.VehicleType;
import org.example.strategy.ParkingSpotAssignmentStrategyType;

public class GenerateTicketRequestDTO {
    String vehicleNumber;
    VehicleType vehicleType;
    String ownerName;
    Long gateId;
    ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public ParkingSpotAssignmentStrategyType getParkingSpotAssignmentStrategyType() {
        return parkingSpotAssignmentStrategyType;
    }

    public void setParkingSpotAssignmentStrategyType(ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType) {
        this.parkingSpotAssignmentStrategyType = parkingSpotAssignmentStrategyType;
    }
}
