<%@ page import="java.util.List" %>
<%@ page import="com.example.Movie_Ticket_Website.dto.FilmEarning" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    int userOnl = (Integer) request.getAttribute("userOnl");
    int ticketQuantity = (Integer) request.getAttribute("ticketQuantity");
    int totalMovie = (Integer) request.getAttribute("totalMovie");
    double totalEarning = (Double) request.getAttribute("totalEarning");
    List<FilmEarning> filmEarnings = (List<FilmEarning>) request.getAttribute("Top10MovieEarning");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Title Page-->
    <title>ADMIN HOME</title>

    <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/admin/css/font-face.css" rel="stylesheet" media="all">
    <%--    <link href="admin/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">--%>
    <%--    <link href="admin/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">--%>
    <link href="${pageContext.request.contextPath}/admin/vendor/mdi-font/css/material-design-iconic-font.min.css"
          rel="stylesheet" media="all">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">

    <!-- Bootstrap CSS-->
    <link href="${pageContext.request.contextPath}/admin/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
          media="all">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/admin/vendor/animsition/animsition.min.css" rel="stylesheet"
          media="all">
    <link href="${pageContext.request.contextPath}/admin/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
          rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/admin/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/admin/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
          media="all">
    <link href="${pageContext.request.contextPath}/admin/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/admin/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/admin/vendor/perfect-scrollbar/perfect-scrollbar.css"
          rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/admin/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">

    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="adminHome">
                        <img src="${pageContext.request.contextPath}/assets/images/icon_banner.jpg" alt="PZO TICKET" title="PZO TICKET"
                             style="height:35px;"/>
                        PZO TICKET
                    </a>
                    <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                    </button>
                </div>
            </div>
        </div>
        <nav class="navbar-mobile">
            <div class="container-fluid">
                <ul class="navbar-mobile__list list-unstyled">
                    <li>
                        <a class="js-arrow" href="quanlinguoidung">
                            <i class="fas fa-tachometer-alt"></i>Quản Lí Người Dùng</a>
                    </li>
                    <li>
                        <a href="quanliphim">
                            <i class="fas fa-chart-bar"></i>Quản Lí Phim
                        </a>
                    </li>
                    <li>
                        <a href="quanlive">
                            <i class="fas fa-table"></i>Quản Lí vé
                        </a>

                    </li>
                    <li>
                        <a href="quanlibinhluan">
                            <i class="far fa-check-square"></i>Quản Lí Bình Luận
                        </a>
                    </li>

                </ul>
            </div>
        </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="adminHome">
                <img src="${pageContext.request.contextPath}/assets/images/icon_banner.jpg" alt="PZO TICKET"
                     title="PZO TICKET" style="height:35px;"/>
                PZO TICKET
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li>
                        <a class="js-arrow" href="quanlinguoidung">
                            <i class="fas fa-tachometer-alt"></i>Quản Lí Người Dùng</a>
                    </li>
                    <li>
                        <a href="quanliphim">
                            <i class="fas fa-chart-bar"></i>Quản Lí Phim
                        </a>
                    </li>
                    <li>
                        <a href="quanlive">
                            <i class="fas fa-table"></i>Quản Lí vé
                        </a>
                    </li>
                    <li>
                        <a href="quanlibinhluan">
                            <i class="far fa-check-square"></i>Quản Lí Bình Luận
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">

                        <%-- Form tìm kiếm --%>
                        <form class="form-header" action="" method="POST">
                            <input class="au-input au-input--xl" type="text" name="search" placeholder="Tìm kiếm..."/>
                            <button class="au-btn--submit" type="submit">
                                <i class="zmdi zmdi-search"></i>
                            </button>
                        </form>

                        <div class="header-button">
                            <div class="noti-wrap">
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-comment-more"></i>
                                    <span class="quantity">1</span>

                                    <%-- Xem tin nhắn --%>
                                    <div class="mess-dropdown js-dropdown">
                                        <div class="mess__title">
                                            <p>Bạn có 2 tin nhắn</p>
                                        </div>

                                        <div class="mess__item">
                                            <div class="image img-cir img-40">
                                                <img src="assets/images/thanh_phat_avt.png" alt="Thanh Phát"/>
                                            </div>
                                            <div class="content">
                                                <h6>Thanh Phát</h6>
                                                <p>Đã gửi một bức ảnh</p>
                                                <span class="time">3 phút trước</span>
                                            </div>
                                        </div>

                                        <div class="mess__footer">
                                            <a href="#">Xem tất cả tin nhắn</a>
                                        </div>
                                    </div>
                                </div>

                                <%-- thông báo ở đây --%>
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-notifications"></i>
                                    <span class="quantity">3</span>
                                    <div class="notifi-dropdown js-dropdown">
                                        <div class="notifi__title">
                                            <p>Bạn có 3 thông báo</p>
                                        </div>

                                        <div class="notifi__item">
                                            <div class="bg-c1 img-cir img-40">
                                                <i class="zmdi zmdi-email-open"></i>
                                            </div>
                                            <div class="content">
                                                <p>Bạn đã nhận được thông báo qua email</p>
                                                <span class="date">21-01-2024, 06:50</span>
                                            </div>
                                        </div>

                                        <div class="notifi__footer">
                                            <a href="#">Tất cả thông báo</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <%-- Profile --%>
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="${pageContext.request.contextPath}/assets/images/thanh_quyen_avt.png"
                                             alt="Thanh Quyen"/>
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">Thanh Quyen</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/assets/images/thanh_quyen_avt.png"
                                                         alt="Thanh Quyen"/>
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">Thanh Quyen</a>
                                                </h5>
                                                <span class="email">ThanhQuyen@email.com</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-account"></i>Tài khoản</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-settings"></i>Cài đặt</a>
                                            </div>
                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-money-box"></i>Thanh toán</a>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="${pageContext.request.contextPath}/logout">
                                                <i class="zmdi zmdi-power"></i>Đăng xuất</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="overview-wrap">
                                <h2 class="title-1">Tổng quan</h2>
                                <button class="au-btn au-btn-icon au-btn--blue">
                                    <i class="zmdi zmdi-plus"></i>Tạo mới
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="row m-t-25">
                        <div class="col-sm-6 col-lg-3">
                            <div class="overview-item overview-item--c1">
                                <div class="overview__inner">
                                    <div class="overview-box clearfix">
                                        <div class="icon">
                                            <i class="zmdi zmdi-account-o"></i>
                                        </div>
                                        <div class="text">
                                            <h2><%=userOnl%>
                                            </h2>
                                            <span>đang hoạt động</span>
                                        </div>
                                    </div>
                                    <div class="overview-chart">
                                        <canvas id="widgetChart1"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-3">
                            <div class="overview-item overview-item--c2">
                                <div class="overview__inner">
                                    <div class="overview-box clearfix">
                                        <div class="icon">
                                            <i class="zmdi zmdi-shopping-cart"></i>
                                        </div>
                                        <div class="text">
                                            <h2><%=ticketQuantity%>
                                            </h2>
                                            <span>Tổng số vé</span>
                                        </div>
                                    </div>
                                    <div class="overview-chart">
                                        <canvas id="widgetChart2"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-3">
                            <div class="overview-item overview-item--c3">
                                <div class="overview__inner">
                                    <div class="overview-box clearfix">
                                        <div class="icon">
                                            <i class="fa-solid fa-film"></i>
                                        </div>
                                        <div class="text">
                                            <h2><%=totalMovie%>
                                            </h2>
                                            <span>Tổng số phim</span>
                                        </div>
                                    </div>
                                    <div class="overview-chart">
                                        <canvas id="widgetChart3"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-3">
                            <div class="overview-item overview-item--c4">
                                <div class="overview__inner" style="padding-bottom: 33px">
                                    <div class="overview-box clearfix">
                                        <div class="icon">
                                            <i class="zmdi zmdi-money"></i>
                                        </div>
                                        <div class="text">
                                            <%-- <h2><%=totalEarning%></h2>--%>
                                            <h2><fmt:formatNumber value="${totalEarning}" type="currency"/></h2>
                                            <span>Tổng thu nhập</span>
                                        </div>
                                    </div>
                                    <div class="overview-chart">
                                        <canvas id="widgetChart4"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="au-card recent-report">
                                <div class="au-card-inner">
                                    <h3 class="title-2">báo cáo gần đây</h3>
                                    <div class="chart-info">
                                        <div class="chart-info__left">
                                            <div class="chart-note">
                                                <span class="dot dot--blue"></span>
                                                <span>các sản phẩm</span>
                                            </div>
                                            <div class="chart-note mr-0">
                                                <span class="dot dot--green"></span>
                                                <span>dịch vụ</span>
                                            </div>
                                        </div>
                                        <div class="chart-info__right">
                                            <div class="chart-statis">
                                                    <span class="index incre">
                                                        <i class="zmdi zmdi-long-arrow-up"></i>25%</span>
                                                <span class="label">các sản phẩm</span>
                                            </div>
                                            <div class="chart-statis mr-0">
                                                    <span class="index decre">
                                                        <i class="zmdi zmdi-long-arrow-down"></i>10%</span>
                                                <span class="label">dịch vụ</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="recent-report__chart">
                                        <canvas id="recent-rep-chart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="au-card chart-percent-card">
                                <div class="au-card-inner">
                                    <h3 class="title-2 tm-b-5">Tỉ lệ %</h3>
                                    <div class="row no-gutters">
                                        <div class="col-xl-6">
                                            <div class="chart-note-wrap">
                                                <div class="chart-note mr-0 d-block">
                                                    <span class="dot dot--blue"></span>
                                                    <span>các sản phẩm</span>
                                                </div>
                                                <div class="chart-note mr-0 d-block">
                                                    <span class="dot dot--red"></span>
                                                    <span>dịch vụ</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-6">
                                            <div class="percent-chart">
                                                <canvas id="percent-chart"></canvas>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <h2 class="title-1 m-b-25">10 phim có doanh thu cao nhất</h2>
                        <div class="table-responsive table--no-card m-b-40">
                            <table class="table table-borderless table-striped table-earning">
                                <thead>
                                <tr>
                                    <th>ID phim</th>
                                    <th>Tên phim</th>
                                    <th>Thể loại</th>
                                    <th>Ngày sản xuất</th>
                                    <th>Quốc gì</th>
                                    <th>Đánh giá</th>
                                    <th class="text-right">Tổng</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%for (FilmEarning filmEarning : filmEarnings) {%>
                                <tr>
                                    <td><%=filmEarning.getMovieID()%>
                                    </td>
                                    <td><%=filmEarning.getMovieName()%>
                                    </td>
                                    <td><%=filmEarning.getMovieCategory()%>
                                    </td>
                                    <td><%=filmEarning.getReleaseDate()%>
                                    </td>
                                    <td><%=filmEarning.getCountry()%>
                                    </td>
                                    <td><%=filmEarning.getMovieScore()%>
                                    </td>
                                    <%-- <td class="text-right"><%=FilmEarning.getPrice()%></td>--%>
                                    <td class="text-right"><fmt:formatNumber value="${filmEaring.total}"
                                                                             type="currency"/></td>

                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT-->

        <!-- END PAGE CONTAINER-->
    </div>

</div>

<!-- Jquery JS-->
<script src="${pageContext.request.contextPath}/admin/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="${pageContext.request.contextPath}/admin/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="${pageContext.request.contextPath}/admin/vendor/slick/slick.min.js">
</script>
<script src="${pageContext.request.contextPath}/admin/vendor/wow/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/animsition/animsition.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="${pageContext.request.contextPath}/admin/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="${pageContext.request.contextPath}/admin/vendor/circle-progress/circle-progress.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="${pageContext.request.contextPath}/admin/js/main.js"></script>

</body>

</html>
<!-- end document-->
