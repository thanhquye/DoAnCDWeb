package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaReppository extends JpaRepository<Cinema, String> {

    List<Cinema> findAllByCinemaName(String cinemaName);

    Cinema getCinemasByCinemaID(String cinemaID);
}
