package com.example.Movie_Ticket_Website.controllerValidate;

import com.example.Movie_Ticket_Website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class ValidateEmailController {
    // kiểm tra gmail có tồn tại trong db không - forgotPass
    private final UserService userService;

    @Autowired
    public ValidateEmailController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/validate-email")
    public ResponseEntity<Map<String, Boolean>> validateEmail(@RequestParam String email) {
        boolean isValid = email != null &&
                email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$") &&
                userService.isEmailExists(email);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isValid", isValid);
        return ResponseEntity.ok(response);
    }
}