package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.dto.TicketWithMovieDTO;
import com.example.Movie_Ticket_Website.repository.TicketDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketDetailService {
    private TicketDetailRepository ticketDetailRepository;

    @Autowired
    public TicketDetailService(TicketDetailRepository ticketDetailRepository) {
        this.ticketDetailRepository = ticketDetailRepository;
    }

    public long getTotalEarning() {
        return ticketDetailRepository.getTotalEarnings();
    }

    public TicketWithMovieDTO getTicketDetailByTicketId(String id) {
        return ticketDetailRepository.findTicketDetailByTicketId(id);
    }

}
