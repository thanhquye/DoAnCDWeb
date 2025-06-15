package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.dto.MovieEaringDTO;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findByMovieNameContaining(String name);

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "join m.movieMediaLink ml " +
            "where m.movieID = :movieID")
            MovieWithMediaDTO  findByMovieID(@Param("movieID") String movieID);

    // get all movieLink
    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country,\n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) FROM Movie m LEFT JOIN MovieMediaLink ml ON m.movieID = ml.movie.movieID")
    List<MovieWithMediaDTO> findAllMoviesWithLinksDTO();

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieEaringDTO(" +
            "m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.country, m.movieScore, SUM(td.price)) " +
            "FROM Movie m " +
            "JOIN m.showTimes st " +
            "JOIN st.ticket tk " +
            "JOIN tk.ticketDetail td " +
            "GROUP BY m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.country, m.movieScore " +
            "ORDER BY SUM(td.price) DESC")
    List<MovieEaringDTO> getMovieEarning(Pageable pageable);

    // top 4 phim
    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "join m.movieMediaLink ml " +
            "ORDER BY m.releaseDate DESC ")
    List<MovieWithMediaDTO> findNewestMovies(Pageable pageable);

    // movie isPublished
    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "join m.movieMediaLink ml " +
            "where m.isPublished = :isPublished")
    List<MovieWithMediaDTO> findPublishedMoviesWithMedia(@Param("isPublished") int isPublished, Pageable pageable);

    // get all movie category
    @Query("select DISTINCT m.movieCategory from Movie m")
    List<String> findAllCategory();

    // get all movie category
    @Query("select DISTINCT m.country from Movie m")
    List<String> findAllCountry();

    // get all movie Year
    @Query(value = "select DISTINCT YEAR(STR_TO_DATE(releaseDate, '%Y-%m-%d')) FROM movie ", nativeQuery = true)
    List<String> findAllYear();

    // movie isPublished
    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "JOIN m.movieMediaLink ml " +
            "JOIN m.showTimes st " +
            "JOIN st.cinema c " +
            "WHERE c.cinemaID =:cinemaID " +
            "and st.showDate =:date")
    List<MovieWithMediaDTO> findMovieForCinemaAndShowtime(@Param("cinemaID") String cinemaID, @Param("date") String date);


    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "join m.movieMediaLink ml " +
            "where m.movieCategory = :movieCategory")
    List<MovieWithMediaDTO> findAllByMovieCategory(@Param("movieCategory") String movieCategory);

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "join m.movieMediaLink ml " +
            "where m.country = :country")
    List<MovieWithMediaDTO> findAllByCountry(@Param("country") String country);

    // by year
    @Query(value = "SELECT m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, " +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, " +
            "ml.linkMovieTrailer, ml.linkMovieImage " +
            "FROM movie m " +
            "JOIN moviemedialink ml ON m.movieID = ml.movieID " +
            "WHERE YEAR(STR_TO_DATE(m.releaseDate, '%Y-%m-%d')) = :year",
            nativeQuery = true)
    List<MovieWithMediaDTO> findAllMovieByYear(@Param("year") int year);

    @Query("SELECT new com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO(m.movieID, m.movieName, m.movieCategory, m.releaseDate, m.director, m.duration, m.country, \n" +
            "m.movieDescription, m.movieContent, m.isPublished, m.movieScore, ml.linkMovieTrailer, ml.linkMovieImage) " +
            "FROM Movie m " +
            "join m.movieMediaLink ml " +
            "where m.movieName = :movieName")
    List<MovieWithMediaDTO> findAllByMovieName(@Param("movieName") String movieName);

    // find most popular
    @Query(value = """
        SELECT m.*, mml.linkMovieTrailer, mml.linkMovieImage 
        FROM movie m
        JOIN moviemedialink mml ON m.movieID = mml.movieID
        WHERE m.movieID IN (
            SELECT m.movieID
            FROM movie m 
            JOIN showtime st ON m.movieID = st.movieID
            JOIN ticket t ON t.showtimeID = st.showtimeID
            JOIN booking bk ON t.bookingID = bk.bookingID
            JOIN transactionbooking tb ON tb.bookingID = tb.bookingID
            GROUP BY m.movieID
            HAVING COUNT(m.movieID) >= ALL (
                SELECT COUNT(m2.movieID)
                FROM movie m2
                JOIN showtime st2 ON m2.movieID = st2.movieID
                JOIN ticket t2 ON t2.showtimeID = st2.showtimeID
                JOIN booking bk2 ON t2.bookingID = bk2.bookingID
                JOIN transactionbooking tb2 ON tb2.bookingID = tb2.bookingID
                GROUP BY m2.movieID
            )
        )
        LIMIT :numMovie
        """, nativeQuery = true)
    List<Object[]> findMostPopularMovies(@Param("numMovie") int numMovie);
}
