package org.example.repositories;

import org.example.models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<Long, Ticket> ticketMap = new HashMap<Long, Ticket>(); //  gates table in memory
    private Long ticketId = 0L;

    public Ticket save(Ticket vehicle) {
        //TODO
        return null;
    }

    public Optional<Ticket> findById(Long id) {
        //TODO
        return null;
    }
}
