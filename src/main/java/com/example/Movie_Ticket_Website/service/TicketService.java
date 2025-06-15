package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.TicketWithCustomerDTO;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public long getTicketCount() {
        return ticketRepository.count();
    }

    public List<TicketWithCustomerDTO> getAllTicket() {
        return ticketRepository.findAllTicket();
    }

    // get by CinemaID
    public List<Ticket> getAllTicketByMovieID(String cinemaID) {
        return ticketRepository.findAllByCinemaID(cinemaID);
    }
}
