package com.example.Movie_Ticket_Website.controller.admin;

import com.example.Movie_Ticket_Website.dto.TicketWithCustomerDTO;
import com.example.Movie_Ticket_Website.dto.TicketWithMovieDTO;
import com.example.Movie_Ticket_Website.model.Ticket;
import com.example.Movie_Ticket_Website.model.TicketDetail;
import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.TicketDetailService;
import com.example.Movie_Ticket_Website.service.TicketService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class TicketManagerController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketDetailService ticketDetailService;

    @GetMapping("/quanlive")
    public String admin(@RequestParam(name = "action", required = false) String action,
                        @RequestParam(name = "tid", required = false) String tid,
                        HttpSession session,
                        Model model
                            ) {
        UserLogin user = (UserLogin) session.getAttribute("admin");
        if (user == null) {
            return "redirect:/login";
        }
        if (action == null) {action = "int"; }
        return switch (action) {
            case "init" -> showAllTicket(session,model);
            case "detail" -> ShowTicketDetail(tid, session, model);

            default -> "redirect:/admin/quanlive?action=init";
        };



    }


    private String ShowTicketDetail(String tid, HttpSession session, Model model) {
        TicketWithMovieDTO ticket = ticketDetailService.getTicketDetailByTicketId(tid);
        model.addAttribute("ticketDetail",ticket);
       return "admin/ticketDetail";
    }

    private String showAllTicket(HttpSession session, Model model) {
        model.addAttribute("tickets", ticketService.getAllTicket());

        model.addAttribute("showAll", true);

        return "admin/quanlive";
    }
    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<?> deleteTicket(@RequestParam("tid") String ticketId) {
        System.out.println("deleteTicket");
        try {
            Ticket ticket = ticketService.getTicketByTicketID(ticketId);
            ticketService.deleteTicket(ticket);
            return ResponseEntity.ok().build(); // trả về HTTP 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi xóa");
        }


    }
}
