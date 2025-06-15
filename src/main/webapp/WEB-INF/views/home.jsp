<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Movie_Ticket_Website.model.UserLogin" %>

<%
    UserLogin user = (UserLogin) session.getAttribute("user");
%>

<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home page</h1>

<%-- Để test --%>
<% if (user != null) { %>
<p>Xin chào, <%= user.getUserName() %>!</p>

<% if (user.isVerifyEmail()) { %>
<div style="color: green; font-weight: bold;">
    ✅ Gmail của bạn đã được xác minh!
</div>
<a class="nav-link" href="/logout" style="padding-right: 1rem; padding-left: 1rem">Đăng xuất</a>
<% } else { %>
<div style="color: red; font-weight: bold;">
    ⚠️ Gmail chưa được xác minh. <a href="/GmailVerify">Xác minh ngay</a>
</div>
<% } %>
<% } else { %>
<p>Bạn chưa đăng nhập. <a href="/login">Đăng nhập</a></p>
<% } %>

</body>
</html>