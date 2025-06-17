package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Booking;
import com.example.Movie_Ticket_Website.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    @Query("select bk.tickets from Booking bk " +
            "join bk.userLogin user " +
            "where user.userId =:userID")
    List<Ticket> findCartByUserID(@Param("userID") String userID);


}
