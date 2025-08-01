package com.example.Movie_Ticket_Website.controllerValidate;

import com.example.Movie_Ticket_Website.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class ValidateUserController {
    // kiểm tra gmail và username trong Register
    @Autowired
    private RegisterService registerService;

    @PostMapping("/check-user-email")
    public Map<String, Boolean> check(@RequestParam(required = false) String username,
                                      @RequestParam(required = false) String email) {
        Map<String, Boolean> result = new HashMap<>();
        result.put("usernameExists", username != null && registerService.checkUsernameExists(username));
        result.put("emailExists", email != null && registerService.checkEmailExists(email));
        return result;
    }

}