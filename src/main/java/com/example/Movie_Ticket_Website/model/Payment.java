package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "paymentTypeID")
    private String paymentTypeID;

    @Column(name = "paymentTypeName")
    private String paymentTypeName;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionBooking> transactionTicket;

    public Payment() {
    }

    public String getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(String paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public List<TransactionBooking> getTransactionTicket() {
        return transactionTicket;
    }

    public void setTransactionTicket(List<TransactionBooking> transactionTicket) {
        this.transactionTicket = transactionTicket;
    }
}
