package com.example.Movie_Ticket_Website.controller.auth;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Xoá thông tin session (thông tin được set trong LoginController)
        session.removeAttribute("user");
        session.removeAttribute("admin");
        session.removeAttribute("customer");
        session.removeAttribute("userName");
        session.invalidate();

        System.out.println("Logout Success");

        // Quay về trang đăng nhập
        return "redirect:/login";
    }
}