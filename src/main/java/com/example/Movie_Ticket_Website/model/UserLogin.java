package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "userlogin")
public class UserLogin {

    int stt;

    @Id
    @Column(name = "userId")
    String userId;

    @Column(name = "userName")
    String userName;

    @Column(name = "email")
    String email;

    @Column(name = "userPassword")
    String userPassword;

    @Column(name = "isActive")
    boolean isActive;

    @Column(name = "isAdmin")
    boolean isAdmin;

    @Column(name = "isVerifyEmail")
    boolean isVerifyEmail;

    @OneToOne(mappedBy = "userLogin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "userLogin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public UserLogin() {}

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isVerifyEmail() {
        return isVerifyEmail;
    }

    public void setVerifyEmail(boolean verifyEmail) {
        isVerifyEmail = verifyEmail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
