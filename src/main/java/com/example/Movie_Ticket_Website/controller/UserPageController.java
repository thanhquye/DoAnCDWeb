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
@RequestMapping("/userPage")
public class UserPageController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private ShowTimeService showTimeService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private  TransactionBookingService transactionBookingService;

    @Autowired
    private CinemaRoomService cinemaRoomService;

    public static List<Cinema> allCinema;
    public static List<UserCommentWithMovieDTO> comments ;

    @GetMapping
    public String userPage(@RequestParam(name = "action", required = false) String action,
                           @RequestParam(name = "cid", required = false) String cid,
                           @RequestParam(name = "cinemaName", required = false) String cinemaName,
                           @RequestParam(name = "movieID", required = false) String mid,
                           @RequestParam(name = "date", required = false) String date,
                           @RequestParam(name = "time", required = false) String time,
                           @RequestParam(name = "cinemaRoomName", required = false) String cinemaRoomName,
                           @RequestParam(name = "seat", required = false) String seat,
                           @RequestParam(name = "transName", required = false) String transName,
                           HttpSession session, Model model) {
        return switch (action) {
            case "init" -> initData(mid,session,model);
            case "changeToProfileSetting" -> changeToProfileSetting(mid, cinemaName, session, model);
            case "searchBy_transName" -> searchBy_transName(mid, transName, session, model);
            case "updateUser" -> updateUser(mid, cinemaName,session, model);
            case "changeToCheckout" -> changeToCheckout( mid, cinemaName, date,time,cinemaRoomName, seat, session, model);
            case "changeToETicket" -> changeToETicket(mid, cinemaName, date, time,cinemaRoomName,seat, session, model);
            default -> "redirect:/home?action=direct";
        };


    }

    private String changeToETicket(String movieID, String cinemaName, String curDate,String time,String cinemaRoomName,String seatName , HttpSession session, Model model) {
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
            return "/login.jsp";
        }
        session.setAttribute("userEmail",user.getEmail());
        Customer customer = customerService.getCustomerByUserId(user.getUserId());
        session.setAttribute("customer",customer);
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments",payments);


        return "/showETicket.jsp";
    }

    private String changeToCheckout(String movieID,String cinemaName,String curDate, String time,String cinemaRoomName, String seatName,  HttpSession session, Model model) {
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
        // thực hiện thanh toán
        model.addAttribute("seatName",seatName);
        UserLogin user = (UserLogin) session.getAttribute("user");
        if(user == null) {
            return "login";
        }
        session.setAttribute("userEmail",user.getEmail());
        Customer customer = customerService.getCustomerByUserId(user.getUserId());
        session.setAttribute("customer",customer);
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments",payments);


        return "/checkoutTicket.jsp";
    }

    private String updateUser(String movieID, String cinemaName,HttpSession session, Model model) {
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
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);
        // main process : update user
        String name = (model.getAttribute("name") != null) ? (String) model.getAttribute("name") : "";
        String gender = (model.getAttribute("gender") != null) ? (String)model.getAttribute("gender") : "";
        String email = (model.getAttribute("email") != null) ?(String) model.getAttribute("email") : "";
        String phoneNumber = (model.getAttribute("phoneNumber") != null) ? (String)model.getAttribute("phoneNumber") : "";
        String address = (model.getAttribute("address") != null) ? (String)model.getAttribute("address") : "";
        String dob = (model.getAttribute("dob") != null) ? (String)model.getAttribute("dob") : "";
        String username = (model.getAttribute("username") != null) ? (String)model.getAttribute("username") : "";
        String password = (model.getAttribute("password") != null) ? (String)model.getAttribute("password") : "";

        UserLogin newUser = (UserLogin) session.getAttribute("user");
        newUser.setUserName(username);
        newUser.setEmail(email);
        newUser.setUserPassword(password);
        boolean updateUserStatus = userLoginService.updateUser(newUser);
        UserLogin user = updateUserStatus ? newUser : (UserLogin) session.getAttribute("user") ;
        session.setAttribute("user",user);

        Customer newCustomer = (Customer) session.getAttribute("customer");
        newCustomer.setFullName(name);
        newCustomer.setGender(gender);
        newCustomer.setPhoneNumber(phoneNumber);
        newCustomer.setAddress(address);
        newCustomer.setDob(dob);
        boolean updateCustomerStatus = customerService.updateCustomer(newCustomer);
        Customer customer = updateCustomerStatus ? newCustomer : (Customer) session.getAttribute("customer") ;
        session.setAttribute("customer",customer);

        if(updateUserStatus || updateCustomerStatus) {
            session.setAttribute("updateStatus","1");
        } else {
            session.setAttribute("updateStatus","0");
        }

        return  "/userView/userPage_ProfileSetting.jsp";
    }

    private String searchBy_transName(String movieID,String transID,HttpSession session,  Model model) {
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
        // main process :
        UserLogin user = (UserLogin) session.getAttribute("user");
        // process : search by transID
        if(!transID.equals("")){
            List<TransactionBooking> tList = transactionBookingService.getTransactionBookingByUserID_TID(user.getUserId(), transID);
            model.addAttribute("transList",tList);
        } else {
            List<TransactionBooking> transList = transactionBookingService.getAllTransectionBookingByUserID(user.getUserId());
            model.addAttribute("transList",transList);
        }

        return "/userView/userPage.jsp";
    }

    private String changeToProfileSetting(String movieID, String cinemaName,HttpSession session, Model model) {
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
//        Cinema cinema = cinemaDAO.getCinemaByName(cinemaName).get(0);
//        model.addAttribute("cinemaLocation",cinema.getLocation());
        List<ShowTime> showtimes = showTimeService.getShowtimeByCinemaIDAndMovieID(movieID,cinemaName);
        List<String> showtimesDate = new ArrayList<>();
        for(ShowTime st : showtimes) {
            showtimesDate.add(st.getShowDate());
            System.out.println(st.getShowDate());
        }
        model.addAttribute("showtimesDate",showtimesDate);

        return "/userView/userPage_ProfileSetting";
    }

    private String initData(String movieID, HttpSession session, Model model) {
// process : get Movie to process
        String fMovieID;
        if(movieID.isEmpty()) {
           fMovieID = "Mv1";
        }else {
            fMovieID = movieID;
        }
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
        // main process :
        UserLogin user = (UserLogin) session.getAttribute("user");
        List<TransactionBooking> transList = transactionBookingService.getAllTransectionBookingByUserID(user.getUserId());
        model.addAttribute("transList",transList);
        return "userView/userPage";
    }
}
