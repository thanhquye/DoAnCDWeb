package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookingdetail")
public class BookingDetail {
    @Id
    @Column(name = "bookingDetailID")
    private String bookingDetailID;

    @Column(name = "bookingDate")
    private String bookingDate;

    @Column(name = "totalTicket")
    private int  totalTicket;

    @OneToOne
    @JoinColumn(name = "bookingID")
    private Booking booking;

    public BookingDetail() {
    }



    public String getBookingDetailID() {
        return bookingDetailID;
    }

    public void setBookingDetailID(String bookingDetailID) {
        this.bookingDetailID = bookingDetailID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
