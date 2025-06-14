package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.Actor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActorRepository extends JpaRepository<Actor, String> {

}
