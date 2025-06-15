package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
    @Query("SELECT s FROM Seat s " +
            "JOIN s.cinemaRoom cr " +
            "JOIN cr.cinema c " +
            "JOIN c.showTimes st " +
            "JOIN st.movie m " +
            "WHERE m.movieID = :movieID " +
            "AND c.cinemaID = :cinemaID " +
            "AND st.showDate = :date " +
            "AND cr.roomName = :roomName " +
            "AND st.startTime = :time")
    List<Seat> findSeatByMID_CNAME_DATE_RNAME_TIME(
            @Param("movieID") String movieID,
            @Param("cinemaID") String cinemaID,
            @Param("date") String date,
            @Param("roomName") String roomName,
            @Param("time") String time
    );}
