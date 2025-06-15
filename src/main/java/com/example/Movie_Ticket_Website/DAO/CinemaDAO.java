package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.repository.CinemaRepository;
import com.example.Movie_Ticket_Website.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaDAO {
    @Autowired
    private CinemaService cinemaService;

    public void all(){
        List<Cinema> getCinemaByName = cinemaService.getCinemaByName("Kẻ ăn hồn");
        Cinema getCinemaByID = cinemaService.getCinemaByID("cnm1");
        List<Cinema> getCinemaByMovieID = cinemaService.getCinemaByMovieID("Mv1");
        List<Cinema> getAllCinema = cinemaService.getAllCinema();
        List<Cinema> getMostPopularCinema = cinemaService.getMostPopularCinema();
    }
}
