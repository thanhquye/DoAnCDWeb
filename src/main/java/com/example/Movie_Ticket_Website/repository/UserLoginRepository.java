package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    // Tìm kiếm UserLogin theo email và userPassword
    UserLogin findByEmailAndUserPassword(String email, String userPassword);
}