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
        List<MovieWithMediaDTO> getAllMovie = movieService.getAllMoviesWithMedia();
        List<MovieWithMediaDTO> getNewestFilms = movieService.getNewestMovies(4);
        List<Movie> getPublishedMovie = movieService.getPublishedMovie(1, 4);
        List<String> getAllMovieCatelogy = movieService.getAllMovieCategory();
        List<String> getAllMovieCountry = movieService.getAllMovieCountry();
        List<String> getAllMovieYear = movieService.getAllMovieCategory();
        List<Movie> getMovieForCinemaAndShowtime = movieService.getMovieForCinemaAndShowtime("", "");
        Movie getMovieByID = movieService.getMovieById("");
        List<Movie> getMovieByCategory = movieService.getAllMovieByCategory("");
        List<Movie> getMovieByCountry = movieService.getAllMovieByCountry("");
        List<MovieWithMediaDTO> getMovieByYear = movieService.getAllMovieByYear(2023);
        List<Movie> getMovieByName = movieService.getAllMovieByName("");
        List<MovieWithMediaDTO> getMostPopularMovie = movieService.getMostPopularMovies(3);

        Boolean addNewMovie = movieService.addNewMovie(new Movie(), new MovieMediaLink(), "At1");



    }
}
