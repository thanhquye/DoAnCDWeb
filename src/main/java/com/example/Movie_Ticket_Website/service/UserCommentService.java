package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.UserComment;
import com.example.Movie_Ticket_Website.repository.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<UserCommentWithMovieDTO> getPopularComment(int number) {
        Pageable pageable = PageRequest.of(0, number);
        return userCommentRepository.findPopularComment(pageable);
    }
}
