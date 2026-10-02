package org.example.controllers;

import org.example.dtos.GenerateTicketRequestDTO;
import org.example.dtos.GenerateTicketResponseDTO;
import org.example.dtos.ResponseStatus;
import org.example.exceptions.InvalidGateException;
import org.example.models.Ticket;
import org.example.services.TicketService;

//takes request parameter and call the service layer

//Controller acts like an entry point to our application.
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO) throws InvalidGateException {
        // Takes the request parameters and call the Service.

        // Extract all the parameters from request DTO and validate.

        Ticket ticket = ticketService.generateTicket(
                requestDTO.getGateId(),
                requestDTO.getVehicleNumber(),
                requestDTO.getOwnerName(),
                requestDTO.getVehicleType(),
                requestDTO.getParkingSpotAssignmentStrategyType()
        );

        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();
        responseDTO.setTicket(ticket);
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        return responseDTO;
    }
}
