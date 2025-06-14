package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.repository.CinemaReppository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private CinemaReppository repository;

    public CinemaService(CinemaReppository repository) {this.repository = repository;}
    public List<Cinema> getAllCinemas() {return repository.findAll();}

    public List<Cinema> getAllCinemaByCinemaName(String cinemaName) {return repository.findAllByCinemaName(cinemaName);}

    public Cinema getCinemaByCinemaID(String cinemaID) {return repository.getCinemasByCinemaID(cinemaID);}






}

