package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, String> {
}
