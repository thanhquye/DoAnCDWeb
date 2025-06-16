package com.example.Movie_Ticket_Website;

import com.example.Movie_Ticket_Website.dto.*;
import com.example.Movie_Ticket_Website.model.*;
import com.example.Movie_Ticket_Website.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private TransactionBookingService transactionBookingService;


    @Test
    void contextLoads() {
    }

    @Test
    void getMovies() {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId("user14");
        userLogin.setUserName("ThanhQUYEN");
        userLogin.setEmail("thanhquyen@email.com");
        userLogin.setUserPassword("thanhquyen");
        userLogin.setActive(true);
        userLogin.setAdmin(false);
        userLogin.setVerifyEmail(false);
        Boolean update = userLoginService.updateUser(userLogin);
        System.out.println(update);

    }

    @Test
    void countUser() {
        List<String> getUserID = userLoginService.getAllUserID();
        for (String userID : getUserID) {
            System.out.println(userID);
        }
    }

    @Test
    void countTickets() {
        List<Ticket> tickets = ticketService.getAllTicketByMovieID("cnm1");
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
        List<MovieWithMediaDTO> movies = movieService.getMovieForCinemaAndShowtime("cnm1", "2023-12-22");
        for (MovieWithMediaDTO movie : movies) {
            System.out.println(movie.getMovieName());
        }
    }

    @Test
    void findMovieByName() {
        List<CinemaRoom> cinemaRooms = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE("Mv1", "Mega GS Cao Thắng", "2025-06-17");
        for (CinemaRoom cinemaRoom : cinemaRooms) {
            System.out.println(cinemaRoom.getRoomName() + cinemaRoom.getCinemaRoomID());
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
        String movieID = "Mv2";
        String cinemaName = "Cinestar Quốc Thanh";
        String curDate = "2025-06-18";
        List<CinemaRoom> cinemaRoomNameList = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE(movieID, cinemaName, curDate);
        Map<String, List<String>> map = new HashMap<>();
        for (CinemaRoom c : cinemaRoomNameList) {
            List<ShowTime> cName = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME(movieID, cinemaName, curDate, c.getRoomName());
            List<String> startTimeList = new ArrayList<>();
            for (ShowTime s : cName) {
                startTimeList.add(s.getStartTime());
            }
            map.put(c.getRoomName(), startTimeList);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(key);

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
        List<UserCommentWithMovieDTO> getPopular = userCommentService.getPopularComment(3);
        for (UserCommentWithMovieDTO userComment : getPopular) {
            System.out.println(userComment.getMovieName());
        }

    }

    @Test
    void getCustomerByUserID() {
        Customer customer = new Customer("Cus2", "SANG", "Nam", "Hà nội", "0912827812", "2003-03-23");
        boolean cus = customerService.updateCustomer(customer);
        System.out.println(cus);

    }

    @Test
    void getseat() {
//        List<Seat> seats = seatService.getSeatByMovieID("Mv1");
//        for (Seat seat : seats) {
//            System.out.println(seat.getSeatName());
//        }

    }

    @Test
    void getShowtime() {
        List<ShowTime> showTimes = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME("Mv1", "cnm1", "2023-12-22", "Phòng 4");
        for (ShowTime showTime : showTimes) {
            System.out.println(showTime.getMovie().getMovieName());
        }

    }

    @Test
    void getTransByUserID() {
        List<TransactionBooking> transactionBookings = transactionBookingService.getTransactionBookingByUserID_TID("user1", "trans1");
        for (TransactionBooking transactionBooking : transactionBookings) {
            System.out.println(transactionBooking.getTotalPrice());
        }

    }
}

