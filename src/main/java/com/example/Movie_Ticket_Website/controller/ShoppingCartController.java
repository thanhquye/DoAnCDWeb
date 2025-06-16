package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.beans.CartItem;
import com.example.Movie_Ticket_Website.beans.ShoppingCart;
import com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO;
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

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private UserCommentService userCommentService;

    @GetMapping
    public String movieRedirect(@RequestParam(name = "action", required = false) String action,
                                @RequestParam(name = "cid", required = false) String cid,
                                @RequestParam(name = "cinemaName", required = false) String cinemaName,
                                @RequestParam(name = "movieID", required = false) String mid,
                                @RequestParam(name = "date", required = false) String date,
                                @RequestParam(name = "category", required = false) String category,
                                @RequestParam(name = "country", required = false) String country,
                                @RequestParam(name = "year", required = false) String year,
                                HttpSession session, Model model) {

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        return switch (action) {
            case "view" -> viewCart(model);
            case "add" -> addToCart(mid,session);
            case "update" -> updateCart(session);
            case "remove" -> removeMovie(session);
            default -> "redirect:/404";
        };

    }
    private String viewCart(Model model) {

        return "shoppingCart";

    }

    private String addToCart(String mid, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        MovieWithMediaDTO movie = movieService.getMovieByID(mid);

        CartItem item = new CartItem();
//        item.setMovie(movie);
        item.setQuanlity(1);
        item.setPrice(50000);
        cart.add(item);
        session.setAttribute("cart",cart);
        return "shoppingCart";
    }

    private String updateCart(HttpSession session) {

        return "shoppingCart";
    }

    private String removeMovie(HttpSession session) {
        return "shoppingCart";
    }

}
