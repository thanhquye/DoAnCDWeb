package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.CinemaRoom;
import com.example.Movie_Ticket_Website.repository.CinemaRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaRoomService {
    private CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    public CinemaRoomService(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
    }

    public List<CinemaRoom> getCinemaRoomNameByMID_CNAME_DATE(String movieID, String cinemaName, String date) {
        return cinemaRoomRepository.findCinemaRoomsOfDay(movieID, cinemaName, date);
    }
}
