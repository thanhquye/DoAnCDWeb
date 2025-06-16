package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.*;
import com.example.Movie_Ticket_Website.service.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bookingTicket")
public class BookingController {
    @Autowired
    CinemaService cinemaService;
    @Autowired
    MovieService movieService;
    @Autowired
    ShowTimeService showTimeService;
    @Autowired
    SeatService seatService;
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    CustomerService customerService;
    @Autowired
    UserCommentService userCommentService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    CinemaRoomService cinemaRoomService;

    public static List<UserCommentWithMovieDTO> comments ;
    public static List<MovieWithMediaDTO> newestMovies, publishedMovies, unPublishedMovies, popularMovies, movieListForCNameAndShowtime;
    public static List<Cinema> top2Cinema, allCinema;
    public static String cinemaSearchText = "";

    @GetMapping
    public String movieDetailRedirect(@RequestParam(name = "action", required = false) String action,
                                      @RequestParam(name = "cid", required = false) String cid,
                                      @RequestParam(name = "cinemaName", required = false) String cinemaName,
                                      @RequestParam(name = "movieID", required = false) String mid,
                                      @RequestParam(name = "date", required = false) String date,
                                      @RequestParam(name = "time", required = false) String time,
                                      @RequestParam(name = "cinemaRoomName", required = false) String cinemaRoomName,
                                      @RequestParam(name = "seatName", required = false) String seatName,
                                      HttpSession session, Model model){
        return switch (action){
            case "init" -> initData(mid, session, model);
            case "showShowTimeForCinema" -> showShowTimeForCinema(mid, cinemaName,session, model);
            case "showTimeInThisDate" -> showTimeInThisDate(mid, cinemaName, date, session, model);
            case "changeToSeatBooking" -> changeToSeatBooking(mid,cinemaName, date, time, cinemaRoomName, session, model);
            case "changeToCheckout" -> changeToCheckout(mid,cinemaName, date, time, cinemaRoomName, seatName,session, model);
            case "changeToETicket" -> changeToETicket(mid,cinemaName, date, time, cinemaRoomName, seatName, session, model);
            default -> "redirect:/home?action=direct";

        };
    }

    private String changeToETicket(String movieID,String cinemaName,String curDate,String time, String cinemaRoomName, String seatName, HttpSession session, Model model) {
        // process : get Movie to process
        MovieWithMediaDTO movie = movieService.getMovieByID(movieID);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("movieID", movieID);
        // lấy danh sách all rạp chiếu phim có chiếu phim này
        List<Cinema> cinemaListGetByMovie = cinemaService.getCinemaByMovieID(movieID);
        List<String> cinemaNameList = new ArrayList<>();
        for(Cinema c : cinemaListGetByMovie) {
            cinemaNameList.add(c.getCinemaName());
        }
        model.addAttribute("cinemaListGetByMovieSize", cinemaNameList.size());
        model.addAttribute("cinemaListGetByMovie", cinemaNameList);
        // lấy lịch chiếu phim của rạp đó
        model.addAttribute("cinemaName", cinemaName);
        Cinema cinema = cinemaService.getCinemaByName(cinemaName).get(0);
        model.addAttribute("cinemaLocation",cinema.getLocation());
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);
        // lấy ra thời gian chiếu và tên phòng rạp trong ngày đó
        model.addAttribute("curDate",curDate);
        List<CinemaRoom> cinemaRoomNameList = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE(movieID,cinemaName,curDate);
        Map<String, List<String>> map = new HashMap<>();
        for(CinemaRoom c : cinemaRoomNameList){
            List<ShowTime> cName = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME(movieID,cinemaName,curDate,c.getRoomName());
            List<String> startTimeList = new ArrayList<>();
            for(ShowTime s : cName) {
                startTimeList.add(s.getStartTime());
            }
            map.put(c.getRoomName(),startTimeList);
            System.out.println(c.getRoomName());
        }
        model.addAttribute("mapRoomAndTime",map);
        // thực hiện đặt ghế và chọn dịch vụ đi kèm vé
        model.addAttribute("time",time);
        model.addAttribute("cinemaRoomName",cinemaRoomName);
        List<Seat> seats = seatService.getSeatByMID_CNAME_DATE_RNAME_TIME(movieID,cinemaName,curDate,cinemaRoomName,time);
        model.addAttribute("seats",seats);
        // thực hiện thanh toán
        model.addAttribute("seatName",seatName);
        model.addAttribute("movieImage",movie.getLinkMovieImage());
        UserLogin user = (UserLogin) session.getAttribute("user");
        if(user == null) {
            return "login";
        }
        session.setAttribute("userEmail",user.getEmail());
        Customer customer = customerService.getCustomerByUserId(user.getUserId());
        session.setAttribute("customer",customer);
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments",payments);


        return "showETicket";
    }

    private String changeToCheckout(String movieID,String cinemaName, String curDate,String time, String cinemaRoomName,String seatName,  HttpSession session, Model model) {
        Movie movie = movieService.getMovieByMovieID(movieID);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("movieID", movieID);
        // lấy danh sách all rạp chiếu phim có chiếu phim này
        List<Cinema> cinemaListGetByMovie = cinemaService.getCinemaByMovieID(movieID);
        List<String> cinemaNameList = new ArrayList<>();
        for(Cinema c : cinemaListGetByMovie) {
            cinemaNameList.add(c.getCinemaName());
        }
        model.addAttribute("cinemaListGetByMovieSize", cinemaNameList.size());
        model.addAttribute("cinemaListGetByMovie", cinemaNameList);
        // lấy lịch chiếu phim của rạp đó
        model.addAttribute("cinemaName", cinemaName);
        Cinema cinema = cinemaService.getCinemaByName(cinemaName).get(0);
        model.addAttribute("cinemaLocation",cinema.getLocation());
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);
        // lấy ra thời gian chiếu và tên phòng rạp trong ngày đó
        model.addAttribute("curDate",curDate);
        List<CinemaRoom> cinemaRoomNameList = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE(movieID,cinemaName,curDate);
        Map<String, List<String>> map = new HashMap<>();
        for(CinemaRoom c : cinemaRoomNameList){
            List<ShowTime> cName = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME(movieID,cinemaName,curDate,c.getRoomName());
            List<String> startTimeList = new ArrayList<>();
            for(ShowTime s : cName) {
                startTimeList.add(s.getStartTime());
            }
            map.put(c.getRoomName(),startTimeList);
        }
        model.addAttribute("mapRoomAndTime",map);
        // thực hiện đặt ghế và chọn dịch vụ đi kèm vé
        model.addAttribute("time",time);
        model.addAttribute("cinemaRoomName",cinemaRoomName);
        List<Seat> seats = seatService.getSeatByMID_CNAME_DATE_RNAME_TIME(movieID,cinemaName,curDate,cinemaRoomName,time);
        model.addAttribute("seats",seats);
        // thực hiện thanh toán
        model.addAttribute("seatName",seatName);
        UserLogin user = (UserLogin) session.getAttribute("user");
        // xử lí khi người dùng đặt vé mà không đăng nhập
        if(user == null) {
            return "login";
        }
        session.setAttribute("userEmail",user.getEmail());
        Customer customer = customerService.getCustomerByUserId(user.getUserId());
        session.setAttribute("customer",customer);
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments",payments);


        return "checkoutTicket";
    }

    private String changeToSeatBooking(String movieID, String cinemaName,String curDate, String time, String cinemaRoomName, HttpSession session, Model model) {
        // process : get Movie to process
        Movie movie = movieService.getMovieByMovieID(movieID);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("movieID", movieID);
        // lấy danh sách all rạp chiếu phim có chiếu phim này
        List<Cinema> cinemaListGetByMovie = cinemaService.getCinemaByMovieID(movieID);
        List<String> cinemaNameList = new ArrayList<>();
        for(Cinema c : cinemaListGetByMovie) {
            cinemaNameList.add(c.getCinemaName());
        }
        model.addAttribute("cinemaListGetByMovieSize", cinemaNameList.size());
        model.addAttribute("cinemaListGetByMovie", cinemaNameList);
        // lấy lịch chiếu phim của rạp đó
        model.addAttribute("cinemaName", cinemaName);
        Cinema cinema = cinemaService.getCinemaByName(cinemaName).get(0);
        model.addAttribute("cinemaLocation",cinema.getLocation());
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);
        // lấy ra thời gian chiếu và tên phòng rạp trong ngày đó
        model.addAttribute("curDate",curDate);
        List<CinemaRoom> cinemaRoomNameList = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE(movieID,cinemaName,curDate);
        Map<String, List<String>> map = new HashMap<>();
        for(CinemaRoom c : cinemaRoomNameList){
            List<ShowTime> cName = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME(movieID,cinemaName,curDate,c.getRoomName());
            List<String> startTimeList = new ArrayList<>();
            for(ShowTime s : cName) {
                startTimeList.add(s.getStartTime());
            }
            map.put(c.getRoomName(),startTimeList);
        }
        model.addAttribute("mapRoomAndTime",map);
        // thực hiện đặt ghế và chọn dịch vụ đi kèm vé
        model.addAttribute("time",time);
        model.addAttribute("cinemaRoomName",cinemaRoomName);
        List<Seat> seats = seatService.getSeatByMID_CNAME_DATE_RNAME_TIME(movieID,cinemaName,curDate,cinemaRoomName,time);
        model.addAttribute("seats",seats);

        return "seatBooking";
    }

    private String showTimeInThisDate(String movieID, String cinemaName, String curDate,  HttpSession session, Model model) {
        // process : get Movie to process
        Movie movie = movieService.getMovieByMovieID(movieID);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("movieID", movieID);
        // lấy danh sách all rạp chiếu phim có chiếu phim này
        List<Cinema> cinemaListGetByMovie = cinemaService.getCinemaByMovieID(movieID);
        List<String> cinemaNameList = new ArrayList<>();
        for(Cinema c : cinemaListGetByMovie) {
            cinemaNameList.add(c.getCinemaName());
        }
        model.addAttribute("cinemaListGetByMovieSize", cinemaNameList.size());
        model.addAttribute("cinemaListGetByMovie", cinemaNameList);
        // lấy lịch chiếu phim của rạp đó
        model.addAttribute("cinemaName", cinemaName);
        Cinema cinema = cinemaService.getCinemaByName(cinemaName).get(0);
        model.addAttribute("cinemaLocation",cinema.getLocation());
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);
        // lấy ra thời gian chiếu và tên phòng rạp trong ngày đó
        model.addAttribute("curDate",curDate);
        List<CinemaRoom> cinemaRoomNameList = cinemaRoomService.getCinemaRoomNameByMID_CNAME_DATE(movieID,cinemaName,curDate);
        Map<String, List<String>> map = new HashMap<>();
        for(CinemaRoom c : cinemaRoomNameList){
            List<ShowTime> cName = showTimeService.getShowtimeByMID_CNAME_DATE_RNAME(movieID,cinemaName,curDate,c.getRoomName());
            List<String> startTimeList = new ArrayList<>();
            for(ShowTime s : cName) {
                startTimeList.add(s.getStartTime());
            }
            map.put(c.getRoomName(),startTimeList);
        }
        model.addAttribute("mapRoomAndTime",map);

        return "bookingTicket";
    }

    private String showShowTimeForCinema(String movieID, String cinemaName, HttpSession session, Model model) {
// process : get Movie to process
        Movie movie = movieService.getMovieByMovieID(movieID);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("movieID", movieID);
        // lấy danh sách all rạp chiếu phim có chiếu phim này
        List<Cinema> cinemaListGetByMovie = cinemaService.getCinemaByMovieID(movieID);
        List<String> cinemaNameList = new ArrayList<>();
        for(Cinema c : cinemaListGetByMovie) {
            cinemaNameList.add(c.getCinemaName());
        }
        model.addAttribute("cinemaListGetByMovieSize", cinemaNameList.size());
        model.addAttribute("cinemaListGetByMovie", cinemaNameList);
        // lấy lịch chiếu phim của rạp đó
        model.addAttribute("cinemaName", cinemaName);
        Cinema cinema = cinemaService.getCinemaByName(cinemaName).get(0);
        model.addAttribute("cinemaLocation",cinema.getLocation());
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);


        return "bookingTicket";
    }

    private String initData(String movieID, HttpSession session, Model model) {
        // process : get Movie to process
        Movie movie = movieService.getMovieByMovieID(movieID);
        model.addAttribute("movieName", movie.getMovieName());
        model.addAttribute("movieID", movieID);
        // lấy danh sách all rạp chiếu phim có chiếu phim này
        List<Cinema> cinemaListGetByMovie = cinemaService.getCinemaByMovieID(movieID);
        session.removeAttribute("status_getCinemaListOfThisMovie");

        if(cinemaListGetByMovie.size() == 0 || cinemaListGetByMovie == null) {

            newestMovies = movieService.getNewestFilms(5);
            publishedMovies = movieService.getPublishedMovie(1,5);
            unPublishedMovies = movieService.getPublishedMovie(0,4);
            popularMovies = movieService.getMostPopularMovies(3);
            allCinema = cinemaService.getAllCinema();
            top2Cinema = cinemaService.getMostPopularCinema();
            comments = userCommentService.getPopularComment(3);

            model.addAttribute("top4NewestMovies", newestMovies);
            model.addAttribute("publishedMovies", publishedMovies);
            model.addAttribute("unPublishedMovies", unPublishedMovies);
            model.addAttribute("popularMovies", popularMovies);
            model.addAttribute("top2Cinema",top2Cinema);
            model.addAttribute("comments",comments);

            // process : show all cinema
            model.addAttribute("txtHistory", "");
            cinemaSearchText = "";
            model.addAttribute("allCinema", allCinema);
            model.addAttribute("searchedResultCinemaList",null);
            model.addAttribute("isShowAllCinema",true);
            session.setAttribute("status_getCinemaListOfThisMovie", "0");
            return "home";
        } else {
            session.setAttribute("status_getCinemaListOfThisMovie", "1");
        }
        List<String> cinemaNameList = new ArrayList<>();
        for(Cinema c : cinemaListGetByMovie) {
            cinemaNameList.add(c.getCinemaName());
        }
        model.addAttribute("cinemaListGetByMovieSize", cinemaNameList.size());
        model.addAttribute("cinemaListGetByMovie", cinemaNameList);
        return "bookingTicket";
    }

}
