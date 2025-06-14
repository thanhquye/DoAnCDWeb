package com.example.Movie_Ticket_Website;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.*;
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

	@Autowired
	private CinemaService cinemaService;

	@Autowired
	private CinemaRoomService cinemaRoomService;

	@Autowired
	private UserCommentService userCommentService;

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
	@Test
    void findMovieByName() {
		List<Movie> movies = movieService.getMovieByName("Kẻ Ăn Hồn");
		for (Movie movie : movies) {
			System.out.println(movie.getMovieName());
		}

	}
	@Test
    void findCinemaByID() {
		List<Cinema> cinemas = cinemaService.getMostPopularCinema();
		for (Cinema cinema : cinemas) {
			System.out.println(cinema.getCinemaID());
		}

	}
	@Test
    void findCinemaRoomDay() {
		List<CinemaRoom> cinemas = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE("Mv1", "Cinestar Quốc Thanh", "2023-12-22");
		for (CinemaRoom cinema : cinemas) {
			System.out.println(cinema.getRoomName());
		}
	}
	@Test
    void getAllComment() {
		List<CommentDTO> commentDTOS = userCommentService.getCommentsByMovieId("Mv3");
		for (CommentDTO commentDTO : commentDTOS) {
			System.out.println(commentDTO.getCommentText());
		}

	}

}
