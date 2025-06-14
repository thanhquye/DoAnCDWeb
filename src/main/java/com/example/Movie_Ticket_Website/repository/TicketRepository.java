package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Ticket;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
}
