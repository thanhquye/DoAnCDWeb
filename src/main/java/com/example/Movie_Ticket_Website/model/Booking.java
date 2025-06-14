package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "bookingID")
    private String bookingID;


    @ManyToOne
    @JoinColumn(name = "userID")
    private UserLogin userLogin;

    // 1 booking có nhiều ticket
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BookingDetail bookingDetail;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransactionBooking transactionTicket;

    public Booking() {
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public TransactionBooking getTransactionTicket() {
        return transactionTicket;
    }

    public void setTransactionTicket(TransactionBooking transactionTicket) {
        this.transactionTicket = transactionTicket;
    }

    public BookingDetail getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(BookingDetail bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public List<Ticket> getTicket() {
        return tickets;
    }

    public void setTicket(List<Ticket> ticket) {
        this.tickets = ticket;
    }
}
