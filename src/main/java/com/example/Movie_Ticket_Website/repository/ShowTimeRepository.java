package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime, String> {

    @Query("select st from ShowTime st " +
            "join FETCH st.cinema c " +
            "JOIN FETCH st.movie m " +
            "WHERE c.cinemaName = :cinemaName " +
            "and m.movieID = :movieID")
    List<ShowTime> findShowtimeByCinemaIDAndMovieID(@Param("movieID") String movieID,@Param("cinemaName") String cinemaName);

    @Query("select st from ShowTime st " +
            "join FETCH st.cinema c " +
            "JOIN FETCH st.movie m " +
            "join fetch c.cinemaRooms cr " +
            "WHERE m.movieID = :movieID " +
            "and c.cinemaName = :cinemaName " +
            "and st.showDate = :date " +
            "and cr.roomName = :roomName")
    List<ShowTime> findShowtimeByMID_CNAME_DATE_RNAME(
            @Param("movieID") String movieID,
            @Param("cinemaName") String cinemaName,
            @Param("date") String date,
            @Param("roomName") String roomName
    );

    @Query("select st from ShowTime st join st.movie m " +
            "where st.showDate =:showDate and st.startTime =:startTime and m.movieID =:movieID")
    ShowTime findSTByDateTimeMovieID(@Param("showDate") String showDate,@Param("startTime") String startTime, @Param("movieID") String movieID);
}
