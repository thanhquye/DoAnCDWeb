package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.MovieMediaLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMediaLinkRepository extends JpaRepository<MovieMediaLink, String> {
}
