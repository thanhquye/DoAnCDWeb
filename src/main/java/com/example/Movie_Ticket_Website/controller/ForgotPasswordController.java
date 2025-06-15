package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ForgotPasswordController {

    private final UserService userService;

    @Autowired
    public ForgotPasswordController(UserService userService) {
        this.userService = userService;
    }

    // render giao diện forgotpass.jsp
    @GetMapping("/forgotPass")
    public String showForgotPasswordPage() {
        return "forgotPass"; // sẽ hiển thị forgotPass.jsp từ thư mục /WEB-INF/views/
    }

    // Xử lý yêu cầu và trả về json
    @PostMapping("/forgot-pass")
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleForgotPasswordAjax(@RequestParam("email") String email) {
        String message = userService.resetPassword(email);

        Map<String, String> response = new HashMap<>();
        if (message.contains("đã được gửi")) {
            response.put("status", "success");
        } else {
            response.put("status", "error");
        }
        response.put("message", message);

        return ResponseEntity.ok(response);
    }

}