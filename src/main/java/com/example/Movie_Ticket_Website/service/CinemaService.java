package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository repository) {this.cinemaRepository = repository;}

    public List<Cinema> getAllCinemaByCinemaName(String cinemaName) {return cinemaRepository.findAllByCinemaName(cinemaName);}

    public Cinema getCinemaByCinemaID(String cinemaID) {return cinemaRepository.getCinemasByCinemaID(cinemaID);}

    // lấy all cinem
    public List<Cinema> getAllCinemas() {return cinemaRepository.findAll();}

    // lấy cinema theo movieID
    public List<Cinema> getCinemaByMovieID(String movieID){
        return cinemaRepository.getCinemasByMovieId(movieID);
    }

    // top2 cinema
    public List<Cinema> getMostPopularCinema(){
        return cinemaRepository.findTop2By();
    }



}

