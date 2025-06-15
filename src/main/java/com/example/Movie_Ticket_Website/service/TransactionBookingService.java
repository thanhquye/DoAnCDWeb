package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.TransactionBooking;
import com.example.Movie_Ticket_Website.repository.TransectionBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionBookingService {
    private TransectionBookingRepository transectionBookingRepository;

    @Autowired
    public TransactionBookingService(TransectionBookingRepository transectionBookingRepository) {
        this.transectionBookingRepository = transectionBookingRepository;
    }
    public List<TransactionBooking> getAllTransectionBookingByUserID(String userID) {
        return transectionBookingRepository.findByUserID(userID);
    }

    public List<TransactionBooking> getTransactionBookingByUserID_TID(String userID, String transactionID) {
        return transectionBookingRepository.findByUserIDAndTransactionID(userID, transactionID);
    }
}
