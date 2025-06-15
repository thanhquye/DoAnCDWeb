package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.ShowTime;
import com.example.Movie_Ticket_Website.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeDAO {

    @Autowired
    private ShowTimeService showTimeService;

    public void all(){
        List<ShowTime> getShowtimeByCinemaIDAndMovieID = showTimeService.getShowtimeByCinemaIDAndMovieID("", "");
        List<ShowTime> ShowtimeByMID_CNAME_DATE_RNAME = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME("", "", "", "");

    }
}
