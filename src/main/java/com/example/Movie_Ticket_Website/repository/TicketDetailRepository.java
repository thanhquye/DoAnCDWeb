package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.TicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDetailRepository extends JpaRepository<TicketDetail, String> {

    @Query("SELECT SUM(td.price) FROM TicketDetail td")
    long getTotalEarnings();
}
