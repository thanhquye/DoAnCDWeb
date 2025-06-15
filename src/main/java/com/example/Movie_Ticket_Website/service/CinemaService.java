package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository repository) {this.cinemaRepository = repository;}

    public List<Cinema> getCinemaByName(String cinemaName) {return cinemaRepository.findAllByCinemaName(cinemaName);}

    public Cinema getCinemaByID(String cinemaID) {return cinemaRepository.getCinemasByCinemaID(cinemaID);}

    // lấy all cinem
    public List<Cinema> getAllCinema() {return cinemaRepository.findAll();}

    // lấy cinema theo movieID
    public List<Cinema> getCinemaByMovieID(String movieID){
        return cinemaRepository.getCinemasByMovieId(movieID);
    }

    // top2 cinema
    public List<Cinema> getMostPopularCinema(){
        return cinemaRepository.findTop2By();
    }



}

