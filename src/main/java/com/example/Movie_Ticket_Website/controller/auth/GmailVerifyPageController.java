package com.example.Movie_Ticket_Website.controller.auth;

import com.example.Movie_Ticket_Website.model.UserLogin;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GmailVerifyPageController {

    @GetMapping("/GmailVerify")
    public String showGmailVerifyPage(HttpSession session, Model model) {
        UserLogin user = (UserLogin) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login"; // nếu chưa đăng nhập
        }
        model.addAttribute("user", user); // truyền vào JSP, EL
        return "GmailVerify"; // /WEB-INF/jsp/GmailVerify.jsp
    }
}
