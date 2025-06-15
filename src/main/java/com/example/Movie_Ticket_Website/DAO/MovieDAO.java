package com.example.Movie_Ticket_Website.DAO;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.MovieMediaLink;
import com.example.Movie_Ticket_Website.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDAO {
    @Autowired
    private MovieService movieService;

    public void all(){
        List<MovieWithMediaDTO> getAllMovie = movieService.getAllMovie();
        List<MovieWithMediaDTO> getNewestFilms = movieService.getNewestFilms(4);
        List<MovieWithMediaDTO> getPublishedMovie = movieService.getPublishedMovie(1, 4);
        List<String> getAllMovieCatelogy = movieService.getAllMovieCategory();
        List<String> getAllMovieCountry = movieService.getAllMovieCountry();
        List<String> getAllMovieYear = movieService.getAllMovieCategory();
        List<MovieWithMediaDTO> getMovieForCinemaAndShowtime = movieService.getMovieForCinemaAndShowtime("", "");
        MovieWithMediaDTO getMovieByID = movieService.getMovieByID("");
        List<MovieWithMediaDTO> getMovieByCategory = movieService.getMovieByCategory("");
        List<MovieWithMediaDTO> getMovieByCountry = movieService.getMovieByCountry("");
        List<MovieWithMediaDTO> getMovieByYear = movieService.getMovieByYear(2023);
        List<MovieWithMediaDTO> getMovieByName = movieService.getMovieByName("");
        List<MovieWithMediaDTO> getMostPopularMovie = movieService.getMostPopularMovies(3);

        Boolean addNewMovie = movieService.addNewMovie(new Movie(), new MovieMediaLink(), "At1");



    }
}
