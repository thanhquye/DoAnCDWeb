package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public long getTicketCount() {
        return ticketRepository.count();
    }
}
