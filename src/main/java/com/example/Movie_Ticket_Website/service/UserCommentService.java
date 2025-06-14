package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.repository.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommentService {
    @Autowired
    private UserCommentRepository userCommentRepository;

    public UserCommentService(UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }
}
