package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.repository.CinemaRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaRoomService {
    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    public CinemaRoomService(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
    }
}
