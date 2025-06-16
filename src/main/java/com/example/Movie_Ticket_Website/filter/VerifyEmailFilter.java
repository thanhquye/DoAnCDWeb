package com.example.Movie_Ticket_Website.filter;

import com.example.Movie_Ticket_Website.model.UserLogin;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class VerifyEmailFilter implements Filter {

    // Bao gồm các đường dẫn tĩnh từ resources
    private static final Set<String> STATIC_PATH_PREFIXES = new HashSet<>(Arrays.asList(
            "/resources/", "/css/", "/js/", "/images/", "/assets/", "/admin/", "/static/", "/img/"
            , "/css_made/"
    ));

    private static final Set<String> PUBLIC_PATHS = new HashSet<>(Arrays.asList(
            "/login", "/register", "/forgot-pass", "/forgotPass", "/home", "/userpage",
            "/logout", "/", "/shop", "/about", "/contact", "/GmailVerify", "/verify"
    ));

    // API được phép truy cập mà không cần xác minh email
    private static final Set<String> API_WHITELIST = new HashSet<>(Arrays.asList(
            "/api/resendVerification",
            "/api/verify",
            "/api/auth/validate-email",
            "/api/auth/check-user-email"
    ));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI().substring(req.getContextPath().length());
        UserLogin user = (session != null) ? (UserLogin) session.getAttribute("user") : null;

        // Bỏ qua tài nguyên tĩnh
        for (String prefix : STATIC_PATH_PREFIXES) {
            if (path.startsWith(prefix)) {
                chain.doFilter(request, response);
                return;
            }
        }

        // Bỏ qua các đường dẫn public
        if (PUBLIC_PATHS.contains(path)) {
            chain.doFilter(request, response);
            return;
        }

        // Nếu là API nằm trong whitelist thì không cần xác minh email
        if (path.startsWith("/api/")) {
            for (String allowedApi : API_WHITELIST) {
                if (path.startsWith(allowedApi)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }

        // Nếu chưa login → redirect về login
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Nếu đã login nhưng chưa xác minh email → chỉ cho vào /GmailVerify và API cho phép
        if (!user.isVerifyEmail() && !path.startsWith("/GmailVerify")) {
            resp.sendRedirect(req.getContextPath() + "/GmailVerify");
            return;
        }

        chain.doFilter(request, response);
    }
}