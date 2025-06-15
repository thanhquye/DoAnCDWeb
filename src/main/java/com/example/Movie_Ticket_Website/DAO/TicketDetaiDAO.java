package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.dto.TicketWithMovieDTO;
import com.example.Movie_Ticket_Website.service.TicketDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketDetaiDAO {
    @Autowired
    private TicketDetailService ticketDetailService;

    public void all(){
        List<TicketWithMovieDTO> getByTID = ticketDetailService.getTicketDetailByTicketId("tk1");
    }
}
