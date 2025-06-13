package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "moviemedialink")
public class MovieMediaLink {
    @Id
    @Column(name = "movieMediaLinkID")
    private String movieMediaLinkID;


    @Column(name = "linkMovieTrailer")
    private String linkMovieTrailer;

    @Column(name = "linkMovieImage")
    private String linkMovieImage;

    @OneToOne
    @JoinColumn(name = "movieID") // khóa ngoại trong bảng movie_link
    private Movie movie;

    public MovieMediaLink() {
    }

    public String getMovieMediaLinkID() {
        return movieMediaLinkID;
    }

    public void setMovieMediaLinkID(String movieMediaLinkID) {
        this.movieMediaLinkID = movieMediaLinkID;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
