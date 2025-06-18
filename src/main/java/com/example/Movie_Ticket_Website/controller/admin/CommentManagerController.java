package com.example.Movie_Ticket_Website.controller.admin;

import com.example.Movie_Ticket_Website.dto.CommentDTO;
import com.example.Movie_Ticket_Website.service.UserCommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/commentManagement")
public class CommentManagerController {

    @Autowired
    private UserCommentService userCommentService;

    // Hiển thị tất cả bình luận
    @GetMapping
    public String getAllComments(HttpSession session, Model model) {
        Object admin = session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/404.jsp";
        }

        List<CommentDTO> commentList = userCommentService.getAllComments();
        model.addAttribute("commentList", commentList);
        model.addAttribute("showAll", true);

        return "admin/quanlibinhluan"; // JSP tương ứng trong templates
    }

    // Xoá bình luận
    @PostMapping
    @ResponseBody
    public Map<String, Object> deleteComment(@RequestParam("commentID") String commentID) {
        Map<String, Object> response = new HashMap<>();
        System.out.println("==> Nhận được commentID từ client: " + commentID);

        if (commentID == null || commentID.trim().isEmpty()) {
            response.put("status", 400);
            response.put("message", "commentID bị rỗng!");
            return response;
        }

        try {
            userCommentService.deleteCommentById(commentID);
            response.put("status", 200);
            System.out.println("Xóa comment user thành công");
            response.put("message", "Đã xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", 500);
            response.put("message", "Xóa bình luận thất bại");
        }
        return response;
    }

}
