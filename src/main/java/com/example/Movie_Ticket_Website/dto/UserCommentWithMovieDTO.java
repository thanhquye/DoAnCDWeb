package com.example.Movie_Ticket_Website.dto;

public class UserCommentWithMovieDTO {
    private String commentID;
    private String movieID;
    private String movieName;
    private String linkMovieImage;
    private String commentText;

    public UserCommentWithMovieDTO(String commentID, String movieID, String movieName, String linkMovieImage, String commentText) {
        this.commentID = commentID;
        this.movieID = movieID;
        this.movieName = movieName;
        this.linkMovieImage = linkMovieImage;
        this.commentText = commentText;
    }

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getLinkMovieImage() {
        return linkMovieImage;
    }

    public void setLinkMovieImage(String linkMovieImage) {
        this.linkMovieImage = linkMovieImage;
    }
}
