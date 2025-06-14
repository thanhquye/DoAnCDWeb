package com.example.Movie_Ticket_Website.dto;

public class CommentDTO {
    String fullName;
    String movieName;
    String commentID;
    String movieID;
    String customerID;
    String commentText;

    public CommentDTO(String fullName,String movieName, String commentID, String movieID, String customerID, String commentText) {
        this.movieName = movieName;
        this.fullName = fullName;
        this.commentID = commentID;
        this.movieID = movieID;
        this.customerID = customerID;
        this.commentText = commentText;
    }
    public CommentDTO(String commentID, String movieID, String customerID, String commentText) {
        this.commentID = commentID;
        this.movieID = movieID;
        this.customerID = customerID;
        this.commentText = commentText;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
