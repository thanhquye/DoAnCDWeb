package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentDAO {
    @Autowired
    private UserCommentService userCommentService;

    public void all(){
        List<UserCommentWithMovieDTO> getMPopular = userCommentService.getPopularComment(3);
    }
}
