package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transactionbooking")
public class TransactionBooking {
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
    @JoinColumn(name = "bookingID")
    private Booking booking;

    @OneToOne
    @JoinColumn(name = "paymentTypeID")
    private Payment payment;

    public TransactionBooking() {}

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

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



    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
