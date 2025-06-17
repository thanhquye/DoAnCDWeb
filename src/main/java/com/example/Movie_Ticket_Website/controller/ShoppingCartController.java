package com.example.Movie_Ticket_Website.controller;


import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
import com.example.Movie_Ticket_Website.dto.TicketCartDTO;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.CartService;
import com.example.Movie_Ticket_Website.service.CinemaService;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public String ShoppingCartRedirect(@RequestParam(name = "action", required = false) String action,
                                @RequestParam(name = "cid", required = false) String cid,
                                @RequestParam(name = "cinemaName", required = false) String cinemaName,
                                @RequestParam(name = "movieID", required = false) String mid,
                                @RequestParam(name = "date", required = false) String date,
                                @RequestParam(name = "category", required = false) String category,
                                @RequestParam(name = "country", required = false) String country,
                                @RequestParam(name = "year", required = false) String year,
                                HttpSession session, Model model) {


        return switch (action) {
            case "view" -> viewCart(session,model);
            case "add" -> addToCart(mid,session);
            case "update" -> updateCart(session);
            case "remove" -> removeMovie(session);
            case "directHome" -> directHome(session);
            default -> "redirect:/404";
        };

    }

    private String directHome(HttpSession session) {
        return "redirect:/home?action=direct";
    }

    private String viewCart(HttpSession session,Model model) {
        UserLogin userLogin = (UserLogin) session.getAttribute("user");

        if (userLogin == null) {
            return "redirect:/login";
        }
        List<Ticket> tickets = cartService.getCartByUserID(userLogin.getUserId());

        List<TicketCartDTO> cartDTOS = new ArrayList<>();
        for (Ticket ticket : tickets) {
            cartDTOS.add(cartService.getTicketByTicketID(ticket.getTicketID()));

        }
        // test
        int totalPrice = 0;
        for (TicketCartDTO ticketCartDTO : cartDTOS) {
            totalPrice += ticketCartDTO.getMoviePrice();
        }

        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cartDTOS", cartDTOS);
        model.addAttribute("totalTicket", tickets.size());

        return "shoppingCart";

    }

    private String addToCart(String mid, HttpSession session) {

        return "shoppingCart";
    }

    private String updateCart(HttpSession session) {

        return "shoppingCart";
    }

    private String removeMovie(HttpSession session) {
        return "shoppingCart";
    }

}
