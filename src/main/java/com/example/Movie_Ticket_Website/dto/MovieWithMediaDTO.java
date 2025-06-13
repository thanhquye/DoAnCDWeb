package com.example.Movie_Ticket_Website.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class MovieWithMediaDTO {
    private String movieId;
    private String movieName;
    private String movieCategory;
    private String releaseDate;
    private String director;
    private String duration;
    private String country;
    private String movieDescription;
    private String movieContent;
    private int isPublished;
    private double movieScore;
    private String linkMovieTrailer;
    private String linkMovieImage;



    // Constructor
    public MovieWithMediaDTO(String movieId, String movieName, String movieCategory,
                             String releaseDate, String director, String duration,
                             String country, String movieDescription, String movieContent,
                             int isPublished, double movieScore, String linkMovieTrailer, String linkMovieImage) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.releaseDate = releaseDate;
        this.director = director;
        this.duration = duration;
        this.country = country;
        this.movieDescription = movieDescription;
        this.movieContent = movieContent;
        this.isPublished = isPublished;
        this.movieScore = movieScore;
        this.linkMovieTrailer = linkMovieTrailer;
        this.linkMovieImage = linkMovieImage;

    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public String getDuration() {
        return duration;
    }

    public String getCountry() {
        return country;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public String getMovieContent() {
        return movieContent;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public double getMovieScore() {
        return movieScore;
    }

    public String getLinkMovieTrailer() {
        return linkMovieTrailer;
    }

    public String getLinkMovieImage() {
        return linkMovieImage;
    }
}
