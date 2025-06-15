package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaDAO {
    @Autowired
    private CinemaRepository cinemaRepository;

    public void all(){
        List<Cinema> getCinemaByName = cinemaRepository.findAllByCinemaName("Kẻ ăn hồn");
        Cinema getCinemaByID = cinemaRepository.getCinemasByCinemaID("cnm1");
        List<Cinema> getCinemaByMovieID = cinemaRepository.getCinemasByMovieId("Mv1");
        List<Cinema> getAllCinema = cinemaRepository.findAll();
        List<Cinema> getMostPopularCinema = cinemaRepository.findTop2By();
    }
}
