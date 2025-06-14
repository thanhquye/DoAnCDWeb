package com.example.Movie_Ticket_Website;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Actor;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.service.ActorService;
import com.example.Movie_Ticket_Website.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieTicketWebsiteApplicationTests {
	@Autowired
	private ActorService actorService;

	@Test
	void contextLoads() {
	}

	@Test
    void getMovies() {
		List<Actor> actors = actorService.getAllActors();
		for (Actor actor : actors) {
			System.out.println(actor.getActorID());
		}
	}

}
