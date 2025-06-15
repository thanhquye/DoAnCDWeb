package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.model.Cinema;
import com.example.Movie_Ticket_Website.service.CinemaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

@Controller
@RequestMapping("/showCinemaNameAjax")
public class showCinemaNameAJAX {
    @Autowired
    CinemaService cinemaService;

    @GetMapping
    @ResponseBody
    public String showCinemaNameAjax(
            @RequestParam(name = "cid", required = false) String cid,
            HttpSession session, Model model) {
        try {
            Cinema cinemaDetail = cinemaService.getCinemaByID(cid);
            model.addAttribute("cinemaDetail", cinemaDetail);

            return "<h2 style=\"font-size: 25px;padding-bottom: 5px\"><i class=\"fa-solid fa-film\"> </i> " + cinemaDetail.getCinemaName() + "  </h2>\n" +
                    "                                <h4 style=\"font-size: 17px; font-weight: lighter;padding-bottom: 10px\">  " + cinemaDetail.getLocation() + "</h4>";
        } catch (Exception e) {
            e.printStackTrace();
            return "<p>Error occurred while loading cinema details.</p>";
        }
    }

}
