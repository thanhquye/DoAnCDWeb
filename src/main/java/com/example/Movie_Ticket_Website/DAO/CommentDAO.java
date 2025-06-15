package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentDAO {
    @Autowired
    private UserCommentService userCommentService;

    public void all(){
        List<CommentDTO> comments = userCommentService.getAllComments();
        List<CommentDTO> commentByMovieIDs = userCommentService.getCommentsByMovieId("Mv3");
    }
}
