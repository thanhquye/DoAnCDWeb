package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.UserComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, String> {

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.CommentDTO(c.fullName, m.movieName, uc.commentID, c.customerID, m.movieID, uc.commentText) " +
            "FROM UserComment uc " +
            "JOIN uc.customer c " +
            "JOIN uc.movie m")
    List<CommentDTO> getAllComment();


    @Query("SELECT new com.example.Movie_Ticket_Website.dto.CommentDTO(c.fullName, m.movieName, uc.commentID, c.customerID, m.movieID, uc.commentText) " +
            "FROM UserComment uc " +
            "JOIN uc.customer c " +
            "JOIN uc.movie m " +
            "WHERE m.movieID = :movieId")
    List<CommentDTO> getAllCommentByMovieID(@Param("movieId") String movieId);

    @Query("select new com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO(" +
            "uc.commentID, m.movieID, m.movieName, ml.linkMovieImage, uc.commentText)" +
            "from UserComment uc " +
            "JOIN uc.movie m " +
            "JOIN m.movieMediaLink ml")
    List<UserCommentWithMovieDTO> findPopularComment(Pageable pageable);

    //admin
    @Modifying
    @Query("DELETE FROM UserComment uc WHERE uc.commentID = :commentID")
    void deleteCommentByCustomId(@Param("commentID") String commentID);

}
