package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaReppository extends JpaRepository<Cinema, String> {

    List<Cinema> findAllByCinemaName(String cinemaName);

    Cinema getCinemasByCinemaID(String cinemaID);
}
