package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.Seat;
import com.example.Movie_Ticket_Website.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatDAO {

    @Autowired
    private SeatService seatService;

    public void all(){
        List<Seat> seats = seatService.getSeatByMID_CNAME_DATE_RNAME_TIME("Mv1", "cnm1", "2023-12-22", "Phòng 4", "17:00:00");

    }
}
