package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.service.CinemaService;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/movieDetail")
public class MovieDetailController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired

    private UserCommentService userCommentService;
    public static List<MovieWithMediaDTO> newestMovies, publishedMovies, unPublishedMovies, popularMovies, allMovies, movieListForCNameAndShowtime;
    public static MovieWithMediaDTO movie;
    public static List<Cinema> allCinema, top2Cinema, searchedResultCinemaList;
    ;
    public static String cinemaSearchText = "";


    @GetMapping
    public String movieDetailRedirect(@RequestParam(name = "action", required = false) String action,
                                @RequestParam(name = "cid", required = false) String cid,
                                @RequestParam(name = "cinemaName", required = false) String cinemaName,
                                @RequestParam(name = "movieID", required = false) String mid,
                                @RequestParam(name = "date", required = false) String date,
                                @RequestParam(name = "category", required = false) String category,
                                @RequestParam(name = "country", required = false) String country,
                                @RequestParam(name = "year", required = false) String year,
                                HttpSession session, Model model) {
        return switch (action) {
            case "init" -> initData(mid, cid, model);
            case "show-cinemaShowtime" -> showCinemaName(cid, mid, session, model);
            case "show-cinemaDetail" -> searchCinemaAction(cinemaName, model);
            case "showShowTime" -> showShowTime(mid, cid, date, session, model);
            case "cinemaSearch" -> cinemaSearchAction(mid, cid, date, cinemaName, session, model);
            default -> "redirect:/home?action=direct";
        };
    }

    private String cinemaSearchAction(String mid,String cid,String date,String cinemaName, HttpSession session, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1, 5);
        unPublishedMovies = movieService.getPublishedMovie(0, 4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        top2Cinema = cinemaService.getMostPopularCinema();

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema", top2Cinema);

// main process : show movie detail
        movie = movieService.getMovieByID(mid);
       model.addAttribute("movie", movie);

        // process right box data
        Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
       model.addAttribute("cinemaDetail", cinemaDetail);
       model.addAttribute("wantedBookDate", date);
        movieListForCNameAndShowtime = movieService.getMovieForCinemaAndShowtime(cid, date); // danh sach cac phim cua cinema co cid trong thoi gian date
        if (movieListForCNameAndShowtime.size() != 0) {
           model.addAttribute("movieListForCNameAndShowtime", movieListForCNameAndShowtime);
        }
        // main process : show detail cinema
       model.addAttribute("cinemaDetail", cinemaDetail);

        // main process : show showtime of detail cinema
       model.addAttribute("cinemaDetail", cinemaDetail);
       model.addAttribute("movieListForCNameAndShowtime", session.getAttribute("movieListForCNameAndShowtime"));

        // main process : search cinema by name
        cinemaSearchText = cinemaName;
       model.addAttribute("txtHistory", cinemaName);
        searchedResultCinemaList = cinemaService.getCinemaByName(cinemaName);
        int searchedResultCinemaListSize = searchedResultCinemaList.size();
       model.addAttribute("searchedResultCinemaList", searchedResultCinemaList);
        session.setAttribute("searchedResultCinemaList", searchedResultCinemaList);
       model.addAttribute("searchedResultCinemaListSize", searchedResultCinemaListSize);

        return "movieDetail";
    }

    private String showShowTime(String mid, String cid, String date, HttpSession session, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1, 5);
        unPublishedMovies = movieService.getPublishedMovie(0, 4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        top2Cinema = cinemaService.getMostPopularCinema();

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema", top2Cinema);

        // main process : show movie detail
        movie = movieService.getMovieByID(mid);
        model.addAttribute("movie", movie);

        // process show searched cinema
        searchedResultCinemaList = cinemaService.getCinemaByName(cinemaSearchText);
        int searchedResultCinemaListSize = searchedResultCinemaList.size();
        model.addAttribute("searchedResultCinemaList", searchedResultCinemaList);
//        session.setAttribute("searchedResultCinemaList", searchedResultCinemaList);
        model.addAttribute("searchedResultCinemaListSize", searchedResultCinemaListSize);
        model.addAttribute("txtHistory", cinemaSearchText);

        // main process : show showtimes of detail cinema
        if (!cid.equals("") && !date.equals("")) {
            Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
            model.addAttribute("cinemaDetail", cinemaDetail);
            model.addAttribute("wantedBookDate", date);
            movieListForCNameAndShowtime = movieService.getMovieForCinemaAndShowtime(cid, date); // danh sach cac phim cua cinema co cid trong thoi gian date
            model.addAttribute("movieListForCNameAndShowtime", movieListForCNameAndShowtime);
            session.setAttribute("movieListForCNameAndShowtime", movieListForCNameAndShowtime);
        }
        return "movieDetail";

    }

    private String searchCinemaAction(String cinemaName, Model model) {
        List<Cinema> list = cinemaService.getCinemaByName(cinemaName);
        int size = list.size();
       model.addAttribute("resCinemaList",list);
       model.addAttribute("resCinemaListSize",size);

       return "movieDetail";

    }

    private String showCinemaName(String cid, String mid, HttpSession session, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1, 5);
        unPublishedMovies = movieService.getPublishedMovie(0, 4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        top2Cinema = cinemaService.getMostPopularCinema();

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema", top2Cinema);

        // main process : show movie detail
        movie = movieService.getMovieByID(mid);
        model.addAttribute("movie", movie);

        // main process : show detail cinema
        Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
        model.addAttribute("cinemaDetail", cinemaDetail);

        // main process : search cinema by name
        searchedResultCinemaList = cinemaService.getCinemaByName(cinemaSearchText);
        model.addAttribute("txtHistory", cinemaSearchText);

        int searchedResultCinemaListSize = searchedResultCinemaList.size();
        model.addAttribute("searchedResultCinemaList", searchedResultCinemaList);
        session.setAttribute("searchedResultCinemaList", searchedResultCinemaList);
        model.addAttribute("searchedResultCinemaListSize", searchedResultCinemaListSize);

        return "movieDetail";
    }

    private String initData(String mid, String cid, Model model) {
        allCinema = cinemaService.getAllCinema();
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("top2Cinema", top2Cinema);

// process : show all cinema
        model.addAttribute("txtHistory", "");
        cinemaSearchText = "";
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("searchedResultCinemaList", null);
        model.addAttribute("isShowAllCinema", true);

        // main process : show movie detail
        movie = movieService.getMovieByID(mid);
        model.addAttribute("movie", movie);
        // show detail movie
        Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
        model.addAttribute("cinemaDetail", cinemaDetail);

        return "movieDetail";


    }


}
