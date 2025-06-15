package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingDetailService {
    private BookingDetailRepository bookingDetailRepository;

    @Autowired
    public BookingDetailService(BookingDetailRepository bookingDetailRepository) {
        this.bookingDetailRepository = bookingDetailRepository;
    }
}
