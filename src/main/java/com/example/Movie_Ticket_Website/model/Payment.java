package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "paymentTypeID")
    private String paymentTypeID;

    @Column(name = "paymentTypeName")
    private String paymentTypeName;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransactionTicket transactionTicket;

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

    public TransactionTicket getTransactionTicket() {
        return transactionTicket;
    }

    public void setTransactionTicket(TransactionTicket transactionTicket) {
        this.transactionTicket = transactionTicket;
    }
}
