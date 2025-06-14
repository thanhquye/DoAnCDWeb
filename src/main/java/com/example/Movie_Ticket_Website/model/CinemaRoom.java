package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cinemaroom")
public class CinemaRoom {
    @Id
    @Column(name = "cinemaRoomID")
    private String cinemaRoomID;

    @Column(name = "roomName")
    private String roomName;


    @ManyToOne
    @JoinColumn(name = "cinemaID")
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Seat> seats;


    @OneToOne(mappedBy = "cinemaRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TicketDetail ticketDetail;

    public CinemaRoom() {
    }

    public CinemaRoom(String cinemaRoomID, String roomName) {
        this.cinemaRoomID = cinemaRoomID;
        this.roomName = roomName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public TicketDetail getTicketDetail() {
        return ticketDetail;
    }

    public void setTicketDetail(TicketDetail ticketDetail) {
        this.ticketDetail = ticketDetail;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public String getCinemaRoomID() {
        return cinemaRoomID;
    }

    public void setCinemaRoomID(String cinemaRoomID) {
        this.cinemaRoomID = cinemaRoomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
