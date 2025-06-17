package com.example.Movie_Ticket_Website.controllerValidate;

import com.example.Movie_Ticket_Website.model.UserLogin;
import com.example.Movie_Ticket_Website.service.EmailService;
import com.example.Movie_Ticket_Website.service.UserLoginService;
import com.example.Movie_Ticket_Website.verifyCode.VerificationCodeStore;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class VerificationEmailController {
    // Thực hiển gửi gmail chứa mã code đi và kiểm tra code để cập nhật isVerifyEmail.
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/resendVerification")
    public Map<String, Object> resendVerification(HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        UserLogin user = (UserLogin) session.getAttribute("user");
        if (user == null) {
            response.put("status", "error");
            response.put("message", "Không tìm thấy người dùng trong session.");
            return response;
        }

        String email = user.getEmail();
        String username = user.getUserName();

        Long lastSentTime = (Long) session.getAttribute("lastVerificationEmailTime");
        long now = System.currentTimeMillis();
        if (lastSentTime != null && now - lastSentTime < 90 * 1000) {
            response.put("status", "error");
            response.put("message", "Vui lòng chờ 90s trước khi gửi lại.");
            return response;
        }

        String code = UUID.randomUUID().toString();
        VerificationCodeStore.store(email, code);

        boolean sent = emailService.sendVerificationEmail(email, code, username);
        if (sent) {
            session.setAttribute("lastVerificationEmailTime", now);
            response.put("status", "success");
            response.put("message", "Mã xác minh đã được gửi.");
        } else {
            response.put("status", "error");
            response.put("message", "Gửi email thất bại.");
        }

        System.out.println("Resend verification called by user: " + user.getUserName());

        return response;
    }

    @GetMapping("/verify")
    public void verifyEmail(@RequestParam("email") String email,
                            @RequestParam("code") String code,
                            HttpSession session,
                            HttpServletResponse response) throws IOException {
        if (VerificationCodeStore.verify(email, code)) {
            // Cập nhật cột isVerifyEmail
            userLoginService.markEmailVerified(email);

            // Cập nhật lại session userLogin
            UserLogin updatedUser = userLoginService.getUserByEmail(email);

            System.out.println("gmail verify + update session userLogin success!");

            session.setAttribute("user", updatedUser);

            // Thêm session để báo thành công
            String message = "Người dùng " + updatedUser.getUserName() + " với Gmail " + updatedUser.getEmail() + " đã được xác thực thành công!";
            session.setAttribute("verifySuccessMessage", message);

            VerificationCodeStore.remove(email);
            response.sendRedirect("/"); // chuyển tiếp về home
        } else {
            response.sendRedirect("/GmailVerify?status=invalid_code");
        }
    }
}
