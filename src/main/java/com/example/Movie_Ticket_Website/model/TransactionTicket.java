package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transactionticket")
public class TransactionTicket {
    @Id
    @Column(name = "transactionID")
    private String transactionID;

    @Column(name = "transDate")
    private String transDate;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "stateTransaction")
    private int stateTransaction;

    @OneToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "ticketID")
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "paymentTypeID")
    private Payment payment;

    public TransactionTicket() {}

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStateTransaction() {
        return stateTransaction;
    }

    public void setStateTransaction(int stateTransaction) {
        this.stateTransaction = stateTransaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
