package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    private final UserLoginRepository userRepo;

    @Autowired
    public RegisterService(UserLoginRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean checkEmailExists(String email) {
        return userRepo.existsByEmail(email);
    }

    public boolean checkUsernameExists(String username) {
        return userRepo.existsByUserName(username);
    }

    public boolean registerUser(String userName, String email, String password) {
        // Tìm ID lớn nhất
        List<UserLogin> users = userRepo.findAll();
        int maxId = users.stream()
                .mapToInt(u -> Integer.parseInt(u.getUserId().replaceAll("[^0-9]", "")))
                .max()
                .orElse(0);
        String newUserId = "user" + String.format("%03d", maxId + 1);

        UserLogin user = new UserLogin();
        user.setUserId(newUserId);
        user.setUserName(userName);
        user.setEmail(email);
        user.setUserPassword(password);
        user.setActive(true);
        user.setAdmin(false);
        user.setVerifyEmail(false);

        userRepo.save(user);
        return true;
    }
}