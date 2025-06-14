package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.model.CinemaRoom;
import com.example.Movie_Ticket_Website.repository.CinemaRoomRepository;
import com.example.Movie_Ticket_Website.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaRoomDAO {
    @Autowired
    private CinemaRoomService cinemaRoomService;

    public void All(){
        List<CinemaRoom> cinemaRoomList = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE("", "", "");
    }

}
