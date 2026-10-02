package org.example.models;

public class ParkingSpot extends BaseModel {
    private String parkingSPotNumber;
    private  VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;

    public String getParkingSPotNumber() {
        return parkingSPotNumber;
    }

    public void setParkingSPotNumber(String parkingSPotNumber) {
        this.parkingSPotNumber = parkingSPotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
