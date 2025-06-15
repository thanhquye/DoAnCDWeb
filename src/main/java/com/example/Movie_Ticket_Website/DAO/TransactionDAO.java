package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.TransactionBooking;
import com.example.Movie_Ticket_Website.service.TransactionBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDAO {
    @Autowired
    private TransactionBookingService transactionBookingService;

    public void all(){
        List<TransactionBooking> getByUserID = transactionBookingService.getAllTransectionBookingByUserID("user1");
        List<TransactionBooking> getByUserIDAndTransID = transactionBookingService.getTransactionBookingByUserID_TID("user1", "trans1");
    }
}
