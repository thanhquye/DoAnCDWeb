package com.example.Movie_Ticket_Website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/home?action=direct";
    }
}
