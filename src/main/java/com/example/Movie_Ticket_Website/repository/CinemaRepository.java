package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, String> {

    List<Cinema> findAllByCinemaName(String cinemaName);

    Cinema getCinemasByCinemaID(String cinemaID);

    @Query("SELECT new com.example.Movie_Ticket_Website.model.Cinema(" +
            "c.cinemaID, c.cinemaName, c.location) " +
            "FROM Cinema c " +
            "JOIN c.showTimes st " +
            "JOIN st.movie m " +
            "WHERE m.movieID = :movieId")
    List<Cinema> getCinemasByMovieId(@Param("movieId") String movieId);


    // lấy most popular
    List<Cinema> findTop2By();


}
