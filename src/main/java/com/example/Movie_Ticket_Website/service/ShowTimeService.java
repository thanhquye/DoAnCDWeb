package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.ShowTime;
import com.example.Movie_Ticket_Website.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeService {
    private ShowTimeRepository showTimeRepository;

    @Autowired
    public ShowTimeService(ShowTimeRepository showTimeRepository) {
        this.showTimeRepository = showTimeRepository;
    }

    public List<ShowTime> getShowtimeByCinemaIDAndMovieID(String movieID, String cinemaName) {
        return showTimeRepository.findShowtimeByCinemaIDAndMovieID(movieID, cinemaName);
    }

    public List<ShowTime> getShowtimeByMID_CNAME_DATE_RNAME(String movieID, String cinemaName, String date, String roomName) {
        return showTimeRepository.findShowtimeByMID_CNAME_DATE_RNAME(movieID, cinemaName, date, roomName);
    }
    public ShowTime getShowTimeByDayAndStartTime(String day, String startTime, String movieID) {
        return showTimeRepository.findSTByDateTimeMovieID(day, startTime, movieID);
    }
}
