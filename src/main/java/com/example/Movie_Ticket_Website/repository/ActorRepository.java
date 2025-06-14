package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Actor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, String> {

}
