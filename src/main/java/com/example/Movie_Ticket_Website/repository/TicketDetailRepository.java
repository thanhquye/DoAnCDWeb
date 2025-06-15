package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.dto.TicketWithMovieDTO;
import com.example.Movie_Ticket_Website.model.TicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDetailRepository extends JpaRepository<TicketDetail, String> {

    @Query("SELECT SUM(td.price) FROM TicketDetail td")
    long getTotalEarnings();

    @Query("select new com.example.Movie_Ticket_Website.dto.TicketWithMovieDTO(" +
            "tk.ticketID, tkdt.price, s.seatName, s.seatType, cr.roomName, c.cinemaName, c.location, st.showDate, " +
            "st.startTime, st.endTime, m.movieName, m.movieCategory, m.director, m.country, m.movieScore) " +
            "from Seat s " +
            "join s.ticketDetail tkdt " +
            "JOIN tkdt.ticket tk " +
            "JOIN tk.showTime st " +
            "JOIN st.movie m " +
            "JOIN st.cinema c " +
            "JOIN c.cinemaRooms cr " +
            "WHERE tk.ticketID = :ticketID")
    List<TicketWithMovieDTO> findTicketDetailByTicketId(@Param("ticketID") String ticketId);
}
