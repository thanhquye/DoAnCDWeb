package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.dto.TicketWithCustomerDTO;
import com.example.Movie_Ticket_Website.model.Ticket;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.TicketWithCustomerDTO(" +
            "cus.fullName, cus.phoneNumber, m.movieName, c.cinemaName, tk.ticketID, c.cinemaID, st.showtimeID) " +
            "FROM Customer cus " +
            "JOIN cus.transactionBookings trans " +
            "JOIN trans.booking bk " +
            "JOIN bk.tickets tk " +
            "JOIN tk.showTime st " +
            "JOIN st.cinema c " +
            "JOIN st.movie m")
    List<TicketWithCustomerDTO> findAllTicket();

    // by MovieID
    @Query("SELECT tk from Ticket tk " +
            "join tk.showTime st " +
            "JOIN st.cinema c " +
            "WHERE c.cinemaID = :cinemaID ")
    List<Ticket> findAllByCinemaID(@Param("cinemaID") String cinemaID);

}
