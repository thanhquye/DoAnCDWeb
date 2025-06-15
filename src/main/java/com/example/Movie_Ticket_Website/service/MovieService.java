package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Actor;
import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.model.Movie;
import com.example.Movie_Ticket_Website.model.MovieMediaLink;
import com.example.Movie_Ticket_Website.repository.ActorRepository;
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
    private ActorRepository actorRepository;

    @Autowired
    public MovieService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }


    public List<MovieWithMediaDTO> getAllMovie() {
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


    public List<MovieWithMediaDTO> getNewestFilms(int number){
        return movieRepository.findNewestMovies(PageRequest.of(0, number));
    }

    // find movie isPublish
    public List<MovieWithMediaDTO> getPublishedMovie(int isPublished, int numMovies){
        Pageable pageable = PageRequest.of(0, numMovies);
        return movieRepository.findPublishedMoviesWithMedia(isPublished, pageable);
    }
    // get all movie category
    public List<String> getAllMovieCategory(){
        return movieRepository.findAllCategory();
    }
    // get all movie country
    public List<String> getAllMovieCountry(){
        return movieRepository.findAllCountry();
    }
    // get all movie year
    public List<String> getAllMovieYear(){
        return movieRepository.findAllYear();
    }

    // getmovie by cinemaID và date
    public List<MovieWithMediaDTO> getMovieForCinemaAndShowtime(String cinemaID, String date){
        return movieRepository.findMovieForCinemaAndShowtime(cinemaID, date);
    }

    // get movie by id
    public MovieWithMediaDTO getMovieByID(String movieID){
        return movieRepository.findByMovieID(movieID);
    }

    // by category
    public List<MovieWithMediaDTO> getMovieByCategory(String category){
        return movieRepository.findAllByMovieCategory(category);
    }
    // by country
    public List<MovieWithMediaDTO> getMovieByCountry(String country){
        return movieRepository.findAllByCountry(country);
    }
    // by year
    public List<MovieWithMediaDTO> getMovieByYear(int year){
        return movieRepository.findAllMovieByYear(year);
    }
    // by name
    public List<MovieWithMediaDTO> getMovieByName(String name){
        return movieRepository.findAllByMovieName(name);
    }

    // get most popular movie
    public List<MovieWithMediaDTO> getMostPopularMovies(int numMovies){
        List<Object[]> rows = movieRepository.findMostPopularMovies(numMovies);
        List<MovieWithMediaDTO> movies = new ArrayList<>();
        for (Object obj : rows) {
            System.out.println(obj + " | " + obj.getClass());
        }
        for (Object[] row : rows) {
            MovieWithMediaDTO dto = new MovieWithMediaDTO();

            dto.setMovieID((String) row[0]);                         // movieID (int? → String)
            dto.setMovieName((String) row[1]);                              // movieName
            dto.setMovieCategory((String) row[2]);                          // movieCategory
            dto.setReleaseDate((String) row[3]);                            // releaseDate (varchar)
            dto.setDirector((String) row[4]);                               // director
            dto.setDuration((String) row[5]);                               // duration
            dto.setCountry((String) row[6]);                                // country
            dto.setMovieDescription((String) row[7]);                       // movieDescription
            dto.setMovieContent((String) row[8]);                           // movieContent
            dto.setIsPublished(((Number) row[9]).intValue());               // isPublished (check kiểu cẩn thận!)
            dto.setMovieScore(((Number) row[10]).doubleValue());            // movieScore (Double hoặc BigDecimal)
            dto.setLinkMovieTrailer((String) row[12]);                      // trailer
            dto.setLinkMovieImage((String) row[13]);                        // image
            movies.add(dto);
        }
        return movies;
    }

    // add movie
    public boolean addNewMovie(Movie movie, MovieMediaLink mediaLink, String actorID) {
        Actor actor = actorRepository.findById(actorID).orElse(null);
        movie.setActor(actor);
        movie.setMovieMediaLink(mediaLink);
        mediaLink.setMovie(movie);
        movieRepository.save(movie);

        return movieRepository.existsById(movie.getMovieID());
    }
}
