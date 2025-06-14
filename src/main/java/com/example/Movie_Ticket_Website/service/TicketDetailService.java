package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.repository.TicketDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketDetailService {
    @Autowired
    private TicketDetailRepository ticketDetailRepository;

    public TicketDetailService(TicketDetailRepository ticketDetailRepository) {
        this.ticketDetailRepository = ticketDetailRepository;
    }

    public long totalPriceTicketDetails() {
        return ticketDetailRepository.getTotalEarnings();
    }
}
