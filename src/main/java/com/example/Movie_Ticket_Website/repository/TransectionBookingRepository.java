package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Customer;
import com.example.Movie_Ticket_Website.model.TransactionBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransectionBookingRepository extends JpaRepository<TransactionBooking, String> {

    @Query("select trans from TransactionBooking trans " +
            "join FETCH trans.customer cus " +
            "join FETCH cus.userLogin user " +
            "WHERE user.userId = :userID")
    List<TransactionBooking> findByUserID(@Param("userID") String userID);

    @Query("select trans from TransactionBooking trans " +
            "join FETCH trans.customer cus " +
            "join FETCH cus.userLogin user " +
            "WHERE user.userId = :userID " +
            "and trans.transactionID = :transactionID")
    List<TransactionBooking> findByUserIDAndTransactionID(@Param("userID") String userID,@Param("transactionID") String transactionID);
}
