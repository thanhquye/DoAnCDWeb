package com.example.Movie_Ticket_Website.dto;

public class TicketWithMovieDTO {
    String ticketID;
    int price;
    String seatName;
    String seatType;
    String roomName;
    String cinemaName;
    String location;
    String showDate;
    String startTime;
    String endTime;
    String movieName;
    String movieCategory;
    String director;
    String country;
    double movieScore;

    public TicketWithMovieDTO(String ticketID, int price, String seatName, String roomName, String seatType, String cinemaName, String location, String showDate, String startTime, String endTime, String movieName, String movieCategory, String director, String country, double movieScore) {
        this.ticketID = ticketID;
        this.price = price;
        this.seatName = seatName;
        this.roomName = roomName;
        this.seatType = seatType;
        this.cinemaName = cinemaName;
        this.location = location;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.director = director;
        this.country = country;
        this.movieScore = movieScore;
    }

    public TicketWithMovieDTO() {
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(double movieScore) {
        this.movieScore = movieScore;
    }
}
