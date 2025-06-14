package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usercomment")
public class UserComment {
    @Id
    @Column(name = "commentID")
    private String commentID;

    @Column(name = "commentText")
    private String commentText;

    @OneToOne
    @JoinColumn(name = "movieID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    public UserComment() {}


    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
