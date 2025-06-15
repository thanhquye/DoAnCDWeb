package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.dto.TicketWithCustomerDTO;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.repository.TicketRepository;
import com.example.Movie_Ticket_Website.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketDAO {
    @Autowired
    private TicketService ticketService;

    public void all(){
        List<TicketWithCustomerDTO> getAll = ticketService.getAllTickets();
        List<Ticket> getByCinemaID = ticketService.getTicketsByCinemaID("cnm1");
    }

}
