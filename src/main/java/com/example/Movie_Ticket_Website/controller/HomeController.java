package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.*;
import com.example.Movie_Ticket_Website.service.CartService;
import com.example.Movie_Ticket_Website.service.CinemaService;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private UserCommentService userCommentService;

    @Autowired
    private CartService cartService;


    public  List<MovieWithMediaDTO> newestMovies, publishedMovies, unPublishedMovies, popularMovies, movieListForCNameAndShowtime;
    public  List<Cinema>  allCinema, top2Cinema, searchedResultCinemaList;
    public  List<UserCommentWithMovieDTO> comments ;
    public  String cinemaSearchText = "";

    @GetMapping
    public String homeRedirect(@RequestParam(name = "action", required = false) String action,
                               @RequestParam(name = "cid", required = false) String cid,
                               @RequestParam(name = "cinemaName", required = false) String cinemaName,
                               @RequestParam(name = "date", required = false) String date,
                               HttpSession session, Model model) {
        if (session.getAttribute("pageName") != null) {
            session.removeAttribute("pageName");
        } else {
            session.setAttribute("pageName", "homePage");
        }

        if (action == null) action = "direct";

        return switch (action) {
            case "direct" -> redirectToHomePage(session,model);
            case "show-cinemaShowtime" ->showCinemaName(cid,session,model);
            case "show-cinemaDetail" ->showCinemaDetail(cinemaName,model);
            case "showCinemaNameAjax" ->showCinemaNameAjax(cid,model);
            case "showShowTime" ->showShowTime(cid,date,session,model);
            case "cinemaSearch" ->cinemaSearchAction(cid,date, cinemaName,session,model);
            case "logout" ->logout(session,model);
            default -> "redirect:/home?action=direct";
        };
    }

    private String logout(HttpSession session, Model model) {
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
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // process : show all cinema
        model.addAttribute("txtHistory", "");
        cinemaSearchText = "";
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("searchedResultCinemaList",null);
        model.addAttribute("isShowAllCinema",true);

        // process : logout
        if(session.getAttribute("user") != null && session.getAttribute("userName") != null) {
            session.removeAttribute("user");
            session.removeAttribute("userName");
            session.invalidate();
        }

        return "home";

    }

    private String cinemaSearchAction(String cid, String date,String cinemaName,HttpSession session, Model model) {
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
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // process right box data
        Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
        model.addAttribute("cinemaDetail",cinemaDetail);
        model.addAttribute("wantedBookDate", date);
        movieListForCNameAndShowtime = movieService.getMovieForCinemaAndShowtime(cid,date); // danh sach cac phim cua cinema co cid trong thoi gian date
        if(movieListForCNameAndShowtime.size() != 0) {
            model.addAttribute("movieListForCNameAndShowtime",movieListForCNameAndShowtime);
        }

        // main process : show detail cinema
        model.addAttribute("cinemaDetail",cinemaDetail);

        // main process : show showtime of detail cinema
        model.addAttribute("cinemaDetail",cinemaDetail);
        model.addAttribute("movieListForCNameAndShowtime",session.getAttribute("movieListForCNameAndShowtime"));

        // main process : search cinema by name
        cinemaSearchText = cinemaName;
        model.addAttribute("txtHistory", cinemaName);
        searchedResultCinemaList = cinemaService.getCinemaByName(cinemaName);
        int searchedResultCinemaListSize = searchedResultCinemaList.size();
        model.addAttribute("searchedResultCinemaList", searchedResultCinemaList);
        session.setAttribute("searchedResultCinemaList", searchedResultCinemaList);
        model.addAttribute("searchedResultCinemaListSize", searchedResultCinemaListSize);

        return "home";
    }

    // khi click vào 1 ngày hiện ra lịch chiếu phim trong ngày đó của rạp đó
    private String showShowTime(String cid,
            String date,
            HttpSession session,
            Model model) {
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
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // process show searched cinema
        searchedResultCinemaList = cinemaService.getCinemaByName(cinemaSearchText);
        int searchedResultCinemaListSize = searchedResultCinemaList.size();
        model.addAttribute("searchedResultCinemaList", searchedResultCinemaList);
//        session.setAttribute("searchedResultCinemaList", searchedResultCinemaList);
        model.addAttribute("searchedResultCinemaListSize", searchedResultCinemaListSize);
        model.addAttribute("txtHistory", cinemaSearchText);

        // main process : show showtimes of detail cinema
        if(!cid.equals("") && !date.equals("")) {
            Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
            model.addAttribute("cinemaDetail",cinemaDetail);
            model.addAttribute("wantedBookDate", date);
            movieListForCNameAndShowtime = movieService.getMovieForCinemaAndShowtime(cid,date); // danh sach cac phim cua cinema co cid trong thoi gian date
            model.addAttribute("movieListForCNameAndShowtime",movieListForCNameAndShowtime);
            session.setAttribute("movieListForCNameAndShowtime",movieListForCNameAndShowtime);
        }
        return "home";

    }

    @ResponseBody
    private String showCinemaNameAjax(String cid, Model model) {
        try {
            Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
            return "<h2 style=\"font-size: 25px;padding-bottom: 5px\"><i class='fa-solid fa-film'></i> "
                    + cinemaDetail.getCinemaName() + "  </h2>\n" +
                    "<h4 style=\"font-size: 17px; font-weight: lighter;padding-bottom: 10px\">  "
                    + cinemaDetail.getLocation() + "</h4>";
        } catch (Exception e) {
            e.printStackTrace();
            return "<p>Error occurred while loading cinema details.</p>";
        }
    }

    private String showCinemaDetail(String cinemaName,
                                    Model model) {
        List<Cinema> list = cinemaService.getCinemaByName(cinemaName);
        int size = list.size();
        model.addAttribute("resCinemaList",list);
        model.addAttribute("resCinemaListSize",size);
        return "home";

    }

    private String showCinemaName(String cid,
                                  HttpSession session,
                                  Model model) {
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
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // main process : show detail cinema
        Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
        model.addAttribute("cinemaDetail",cinemaDetail);

        // main process : search cinema by name
        searchedResultCinemaList = cinemaService.getCinemaByName(cinemaSearchText);
        model.addAttribute("txtHistory", cinemaSearchText);

        int searchedResultCinemaListSize = searchedResultCinemaList.size();
        model.addAttribute("searchedResultCinemaList", searchedResultCinemaList);
        session.setAttribute("searchedResultCinemaList", searchedResultCinemaList);
        model.addAttribute("searchedResultCinemaListSize", searchedResultCinemaListSize);

        return "home";

    }

    private String redirectToHomePage(HttpSession session, Model model) {
        model.addAttribute("top4NewestMovies", movieService.getNewestFilms(5));
        model.addAttribute("publishedMovies", movieService.getPublishedMovie(1, 5));
        model.addAttribute("unPublishedMovies", movieService.getPublishedMovie(0, 4));
        model.addAttribute("popularMovies", movieService.getMostPopularMovies(3));
        model.addAttribute("top2Cinema", cinemaService.getMostPopularCinema());
        model.addAttribute("comments", userCommentService.getPopularComment(3));
        model.addAttribute("txtHistory", "");
        model.addAttribute("allCinema", cinemaService.getAllCinema());
        model.addAttribute("searchedResultCinemaList", null);
        model.addAttribute("isShowAllCinema", true);

        UserLogin userLogin = (UserLogin) session.getAttribute("user");
        if (userLogin != null) {
            session.setAttribute("cartSize", cartService.getCartByUserID(userLogin.getUserId()).size());;
        }else{
            session.setAttribute("cartSize", 0);;
        }


        return "home";
    }
}

