package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.TicketDetailService;
import com.example.Movie_Ticket_Website.service.TicketService;
import com.example.Movie_Ticket_Website.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminHomeDAO {
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketDetailService ticketDetailService;


    public void all (){
        List<UserLogin> getUserOnl = userLoginService.getAllActiveUserLogins();
        long getTicketQuantity = ticketService.getTicketCount();
        double getTotalEarning = ticketDetailService.totalPriceTicketDetails();
        double getTotalMovie = movieService.getTotalMovie();
        List<MovieEaringDTO> getFilmEaring = movieService.getMovieEarings();
    }
}
