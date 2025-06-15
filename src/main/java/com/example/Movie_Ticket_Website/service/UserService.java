package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.repository.UserLoginRepository;
import com.example.Movie_Ticket_Website.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // Kiểm tra gmail gửi gmail chứa mật khẩu - forgotPass
    private final UserLoginRepository userLoginRepository;
    private final EmailService emailService;

    @Autowired
    public UserService(UserLoginRepository userLoginRepository, EmailService emailService) {
        this.userLoginRepository = userLoginRepository;
        this.emailService = emailService;
    }

    public String resetPassword(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Email không được để trống.";
        }

        UserLogin user = userLoginRepository.findByEmail(email);
        if (user == null) {
            return "Email không tồn tại trong hệ thống.";
        }

        String newPassword = PasswordGenerator.generateRandomPassword(8);
        user.setUserPassword(newPassword);
        userLoginRepository.save(user);

        boolean emailSent = emailService.sendNewPasswordEmail(
                email, newPassword, user.getUserName()
        );

        return emailSent ? "Mật khẩu mới đã được gửi tới email của bạn."
                : "Gửi email thất bại, vui lòng thử lại sau!";
    }

    public boolean isEmailExists(String email) {
        return userLoginRepository.existsByEmail(email);
    }
}