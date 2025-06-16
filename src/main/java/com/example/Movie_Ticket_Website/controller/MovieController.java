package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.service.CinemaService;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private UserCommentService userCommentService;


    public static List<MovieWithMediaDTO> newestMovies, publishedMovies, unPublishedMovies, popularMovies, allMovies ;
    public static List<MovieWithMediaDTO> movieFilteredByCategory, movieFilteredByCountry, movieFilteredByYear, movieFilteredByName ;
    public static List<Cinema>  allCinema, top2Cinema;
    public static List<UserCommentWithMovieDTO> comments ;
    public static String cinemaSearchText = "";

    @GetMapping
    public String movieRedirect(@RequestParam(name = "action", required = false) String action,
                               @RequestParam(name = "cid", required = false) String cid,
                               @RequestParam(name = "cinemaName", required = false) String cinemaName,
                               @RequestParam(name = "date", required = false) String date,
                               @RequestParam(name = "category", required = false) String category,
                               @RequestParam(name = "country", required = false) String country,
                               @RequestParam(name = "year", required = false) String year,
                               HttpSession session, Model model) {
        if (session.getAttribute("pageName") != null) {
            session.removeAttribute("pageName");
        } else {
            session.setAttribute("pageName", "movie");
        }


        return switch (action) {
            case "init" ->  initData(model);
            case "show-cinemaShowtime" ->showCinemaDetail(cid,model);
            case "show-cinemaDetail" ->searchCinemaAction(cinemaName,model);
            case "filterCategory" ->filterCategory(category,model);
            case "filterCountry" ->filterCountry(country,model);
            case "filterYear" ->filterYear(year,model);
            case "findByMovieName" ->findByMovieName(cinemaName,model);
            default -> "redirect:/home?action=direct";
        };
    }

    private String findByMovieName(String movieName, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1,5);
        unPublishedMovies = movieService.getPublishedMovie(0,4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        allMovies = movieService.getAllMovie();
        top2Cinema = cinemaService.getMostPopularCinema();
        comments = userCommentService.getPopularComment(3);

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("allMovies", allMovies);;
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);


        // process : init categoryList
        List<String> categoryList;
        categoryList = movieService.getAllMovieCategory();
        model.addAttribute("categoryList",categoryList);

        // process : init countryList
        List<String> countryList;
        countryList = movieService.getAllMovieCountry();
        model.addAttribute("countryList",countryList);

        // process : init yearList
        List<String> yearList;
        yearList = movieService.getAllMovieYear();
        model.addAttribute("yearList",yearList);

        // main process : movieFilteredByCountry
        movieFilteredByName = movieService.getMovieByName(movieName);
        int size = movieFilteredByName.size();
        model.addAttribute("movieFilteredByNameSize",size);
        model.addAttribute("movieFilteredByName",movieFilteredByName);
        return "movies";
    }

    private String filterYear(String year, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1,5);
        unPublishedMovies = movieService.getPublishedMovie(0,4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        allMovies = movieService.getAllMovie();
        top2Cinema = cinemaService.getMostPopularCinema();
        comments = userCommentService.getPopularComment(3);

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("allMovies", allMovies);;
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // process : init categoryList
        List<String> categoryList;
        categoryList = movieService.getAllMovieCategory();
        model.addAttribute("categoryList",categoryList);

        // process : init countryList
        List<String> countryList;
        countryList = movieService.getAllMovieCountry();
        model.addAttribute("countryList",countryList);

        // process : init yearList
        List<String> yearList;
        yearList = movieService.getAllMovieYear();
        model.addAttribute("yearList",yearList);

        int yearInt = Integer.parseInt(year);
        movieFilteredByYear = movieService.getMovieByYear(yearInt);
        int size = movieFilteredByYear.size();
        model.addAttribute("movieFilteredByYearSize",size);
        model.addAttribute("movieFilteredByYear",movieFilteredByYear);

        return "movies";


    }

    private String filterCountry(String country, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1,5);
        unPublishedMovies = movieService.getPublishedMovie(0,4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        allMovies = movieService.getAllMovie();
        top2Cinema = cinemaService.getMostPopularCinema();
        comments = userCommentService.getPopularComment(3);

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("allMovies", allMovies);;
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // process : init categoryList
        List<String> categoryList;
        categoryList = movieService.getAllMovieCategory();
        model.addAttribute("categoryList",categoryList);

        // process : init countryList
        List<String> countryList;
        countryList = movieService.getAllMovieCountry();
        model.addAttribute("countryList",countryList);

        // process : init yearList
        List<String> yearList;
        yearList = movieService.getAllMovieYear();
        model.addAttribute("yearList",yearList);

        movieFilteredByCountry = movieService.getMovieByCountry(country);
        int size = movieFilteredByCountry.size();
        model.addAttribute("movieFilteredByCountrySize",size);
        model.addAttribute("movieFilteredByCountry",movieFilteredByCountry);

        return "movies";

    }

    private String filterCategory(String category, Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1,5);
        unPublishedMovies = movieService.getPublishedMovie(0,4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        allMovies = movieService.getAllMovie();
        top2Cinema = cinemaService.getMostPopularCinema();
        comments = userCommentService.getPopularComment(3);

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("allMovies", allMovies);;
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);


        // process : init categoryList
        List<String> categoryList;
        categoryList = movieService.getAllMovieCategory();
        model.addAttribute("categoryList",categoryList);

        // process : init countryList
        List<String> countryList;
        countryList = movieService.getAllMovieCountry();
        model.addAttribute("countryList",countryList);

        // process : init yearList
        List<String> yearList;
        yearList = movieService.getAllMovieYear();
        model.addAttribute("yearList",yearList);

        // main process : movieFilteredByCategory
        movieFilteredByCategory = movieService.getMovieByCategory(category);
        int size = movieFilteredByCategory.size();
        model.addAttribute("movieFilteredByCategorySize",size);
        model.addAttribute("movieFilteredByCategory",movieFilteredByCategory);

        return "movies";
    }

    private String searchCinemaAction(String cinemaName, Model model) {
        List<Cinema> list = cinemaService.getCinemaByName(cinemaName);
        int size = list.size();
        model.addAttribute("resCinemaList",list);
        model.addAttribute("resCinemaListSize",size);
        return "home";
    }

    private String showCinemaDetail(String cid,  Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1,5);
        unPublishedMovies = movieService.getPublishedMovie(0,4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        allMovies = movieService.getAllMovie();
        top2Cinema = cinemaService.getMostPopularCinema();
        comments = userCommentService.getPopularComment(3);

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("allMovies", allMovies);;
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
        model.addAttribute("cinemaDetail",cinemaDetail);
        return "home";

    }

    private String initData(Model model) {
        newestMovies = movieService.getNewestFilms(5);
        publishedMovies = movieService.getPublishedMovie(1,5);
        unPublishedMovies = movieService.getPublishedMovie(0,4);
        popularMovies = movieService.getMostPopularMovies(3);
        allCinema = cinemaService.getAllCinema();
        allMovies = movieService.getAllMovie();
        top2Cinema = cinemaService.getMostPopularCinema();
        comments = userCommentService.getPopularComment(3);

        model.addAttribute("top4NewestMovies", newestMovies);
        model.addAttribute("publishedMovies", publishedMovies);
        model.addAttribute("unPublishedMovies", unPublishedMovies);
        model.addAttribute("popularMovies", popularMovies);
        model.addAttribute("allCinema", allCinema);
        model.addAttribute("allMovies", allMovies);;
        model.addAttribute("top2Cinema",top2Cinema);
        model.addAttribute("comments",comments);

        // process : init categoryList
        List<String> categoryList;
        categoryList = movieService.getAllMovieCategory();
        model.addAttribute("categoryList",categoryList);

        // process : init countryList
        List<String> countryList;
        countryList = movieService.getAllMovieCountry();
        model.addAttribute("countryList",countryList);

        // process : init yearList
        List<String> yearList;
        yearList = movieService.getAllMovieYear();
        model.addAttribute("yearList",yearList);

        // process : isShowAllCinema
        model.addAttribute("isShowAllCinema",true);

        return "movies";
    }

}
