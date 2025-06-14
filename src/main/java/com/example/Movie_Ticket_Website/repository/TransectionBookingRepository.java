package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.TransactionBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransectionBookingRepository extends JpaRepository<TransactionBooking, String> {

}
