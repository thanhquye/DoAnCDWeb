package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actorID")
    private String actorID;


    @Column(name = "actorName")
    private String actorName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @OneToOne
    @JoinColumn(name = "movieID") // khóa ngoại trong bảng movie_link
    private Movie movie;

    public Actor() {}



    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorID() {
        return actorID;
    }

    public void setActorID(String actorID) {
        this.actorID = actorID;
    }
}
