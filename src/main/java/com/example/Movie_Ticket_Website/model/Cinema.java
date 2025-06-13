package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "cinemaRoomID")
    private CinemaRoom cinemaRoom;

    @OneToOne(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contain contain;

    @OneToOne(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Ticket ticket;


    public Cinema() {  }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Contain getContain() {
        return contain;
    }

    public void setContain(Contain contain) {
        this.contain = contain;
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

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }
}
