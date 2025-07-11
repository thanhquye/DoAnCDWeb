<%@ page import="com.example.Movie_Ticket_Website.model.UserLogin" %>
<%@ page import="com.example.Movie_Ticket_Website.model.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Movie_Ticket_Website.beans.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    UserLogin user = (UserLogin) session.getAttribute("user");
    boolean isLogined = user == null ? false : true;
%>

<%--<%--%>
<%--    int cartSize = (int) session.getAttribute("cartSize");--%>
<%--%>--%>

<%
    int cartSize = session.getAttribute("cartSize") != null
            ? (Integer) session.getAttribute("cartSize")
            : 0;
%>

<header id="site-header" class="w3l-header fixed-top">
    <nav class="navbar navbar-expand-lg navbar-light fill px-lg-0 py-0 px-3">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home?action=direct">
                <img src="${pageContext.request.contextPath}/assets/images/icon_banner.jpg" alt="PZO TICKET"
                     title="PZO TICKET" style="height:35px;"/>PZO TICKET</a>
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="fa icon-expand fa-bars"></span>
                <span class="fa icon-close fa-times"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="/">Trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="movie?action=init">Phim</a></li>
                    <li class="nav-item"><a class="nav-link" href="showTimes?action=init">Lịch chiếu</a></li>
                    <li class="nav-item"><a class="nav-link" href="about">Thông tin</a></li>
                    <li class="nav-item"><a class="nav-link" href="contact">Liên hệ</a></li>
                </ul>
                <div class="Login_SignUp" id="login"
                     style="font-size: 2rem ; display: inline-block; position: relative;border-radius: 5px; ">
                    <a class="nav-link" href="login" style="padding: 0px 0px;">
                        <ul class="navbar-nav ml-auto">
                            <% if (isLogined) { %>
                            <li class="nav-item "><a class="nav-link" href="/"
                                                     style="padding-right: 1rem; padding-left: 1rem">Chào, ${sessionScope.get("userName")}</a>
                            </li>
                            <li class="nav-item "><a class="nav-link" href="/logout"
                                                     style="padding-right: 1rem; padding-left: 1rem">Đăng xuất</a></li>
                            <% } else { %>
                            <li class="nav-item "><a class="nav-link" href="login"
                                                     style="padding-right: 1rem; padding-left: 1rem">Đăng nhập</a></li>
                            <% } %>
                        </ul>
                    </a>
                </div>
                <%--  shopping cart icon --%>
                <div class="search-right">
                    <a href="shoppingCart?action=view" class="btn search-hny mr-lg-3 mt-lg-0 mt-4" title="search">
                        <i class="fa-solid fa-cart-shopping "></i> ( <%=cartSize %>)
                    </a>
                </div>
                <%--  search movie btn --%>
                <div class="search-right">
                    <a href="movie?action=init" class="btn search-hny mr-lg-3 mt-lg-0 mt-4" title="search">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </a>
                    <!-- search popup -->
                    <div id="search" class="pop-overlay">
                        <div class="popup">
                            <form action="home" method="get" class="search-box">
                                <input type="hidden" name="action" value="search-bar">
                                <input type="search" placeholder="Search your Keyword" name="search"
                                       required="required" autofocus="" style="color: black">
                                <button type="submit" class="btn"><span class="fa fa-search"
                                                                        aria-hidden="true"></span></button>
                            </form>
                            <div class="browse-items">
                                <h3 class="hny-title two mt-md-5 mt-4">Browse all:</h3>
                                <ul class="search-items">
                                    <li><a href="movies.html">Action</a></li>
                                    <li><a href="movies.html">Drama</a></li>
                                    <li><a href="movies.html">Family</a></li>
                                    <li><a href="movies.html">Thriller</a></li>
                                    <li><a href="movies.html">Commedy</a></li>
                                    <li><a href="movies.html">Romantic</a></li>
                                    <li><a href="movies.html">Tv-Series</a></li>
                                    <li><a href="movies.html">Horror</a></li>
                                    <li><a href="movies.html">Action</a></li>
                                    <li><a href="movies.html">Drama</a></li>
                                    <li><a href="movies.html">Family</a></li>
                                    <li><a href="movies.html">Thriller</a></li>
                                    <li><a href="movies.html">Commedy</a></li>
                                    <li><a href="movies.html">Romantic</a></li>
                                    <li><a href="movies.html">Tv-Series</a></li>
                                    <li><a href="movies.html">Horror</a></li>
                                </ul>
                            </div>
                        </div>
                        <a class="close" href="#close">×</a>
                    </div>

                </div>
            </div>
            <div class="mobile-position">
                <nav class="navigation">
                    <div class="theme-switch-wrapper">
                        <label class="theme-switch" for="checkbox">
                            <input type="checkbox" id="checkbox">
                            <div class="mode-container">
                                <i class="gg-sun"></i>
                                <i class="gg-moon"></i>
                            </div>
                        </label>
                    </div>
                </nav>
            </div>
        </div>
    </nav>
</header>
<script>
    var btns = document.getElementsByClassName("nav-item");
    console.log(btns);
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function () {
            console.log(this.className);
            console.log("check");
            this.className += " active";
        });
    }
</script>
