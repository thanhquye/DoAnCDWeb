package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.repository.TransectionBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransectionBookingService {
    @Autowired
    private TransectionBookingRepository transectionBookingRepository;

    public TransectionBookingService(TransectionBookingRepository transectionBookingRepository) {
        this.transectionBookingRepository = transectionBookingRepository;
    }
}
