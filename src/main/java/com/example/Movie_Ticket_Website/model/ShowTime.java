package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

@Entity
@Table(name = "showtime")
public class ShowTime {
    @Id
    @Column(name = "showtimeID")
    private  String showtimeID;

    @Column(name = "showDate")
    private  String showDate;

    @Column(name = "startTime")
    private  String startTime;

    @Column(name = "endTime")
    private  String endTime;

    @OneToOne
    @JoinColumn(name = "movieID")
    private  Movie movie;

    @OneToOne(mappedBy = "showtime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Ticket ticket;

    @OneToOne(mappedBy = "showtime", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contain contain;

    public ShowTime(){}

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowtimeID() {
        return showtimeID;
    }

    public void setShowtimeID(String showtimeID) {
        this.showtimeID = showtimeID;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Contain getContain() {
        return contain;
    }

    public void setContain(Contain contain) {
        this.contain = contain;
    }
}
