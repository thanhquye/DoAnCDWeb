package com.example.Movie_Ticket_Website.dto;

public class TicketCartDTO {
    private String movieName;
    private String date;
    private String seatName;
    private String time;
    private String image;
    private int moviePrice;

    public TicketCartDTO(String movieName, String date, String seatName, String time, String image, int moviePrice) {
        this.movieName = movieName;
        this.date = date;
        this.seatName = seatName;
        this.time = time;
        this.image = image;
        this.moviePrice = moviePrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    @Override
    public String toString() {
        return "TicketCartDTO{" +
                "movieName='" + movieName + '\'' +
                ", date='" + date + '\'' +
                ", seatName='" + seatName + '\'' +
                ", time='" + time + '\'' +
                ", image='" + image + '\'' +
                ", moviePrice=" + moviePrice +
                '}';
    }
}
