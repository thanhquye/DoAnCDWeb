package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Actor;
import com.example.Movie_Ticket_Website.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorService {
    private ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {return actorRepository.findAll();}

    public Actor getActor(String id) {return actorRepository.findById(id).orElse(null);}


}
