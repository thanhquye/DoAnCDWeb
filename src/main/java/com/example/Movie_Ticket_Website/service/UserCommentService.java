package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.model.UserComment;
import com.example.Movie_Ticket_Website.repository.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentService {
    private UserCommentRepository userCommentRepository;

    @Autowired
    public UserCommentService(UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }

    public List<CommentDTO> getAllComments() {
        return userCommentRepository.getAllComment();
    }

    public List<CommentDTO> getCommentsByMovieId(String movieId) {
        return userCommentRepository.getAllCommentByMovieID(movieId);
    }
}
