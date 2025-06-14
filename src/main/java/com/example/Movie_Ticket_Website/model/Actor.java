package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actorID")
    private String actorID;


    @Column(name = "actorName")
    private String actorName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<Movie> movies;

    public Actor() {}

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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
