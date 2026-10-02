package org.example.services;

import org.example.exceptions.InvalidGateException;
import org.example.factory.ParkingSpotAssignmentStrategyFactory;
import org.example.models.*;
import org.example.repositories.GateRepository;
import org.example.repositories.TicketRepository;
import org.example.repositories.VehicleRepository;
import org.example.strategy.ParkingSpotAssignmentStrategy;
import org.example.strategy.ParkingSpotAssignmentStrategyType;

import java.util.Optional;
import java.util.Date;


public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(Long gateId,
                                 String vehicleNumber,
                                 String ownerName,
                                 VehicleType VehicleType,
                                 ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType) throws InvalidGateException {

            /*
            1. Get the gate object from the db using gateId.
            2. If gateId is invalid, throw an exception
            3. Check if the vehicle number is already present in the db or not.
            4. If yes, fetch the vehicle details, else create and store a new store vehicle in db.
            5. Assign the parking spot.
            6. Generate the ticket.
             */

        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        if (optionalGate.isEmpty()) {
            // Gate is null -> gateId was Invalid.
            throw new InvalidGateException("Invalid gateId - " + gateId);
        }

        Gate gate = optionalGate.get();

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle = null;

        if (optionalVehicle.isEmpty()) {
            // Create a new Vehicle Object and save it into the database.
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            ///....TODO... Complete this section.
        } else {
            vehicle = optionalVehicle.get();
        }

        // Assign the parking spot.
        ParkingSpotAssignmentStrategy spotAssignmentStrategy =
                ParkingSpotAssignmentStrategyFactory.getParkingSpotStrategy(parkingSpotAssignmentStrategyType);

        ParkingSpot parkingSpot = null;

        if (spotAssignmentStrategy != null) {
            parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicle);
        }

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date()); // current time

        // Now save the ticket to DB.
        return ticketRepository.save(ticket);
    }
}

// Controller -> Service -> Repository -> DB
