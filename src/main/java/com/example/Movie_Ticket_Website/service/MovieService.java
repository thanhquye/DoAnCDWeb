package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Cinema;
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

    public List<MovieWithMediaDTO> getAllMoviesWithMedia() {
        return movieRepository.findAllMoviesWithLinksDTO();
    }
    // lấy tổng số bộ phim
    public long getTotalMovie(){
        return movieRepository.count();
    }
    // lấy top 10 movie
    public List<MovieEaringDTO> getMovieEarings(){
        return movieRepository.getMovieEarning(PageRequest.of(0, 10));
    }

    public List<Movie> getMovieByName(String name){
        return movieRepository.findByMovieNameContaining(name);
    }




}
