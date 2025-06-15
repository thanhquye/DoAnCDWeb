package com.example.Movie_Ticket_Website;

import com.example.Movie_Ticket_Website.dto.*;
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

	@Autowired
	private CustomerService customerService;

	@Autowired
	private SeatService seatService;

	@Autowired
	private ShowTimeService showTimeService;


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
		List<Ticket> tickets = ticketService.getTicketsByCinemaID("cnm1");
		for (Ticket ticket : tickets) {
			System.out.println(ticket.getTicketID());
		}
	}
	@Test
    void totaTicketsPrice() {
		List<TicketWithMovieDTO> getByTID = ticketDetailService.getTicketDetailByTicketId("tk1");
		for (TicketWithMovieDTO ticketWithMovieDTO : getByTID) {
			System.out.println(ticketWithMovieDTO.getPrice());
		}
	}
	@Test
    void top10Movie() {
		List<MovieWithMediaDTO> movies = movieService.getMostPopularMovies(3);
		for (MovieWithMediaDTO movie : movies) {
			System.out.println(movie.getMovieName());
		}
	}
	@Test
    void findMovieByName() {
		List<Movie> movies = movieService.getAllMovieByName("Kẻ ăn Hồn");
		for (Movie movie : movies) {
			System.out.println(movie.getMovieName());
		}

	}
	@Test
    void checkMovie() {
		Movie movie = new Movie();
		movie.setMovieID("M001");
		movie.setMovieName("Avengers: Endgame");
		movie.setMovieCategory("Action");
		movie.setReleaseDate("2025-06-15");
		movie.setDirector("Anthony Russo");
		movie.setDuration("180");
		movie.setCountry("USA");
		movie.setMovieDescription("The final battle...");
		movie.setMovieContent("Tony Stark saves the world...");
		movie.setIsPublished(1);
		movie.setMovieScore(9.5);
		// Khởi tạo media
		MovieMediaLink mediaLink = new MovieMediaLink();
		mediaLink.setMovieMediaLinkID("ML001");
		mediaLink.setLinkMovieTrailer("https://youtube.com/trailer");
		mediaLink.setLinkMovieImage("https://image.com/poster.jpg");

		Boolean success = movieService.addNewMovie(movie, mediaLink, "At1");
		System.out.println(success);

	}
	@Test
    void getAllCategory() {
		List<String> list = movieService.getAllMovieYear();
		for (String c : list) {
			System.out.println(c);
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
	@Test
    void getCustomerByUserID() {
		Customer customer = new Customer("Cus2", "SANG", "Nam" , "Hà nội", "0912827812", "2003-03-23");
		boolean cus = customerService.updateCustomer(customer);
		System.out.println(cus);

	}

	@Test
    void getseat() {
		List<Seat> seats = seatService.getSeatByMID_CNAME_DATE_RNAME_TIME("Mv1", "cnm1", "2023-12-22", "Phòng 4", "17:00:00");
		for (Seat seat : seats) {
			System.out.println(seat.getSeatName());
		}

	}
	@Test
    void getShowtime() {
		List<ShowTime> showTimes = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME("Mv1", "cnm1", "2023-12-22", "Phòng 4");
		for (ShowTime showTime : showTimes) {
			System.out.println(showTime.getMovie().getMovieName());
		}

	}

}
