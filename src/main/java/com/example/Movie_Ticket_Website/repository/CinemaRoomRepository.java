package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, String> {

    @Query("SELECT DISTINCT new com.example.Movie_Ticket_Website.model.CinemaRoom(cr.cinemaRoomID, cr.roomName) " +
            "FROM CinemaRoom cr " +
            "JOIN cr.cinema c " +
            "JOIN c.showTimes st " +
            "JOIN st.movie m " +
            "WHERE m.movieID = ?1 AND c.cinemaName = ?2 AND st.showDate = ?3")
    List<CinemaRoom> findCinemaRoomsOfDay(String movieId, String cinemaName, String showDate);


    @Query("select cinemaRoomID from CinemaRoom where roomName = :cinemaRoomName ")
    String findCinemaIDByCinemaRoomName(@Param("cinemaRoomName") String cinemaRoomName);

    CinemaRoom findByRoomName(String roomName);
}
