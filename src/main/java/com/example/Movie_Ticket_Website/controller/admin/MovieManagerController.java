package com.example.Movie_Ticket_Website.controller.admin;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.MoviePrice;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.repository.MovieMediaLinkRepository;
import com.example.Movie_Ticket_Website.repository.MoviePriceRepository;
import com.example.Movie_Ticket_Website.repository.MovieRepository;
import com.example.Movie_Ticket_Website.service.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class MovieManagerController {

    @Autowired
    MovieService movieService;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MoviePriceRepository moviePriceRepository;
    @Autowired
    MovieMediaLinkRepository movieMediaLinkRepository;

    @GetMapping("/quanliphim")
    public String admin(@RequestParam(name = "action", required = false) String action,
                        @RequestParam(name = "mid", required = false) String mid,
                        HttpSession session,
                        Model model
    ) {
        UserLogin user = (UserLogin) session.getAttribute("admin");
        if (user == null) {
            return "redirect:/login";
        }
        if (action == null) {action = "int"; }
        return switch (action) {
            case "init" -> showAllMovie(session,model);
            case "update" -> showUpdateMovieForm(mid, session, model);
            case "add" -> showAddMovieForm( session, model);

            default -> "redirect:/admin/quanliphim?action=init";
        };



    }

    private String showAddMovieForm( HttpSession session, Model model) {
        model.addAttribute("movie", new Movie());
        List<MoviePrice> priceList = moviePriceRepository.findAll();
        model.addAttribute("priceList", priceList);
        return "admin/themphimmoi";
    }
    private String showUpdateMovieForm(String mid, HttpSession session, Model model) {
        Movie movie = movieService.getMovieById(mid);
        model.addAttribute("movie", movie);
        return "admin/capnhatphim";
    }


    private String showAllMovie(HttpSession session, Model model) {
        List<MovieWithMediaDTO> movies = movieService.getAllMovie();

        model.addAttribute("movieList",movies );
        model.addAttribute("showAll", true);

        return "admin/quanliphim";
    }
    @PostMapping("/quanliphim/update")
    public String updateMovie(@ModelAttribute("movie") Movie updatedMovie) {
        if (updatedMovie.getMovieMediaLink() != null) {

            // Gán ID nếu là media mới
            if (updatedMovie.getMovieMediaLink().getMovieMediaLinkID() == null) {
                updatedMovie.getMovieMediaLink().setMovieMediaLinkID("mml" + UUID.randomUUID());
            }

            updatedMovie.getMovieMediaLink().setMovie(updatedMovie);
        }
        movieRepository.save(updatedMovie);
        return "redirect:/admin/quanliphim";
    }


    @PostMapping("/quanliphim/addMovie")
    public String addMovie(@ModelAttribute("movie") Movie movie, @RequestParam("priceID") String priceID) {
        MoviePrice selectedPrice = moviePriceRepository.findById(priceID).orElse(null);
        if (movie.getMovieID() == null) {
            movie.setMovieID("Mv"+UUID.randomUUID());
        }
        if (movie.getMovieMediaLink() != null) {
            if (movie.getMovieMediaLink().getMovieMediaLinkID() == null) {
                movie.getMovieMediaLink().setMovieMediaLinkID("mml" + UUID.randomUUID());
            }

            movie.getMovieMediaLink().setMovie(movie);
        }
        movie.setMoviePrice(selectedPrice);

        movieRepository.save(movie);
        return "redirect:/admin/quanliphim";

    }
    @PostMapping("/quanliphim/delete")
    @ResponseBody
    public ResponseEntity<?> deleteTicket(@RequestParam("mid") String ticketId) {
        System.out.println("deleteMovie");
        try {
            Movie movie = movieService.getMovieById(ticketId);
            movieRepository.delete(movie);
            return ResponseEntity.ok().build(); // trả về HTTP 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi xóa");
        }


    }
}
