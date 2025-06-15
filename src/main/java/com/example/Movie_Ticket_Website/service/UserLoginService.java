package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserLoginService {
    private UserLoginRepository userLoginRepository;

    @Autowired
    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public int getAllActiveUserLogins() {
        List<UserLogin> userLogins = userLoginRepository.findAllByIsActiveTrue();
        return userLogins.size();
    }

    public Boolean checkEmailExits(String email) {
        return userLoginRepository.findByEmail(email).isActive();
    }

    public UserLogin getUserbyEmailAndPassword(String email, String password) {
        return userLoginRepository.findByEmailAndUserPassword(email, password);
    }

    public List<String> getAllUserID() {
        return userLoginRepository.findAllUserID();
    }

    public List<UserLogin> getAllUserLogins() {
        return userLoginRepository.findAll();
    }

    public List<UserLogin> getAllUserByName(String name) {
        return userLoginRepository.findAllByUserName(name);
    }

    public boolean updateUser(UserLogin updatedUser) {
        Optional<UserLogin> optionalUser = userLoginRepository.findById(updatedUser.getUserId());

        if (optionalUser.isPresent()) {
            UserLogin existingUser = optionalUser.get();

            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setUserPassword(updatedUser.getUserPassword());
            existingUser.setActive(updatedUser.isActive());
            existingUser.setAdmin(updatedUser.isAdmin());
            existingUser.setVerifyEmail(updatedUser.isVerifyEmail());

            userLoginRepository.save(existingUser);
            return true;
        }

        return false;
    }

    // Cập nhật cột EmailVerified
    public void markEmailVerified(String email) {
        UserLogin user = userLoginRepository.findByEmail(email);
        if (user != null) {
            user.setVerifyEmail(true);
            userLoginRepository.save(user);
        }
    }

    // Lấy ra user chỉ bằng Gmail cập nhật session trong gmailVerify
    public UserLogin getUserByEmail(String email) {
        return userLoginRepository.findByEmail(email);
    }

}
