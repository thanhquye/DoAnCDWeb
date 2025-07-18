package com.example.Movie_Ticket_Website.controller.auth;

import com.example.Movie_Ticket_Website.model.Customer;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Hiển thị trang đăng nhập (GET)
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // sẽ render file login.jsp dựa trên cấu hình view resolver
    }

    // Xử lý đăng nhập (POST)
    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        UserLogin user = loginService.authenticate(email, password);
        if (user != null) {
            Customer customer = loginService.getCustomerByUserId(user.getUserId());

            // Kiểm tra null trước khi gọi getFullName()
            String fullName = "Người dùng ẩn danh or chưa set trong customer";
            if (customer != null) {
                String nameFromDB = customer.getFullName();
                if (nameFromDB != null && !nameFromDB.isEmpty()) {
                    fullName = nameFromDB;
                }
            }

            System.out.println(fullName);
            session.setAttribute("user", user);
            session.setAttribute("customer", customer);
            session.setAttribute("userName", user.getUserName());
            if (customer != null) {
                session.setAttribute("customerID", customer.getCustomerID());
            }

            System.out.println("login success");

            if (user.isAdmin()) {
                session.setAttribute("admin", user);
                return "redirect:/admin/home";
            } else {
                if (!user.isVerifyEmail()) {
                    return "redirect:/GmailVerify";
                }
                return "redirect:/";
            }
        } else {
            // Đăng nhập thất bại
            model.addAttribute("status", "failed");
            return "login";
        }
    }
}