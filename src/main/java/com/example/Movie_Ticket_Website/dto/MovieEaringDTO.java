package com.example.Movie_Ticket_Website.dto;

public class MovieEaringDTO {
    String movieID;
    String movieName;
    String movieCategory;
    String releaseDate;
    String country;
    double movieScore;
    double price;

    public MovieEaringDTO(){}

    public MovieEaringDTO(String movieID, String movieName, String movieCategory, String releaseDate, String country,
                          double movieScore, double price) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.releaseDate = releaseDate;
        this.country = country;
        this.movieScore = movieScore;
        this.price = price;
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

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(double movieScore) {
        this.movieScore = movieScore;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
