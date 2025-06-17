package com.example.Movie_Ticket_Website.controller.admin;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.UserLoginService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/userManagement")
public class UserManagerController {

    @Autowired
    private UserLoginService userLoginService;

    // Hiển thị trang quản lý người dùng
    @GetMapping
    public String getAllUsers(HttpSession session, Model model) {
        UserLogin admin = (UserLogin) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/"; // chưa đăng nhập
        }

        List<UserLogin> userList = userLoginService.getAllUserLogins();
        model.addAttribute("userList", userList);
        model.addAttribute("showAll", true);
        return "admin/quanlinguoidung";
    }

    // Xoá người dùng
    @DeleteMapping
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestParam("userID") String userId) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean deleted = userLoginService.deleteUserById(userId);
            if (deleted) {
                System.out.println("Đã xóa người dùng với userID: " + userId);
                response.put("status", 200);
                response.put("message", "Đã xóa thành công");
            } else {
                System.out.println("Xóa người dùng không thành công với userID: " + userId);
                response.put("status", 500);
                response.put("message", "Xóa thất bại");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa người dùng với userID " + userId + ": " + e.getMessage());
            response.put("status", 500);
            response.put("message", "Xóa thất bại do lỗi máy chủ");
        }
        return response;
    }

    // Chặn hoặc mở chặn người dùng
    @PutMapping
    @ResponseBody
    public Map<String, Object> toggleActive(@RequestParam("userID") String userId) {
        Map<String, Object> response = new HashMap<>();
        boolean success = userLoginService.toggleActiveStatus(userId);
        if (success) {
            boolean isActive = userLoginService.getUserByUserID(userId).isActive();

            System.out.println("CHẶN/MỞ: " + userId);

            response.put("status", 200);
            response.put("message", isActive ? "Đã mở chặn thành công" : "Đã chặn thành công");
        } else {
            response.put("status", 500);
            response.put("message", "Thất bại");
        }
        return response;
    }


}