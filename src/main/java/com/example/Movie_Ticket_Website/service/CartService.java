package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.TicketCartDTO;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.repository.BookingRepository;
import com.example.Movie_Ticket_Website.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private BookingRepository bookingRepository;
    private TicketRepository ticketRepository;
    @Autowired
    public CartService(BookingRepository bookingRepository, TicketRepository ticketRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }




    public List<Ticket> getCartByUserID(String userID) {
        return bookingRepository.findCartByUserID(userID);
    }

    public List<TicketCartDTO> getTicketByTicketID(String ticketID ) {
        return ticketRepository.findTicketByTicketID(ticketID);
    }
}
