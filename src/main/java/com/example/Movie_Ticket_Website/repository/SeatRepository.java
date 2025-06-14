package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
}
