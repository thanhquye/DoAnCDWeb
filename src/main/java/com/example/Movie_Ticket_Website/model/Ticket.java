package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "ticketID")
    private String ticketID;

    @ManyToOne
    @JoinColumn(name = "showtimeID")
    private ShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "bookingID")
    private Booking booking;


    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TicketDetail ticketDetail;


    public Ticket() {}

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }


    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public TicketDetail getTicketDetail() {
        return ticketDetail;
    }

    public void setTicketDetail(TicketDetail ticketDetail) {
        this.ticketDetail = ticketDetail;
    }


}
