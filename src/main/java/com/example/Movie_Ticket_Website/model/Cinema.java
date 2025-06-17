package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @Column(name = "cinemaID")
    private String cinemaID;

    @Column(name = "cinemaName")
    private String cinemaName;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShowTime> showTimes;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CinemaRoom> cinemaRooms;



    public Cinema(String cinemaID, String cinemaName, String location) {
        this.cinemaID = cinemaID;
        this.cinemaName = cinemaName;
        this.location = location;
    }

    public Cinema() {

    }




    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    public List<CinemaRoom> getCinemaRooms() {
        return cinemaRooms;
    }

    public void setCinemaRooms(List<CinemaRoom> cinemaRooms) {
        this.cinemaRooms = cinemaRooms;
    }

    public String getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
