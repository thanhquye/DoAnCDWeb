package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movieID")
    private String movieID;

    @Column(name = "movieName")
    private String movieName;

    @Column(name = "movieCategory")
    private String movieCategory;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "director")
    private String director;

    @Column(name = "duration")
    private String duration;

    @Column(name = "country")
    private String country;

    @Column(name = "movieDescription")
    private String movieDescription;

    @Column(name = "movieContent")
    private String movieContent;

    @Column(name = "isPublished")
    private int isPublished;

    @Column(name = "movieScore")
    private double movieScore;

    @ManyToOne
    @JoinColumn(name = "actorID")
    private Actor actor;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShowTime> showTimes;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MovieMediaLink movieMediaLink;


    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserComment userComment;

    @ManyToOne
    @JoinColumn(name = "priceID")
    private MoviePrice moviePrice;


    public Movie() {
    }

    public Actor getActor() {
        return actor;
    }

    public MoviePrice getMovieCinemaPrice() {
        return moviePrice;
    }

    public void setMovieCinemaPrice(MoviePrice moviePrice) {
        this.moviePrice = moviePrice;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    public UserComment getUserComment() {
        return userComment;
    }

    public void setUserComment(UserComment userComment) {
        this.userComment = userComment;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public MovieMediaLink getMovieMediaLink() {
        return movieMediaLink;
    }

    public void setMovieMediaLink(MovieMediaLink movieMediaLink) {
        this.movieMediaLink = movieMediaLink;
    }
}