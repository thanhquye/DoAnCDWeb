package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "ticketID")
    private String ticketID;

    @OneToOne
    @JoinColumn(name = "cinemaID")
    private Cinema cinema;

    @OneToOne
    @JoinColumn(name = "showtimeID")
    private ShowTime showTime;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TicketDetail ticketDetail;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransactionTicket transactionTicket;

    public Ticket() {}

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
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

    public TransactionTicket getTransactionTicket() {
        return transactionTicket;
    }

    public void setTransactionTicket(TransactionTicket transactionTicket) {
        this.transactionTicket = transactionTicket;
    }
}
