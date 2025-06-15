package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    // Tìm kiếm UserLogin theo email và userPassword - đăng nhập
    UserLogin findByEmailAndUserPassword(String email, String userPassword);

    // Kiểm tra tồn tại khi đăng ký - register
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);

    // Tìm theo email - forgotPass
    UserLogin findByEmail(String email);
}