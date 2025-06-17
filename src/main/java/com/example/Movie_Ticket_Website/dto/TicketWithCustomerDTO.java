package com.example.Movie_Ticket_Website.dto;

public class TicketWithCustomerDTO {
    String fullName;
    String phoneNumber;
    String movieName;
    String cinemaName;
    String ticketID;
    String cinemaID;
    String showtimeID;

    public TicketWithCustomerDTO(String fullName, String phoneNumber, String movieName, String cinemaName,String ticketID, String cinemaID,  String showtimeID) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.movieName = movieName;
        this.cinemaName = cinemaName;
        this.ticketID = ticketID;
        this.cinemaID = cinemaID;
        this.showtimeID = showtimeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(String showtimeID) {
        this.showtimeID = showtimeID;
    }
}
