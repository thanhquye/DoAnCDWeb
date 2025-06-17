package com.example.Movie_Ticket_Website.service;

import com.example.Movie_Ticket_Website.model.Customer;
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

        // Tạo UserLogin
        UserLogin user = new UserLogin();
        user.setUserId(newUserId);
        user.setUserName(userName);
        user.setEmail(email);
        user.setUserPassword(password);
        user.setActive(true);
        user.setAdmin(false);
        user.setVerifyEmail(false);

        // Tạo Customer (có thể để tên trống ban đầu)
        Customer customer = new Customer();
        customer.setCustomerID("cus" + String.format("%03d", maxId + 1)); // tự tạo ID
        customer.setFullName("");
        customer.setGender("");
        customer.setAddress("");
        customer.setPhoneNumber("");
        customer.setDob("");
        customer.setUserLogin(user); // liên kết

        user.setCustomer(customer); // set ngược lại để đảm bảo quan hệ 2 chiều

        // Lưu user là chính, vì cascade ALL sẽ lưu luôn customer
        userRepo.save(user);

        System.out.println("Saved userId: " + user.getUserId());
        System.out.println("Saved customerId: " + user.getCustomer().getCustomerID());

        return true;
    }
}