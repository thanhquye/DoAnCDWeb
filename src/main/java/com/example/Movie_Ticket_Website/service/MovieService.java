package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie getMovieByMovieID(String movieID) {
        return movieRepository.findByMovieID(movieID);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> searchMoviesByName(String name) {
        return movieRepository.findByMovieNameContaining(name);
    }

    public List<Movie> getMoviesByCategory(String category) {
        return movieRepository.findByMovieCategory(category);
    }

    public List<Movie> getPublishedMovies() {
        return movieRepository.findByIsPublished(1);
    }

    public List<MovieWithMediaDTO> getAllMoviesWithMedia() {
        return movieRepository.findAllMoviesWithLinksDTO();
    }

}
