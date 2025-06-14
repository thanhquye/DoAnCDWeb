package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticketdetail")
public class TicketDetail {
    @Id
    @Column(name = "ticketDetailID")
    private String ticketDetailID;

    @Column(name = "price")
    private int price;

    @OneToOne
    @JoinColumn(name = "seatID")
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "cinemaRoomID")
    private CinemaRoom cinemaRoom;

    @OneToOne
    @JoinColumn(name = "ticketID")
    private Ticket ticket;

    public TicketDetail() {}



    public String getTicketDetailID() {
        return ticketDetailID;
    }

    public void setTicketDetailID(String ticketDetailID) {
        this.ticketDetailID = ticketDetailID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
