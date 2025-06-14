package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, String> {

}
