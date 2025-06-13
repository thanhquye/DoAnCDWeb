package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Customer;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.repository.CustomerRepository;
import com.example.Movie_Ticket_Website.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserLoginRepository userLoginRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public LoginService(UserLoginRepository userLoginRepository, CustomerRepository customerRepository) {
        this.userLoginRepository = userLoginRepository;
        this.customerRepository = customerRepository;
    }

    // Xác thực người dùng theo email và mật khẩu
    public UserLogin authenticate(String email, String password) {
        return userLoginRepository.findByEmailAndUserPassword(email, password);
    }

    // Lấy Customer của user theo userId
    public Customer getCustomerByUserId(String userId) {
        return customerRepository.findByUserlogin_UserId(userId);
    }
}