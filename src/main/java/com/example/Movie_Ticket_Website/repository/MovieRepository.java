package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByMovieNameContaining(String name);
    List<Movie> findByMovieCategory(String category);
    List<Movie> findByIsPublished(int isPublished);
    Movie findByMovieID(String movieID);

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country,\n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) FROM Movie m LEFT JOIN MovieMediaLink ml ON m.movieID = ml.movie.movieID")
    List<MovieWithMediaDTO> findAllMoviesWithLinksDTO();

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieEaringDTO(" +
            "m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.country, m.movieScore, SUM(td.price)) " +
            "FROM Movie m " +
            "JOIN m.showTimes st " +
            "JOIN st.ticket tk " +
            "JOIN tk.ticketDetail td " +
            "GROUP BY m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.country, m.movieScore " +
            "ORDER BY SUM(td.price) DESC")
    List<MovieEaringDTO> getMovieEarning(Pageable pageable);



}
