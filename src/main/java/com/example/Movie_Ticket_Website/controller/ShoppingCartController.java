package com.example.Movie_Ticket_Website.controller;

import com.example.Movie_Ticket_Website.beans.ShoppingCart;
import com.example.Movie_Ticket_Website.service.CinemaService;
import com.example.Movie_Ticket_Website.service.MovieService;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String handleCart(
            @RequestParam String action,
            HttpSession session
            ){

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        return switch (action) {
            case "view" -> viewCart(session);
            case "add" -> addToCart(session);  // hoặc dùng @PostMapping cho đúng REST
            case "update" -> updateCart(session);
            case "remove" -> removeMovie(session);
            default -> "redirect:/404";
        };

    }
    private String viewCart(HttpSession session) {
        // Hiển thị trang giỏ hàng, bạn có thể thêm model nếu cần
        return "cart"; // → cart.jsp (trong /WEB-INF/views/)
    }

    private String addToCart(HttpSession session) {
        // Viết logic thêm phim vào giỏ hàng
        return "redirect:/shoppingCart?action=view";
    }

    private String updateCart(HttpSession session) {
        // Viết logic cập nhật số lượng trong giỏ
        return "redirect:/shoppingCart?action=view";
    }

    private String removeMovie(HttpSession session) {
        // Viết logic xoá phim khỏi giỏ
        return "redirect:/shoppingCart?action=view";
    }

}
