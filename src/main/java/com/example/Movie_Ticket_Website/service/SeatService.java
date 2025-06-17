package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Seat;
import com.example.Movie_Ticket_Website.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
    public List<Seat> getSeatByMID_CNAME_DATE_RNAME_TIME(String movieID, String cinemaID, String date, String roomName, String time) {
        return seatRepository.findSeatByMID_CNAME_DATE_RNAME_TIME(movieID, cinemaID, date, roomName, time);

    }

    public Seat getSeatByName(String seatName) {
        return seatRepository.findBySeatName(seatName);
    }
}
