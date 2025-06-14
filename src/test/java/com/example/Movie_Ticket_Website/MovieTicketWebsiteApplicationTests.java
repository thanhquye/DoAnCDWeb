package com.example.Movie_Ticket_Website;

import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Actor;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieTicketWebsiteApplicationTests {
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketDetailService ticketDetailService;

	@Autowired
	private MovieService movieService;

	@Test
	void contextLoads() {
	}

	@Test
    void getMovies() {
		List<UserLogin> userLogins = userLoginService.getAllActiveUserLogins();
		for (UserLogin userLogin : userLogins) {
			System.out.println(userLogin);
		}
	}
	@Test
    void countTickets() {
		long count = ticketService.getTicketCount();
		System.out.println(count);
	}
	@Test
    void totaTicketsPrice() {
		long count = ticketDetailService.totalPriceTicketDetails();
		System.out.println(count);
	}
	@Test
    void top10Movie() {
		List<MovieEaringDTO> top10 = movieService.getMovieEarings();
		for (MovieEaringDTO movieEaringDTO : top10) {
			System.out.println(movieEaringDTO.getMovieName());
		}
	}

}
