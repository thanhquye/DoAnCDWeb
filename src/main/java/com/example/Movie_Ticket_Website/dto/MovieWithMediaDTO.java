package com.example.Movie_Ticket_Website.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class MovieWithMediaDTO {
    private String movieID;
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

    public MovieWithMediaDTO() {
    }

    // Constructor
    public MovieWithMediaDTO(String movieID, String movieName, String movieCategory,
                             String releaseDate, String director, String duration,
                             String country, String movieDescription, String movieContent,
                             int isPublished, double movieScore, String linkMovieTrailer, String linkMovieImage) {
        this.movieID = movieID;
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

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieContent() {
        return movieContent;
    }

    public void setMovieContent(String movieContent) {
        this.movieContent = movieContent;
    }

    public int getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(int isPublished) {
        this.isPublished = isPublished;
    }

    public double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(double movieScore) {
        this.movieScore = movieScore;
    }

    public String getLinkMovieTrailer() {
        return linkMovieTrailer;
    }

    public void setLinkMovieTrailer(String linkMovieTrailer) {
        this.linkMovieTrailer = linkMovieTrailer;
    }

    public String getLinkMovieImage() {
        return linkMovieImage;
    }

    public void setLinkMovieImage(String linkMovieImage) {
        this.linkMovieImage = linkMovieImage;
    }
}
