package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    UserLogin findByEmail(String email);
    List<UserLogin> findAllByIsActiveTrue();
}
