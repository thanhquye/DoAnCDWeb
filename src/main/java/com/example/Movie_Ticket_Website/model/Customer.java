package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customerID")
    private String customerID;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "dob")
    private String dob;

    @OneToOne
    @JoinColumn(name = "userID")
    private UserLogin userLogin;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionBooking> transactionBookings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserComment> userComment;

    public Customer() {
    }

    public Customer(String customerID, String fullName, String gender, String address, String phoneNumber, String dob) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public List<UserComment> getUserComment() {
        return userComment;
    }

    public void setUserComment(List<UserComment> userComment) {
        this.userComment = userComment;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        userLogin = userLogin;
    }

    public List<TransactionBooking> getTransactionBookings() {
        return transactionBookings;
    }

    public void setTransactionBookings(List<TransactionBooking> transactionBookings) {
        transactionBookings = transactionBookings;
    }
}
