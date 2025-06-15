//package com.example.Movie_Ticket_Website.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class LoginPageAccessFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpSession session = httpRequest.getSession(false);
//
//        String path = httpRequest.getRequestURI();
//
//        boolean isLoggedIn = (session != null) && (session.getAttribute("user") != null);
//
//        // Nếu đã đăng nhập mà truy cập vào /login, /register, /forgotPass thì redirect đi
//        if (isLoggedIn && (path.equals("/login") || path.equals("/register") || path.equals("/forgotPass"))) {
//            if (session.getAttribute("admin") != null) {
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/adminHome");
//            } else {
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
//                System.out.println("Login already! sent to home.");
//            }
//            return; // kết thúc filter chain
//        }
//
//        // Các trường hợp khác vẫn cho phép request đi tiếp
//        chain.doFilter(request, response);
//    }
//}