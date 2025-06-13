package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.service.MovieService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
public class HomeController {
    private final MovieService movieService;
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String showHome(Model model) {
        // xử lý
        return "home"; // view name
    }

    @GetMapping("/movies")
    public String showNewestMovies(Model model) {

        List<MovieWithMediaDTO> movies = movieService.getAllMoviesWithMedia();
        logger.info(movies.toString());
        model.addAttribute("movies", movies);

        return "movie";
    }

}
