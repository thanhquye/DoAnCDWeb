package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.dto.UserCommentWithMovieDTO;
import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.UserComment;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);



    @GetMapping
    public String homeRedirect(@RequestParam(name = "action", required = false) String action, HttpSession session, Model model) {
        if (session.getAttribute("pageName") != null) {
            session.removeAttribute("pageName");
        } else {
            session.setAttribute("pageName", "homePage");
        }

        if (action == null) action = "direct";

        return switch (action) {
            case "direct" -> redirectToHomePage(model);
            default -> "redirect:/home?action=direct";
        };
    }

    private String redirectToHomePage(Model model) {
        model.addAttribute("top4NewestMovies", movieService.getNewestMovies(5));
        model.addAttribute("publishedMovies", movieService.getPublishedMovie(1, 5));
        model.addAttribute("unPublishedMovies", movieService.getPublishedMovie(0, 4));
        model.addAttribute("popularMovies", movieService.getMostPopularMovies(3));
        model.addAttribute("top2Cinema", cinemaService.getMostPopularCinema());
        model.addAttribute("comments", userCommentService.getPopularComment(3));
        model.addAttribute("txtHistory", "");
        model.addAttribute("allCinema", cinemaService.getAllCinemas());
        model.addAttribute("searchedResultCinemaList", null);
        model.addAttribute("isShowAllCinema", true);
        return "home";
    }
}

