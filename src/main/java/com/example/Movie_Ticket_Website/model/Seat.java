package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @Column(name = "seatID")
    private String seatID;

    @Column(name = "seatName")
    private String seatName;

    @Column(name = "seatType")
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "cinemaRoomID")
    private CinemaRoom cinemaRoom;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketDetail> ticketDetail;

    public Seat() {
    }



    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public List<TicketDetail> getTicketDetail() {
        return ticketDetail;
    }

    public void setTicketDetail(List<TicketDetail> ticketDetail) {
        this.ticketDetail = ticketDetail;
    }
}
