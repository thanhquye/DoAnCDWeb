package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeService {
    private ShowTimeRepository showTimeRepository;

    @Autowired
    public ShowTimeService(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }
}
