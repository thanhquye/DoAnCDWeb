package com.example.Movie_Ticket_Website.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movieprice")
public class MoviePrice {
    @Id
    @Column(name = "priceID")
    private String priceID;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "moviePrice" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Movie> movie;

    public MoviePrice() {
    }

    public String getPriceID() {
        return priceID;
    }

    public void setPriceID(String priceID) {
        this.priceID = priceID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
