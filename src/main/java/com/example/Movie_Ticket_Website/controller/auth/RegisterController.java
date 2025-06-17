package com.example.Movie_Ticket_Website.controller.auth;

import com.example.Movie_Ticket_Website.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // register.jsp
    }

    @PostMapping("/register")
    public String processRegister(HttpServletRequest request, Model model,
                                  RedirectAttributes redirectAttributes) throws Exception {
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retypePassword");

        if (registerService.checkEmailExists(email)) {
            model.addAttribute("status", "email_exists");
            return "register";
        }

        if (registerService.checkUsernameExists(userName)) {
            model.addAttribute("status", "username_exists");
            return "register";
        }

        if (!password.equals(retypePassword) || password.length() < 6) {
            model.addAttribute("status", "password_error");
            return "register";
        }

        boolean result = registerService.registerUser(userName, email, password);
        if (result) {
            System.out.println("register success");
            redirectAttributes.addFlashAttribute("registerSuccess", "true");
            return "redirect:/login";
        } else {
            model.addAttribute("status", "failed");
            System.out.println("register Failed!");
            return "register";
        }
    }
}