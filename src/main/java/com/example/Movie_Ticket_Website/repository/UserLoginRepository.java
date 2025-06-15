package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    UserLogin findByEmail(String email);

    // check user active is true
    List<UserLogin> findAllByIsActiveTrue();
    // Tìm kiếm UserLogin theo email và userPassword
    UserLogin findByEmailAndUserPassword(String email, String userPassword);


    List<UserLogin> findAllByUserName(String userName);

    boolean existsByEmail(String email);

    @Query("select user.userId from UserLogin user")
    List<String> findAllUserID();
}