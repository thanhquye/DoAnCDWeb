package com.example.Movie_Ticket_Website;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Actor;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.ActorService;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.TicketService;
import com.example.Movie_Ticket_Website.service.UserLoginService;
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

}
