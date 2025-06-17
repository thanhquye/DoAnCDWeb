package com.example.Movie_Ticket_Website.controller.admin;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.admin.AdminDashboardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    private AdminDashboardService dashboardService;

    @GetMapping("/home")
    public String adminHome(Model model, HttpSession session) {
        UserLogin admin = (UserLogin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/"; // chưa đăng nhập
        }

        // ✅ Ép kiểu về int để tránh ClassCastException
        model.addAttribute("userOnl", (int) dashboardService.countOnlineUsers());
        model.addAttribute("ticketQuantity", (int) dashboardService.countTickets());
        model.addAttribute("totalMovie", (int) dashboardService.totalMovies());

        // ✅ totalEarning là double
        model.addAttribute("totalEarning", dashboardService.totalEarning());

        model.addAttribute("Top10MovieEarning", dashboardService.getTop10MovieEarnings());

        return "admin/adminhome";// adminhome.jsp ở trong thư mục admin

    }
}