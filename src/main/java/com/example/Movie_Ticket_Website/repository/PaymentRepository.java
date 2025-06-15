package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
