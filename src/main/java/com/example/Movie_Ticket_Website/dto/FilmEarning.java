package com.example.Movie_Ticket_Website.dto;

public class FilmEarning {
    private String movieID;
    private String movieName;
    private String movieCategory;
    private String releaseDate;
    private String country;
    private Double movieScore;
    private Double total;

    public FilmEarning(String movieID, String movieName, String movieCategory,
                       String releaseDate, String country, Double movieScore, Number total) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.releaseDate = releaseDate;
        this.country = country;
        this.movieScore = movieScore;
        this.total = total.doubleValue(); // ép sang Double
    }

    // Getters & Setters
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

    public Double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Double movieScore) {
        this.movieScore = movieScore;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
