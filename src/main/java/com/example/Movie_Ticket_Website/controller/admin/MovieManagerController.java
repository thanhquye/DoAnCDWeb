package com.example.Movie_Ticket_Website.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MovieManagerController {

    @GetMapping("/movieManagerment")
    public String MovieManagerController() {


        return "admin/quanliphim";
    }
}
