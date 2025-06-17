package com.example.Movie_Ticket_Website.repository;

import com.example.Movie_Ticket_Website.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
    // Tìm kiếm UserLogin theo email và userPassword - đăng nhập
    UserLogin findByEmailAndUserPassword(String email, String userPassword);

    // Kiểm tra tồn tại khi đăng ký - register
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    // Tìm theo email - forgotPass - verifyGmail
    UserLogin findByEmail(String email);

    // check user active is true
    List<UserLogin> findAllByIsActiveTrue();

    List<UserLogin> findAllByUserName(String userName);

    @Query("select user.userId from UserLogin user")
    List<String> findAllUserID();

    UserLogin findByUserId(String userId);

    long countByIsActiveTrueAndIsAdminFalse(); // Để đếm số người dùng (user thường) đang online

}