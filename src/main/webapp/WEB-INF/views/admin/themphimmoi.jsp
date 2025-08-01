<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO" %>
<%@ page import="com.example.Movie_Ticket_Website.model.Movie" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <!-- Title Page-->
    <title>UPDATE FILM</title>

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
    <!-- new css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style_admin.css">


</head>

<body>
<%--<%List<User> users = (List<User>) request.getAttribute("listUser");%>--%>
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="admin/home">
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
                    <li >
                        <a class="js-arrow"  href="/admin/quanlinguoidung">
                            <i class="fas fa-tachometer-alt"></i>Quản Lí Người Dùng</a>
                    </li>
                    <li class="active has-sub">
                        <a href="/admin/quanliphim">
                            <i class="fas fa-chart-bar"></i>Quản Lí Phim
                        </a>
                    </li>
                    <li >
                        <a href="/admin/quanlive">
                            <i class="fas fa-table"></i>Quản Lí vé
                        </a>

                    </li>
                    <li >
                        <a href="/admin/quanlibinhluan">
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
            <a href="/home">
                <img src="${pageContext.request.contextPath}/assets/images/icon_banner.jpg" alt="PZO TICKET" title="PZO TICKET" style="height:35px;"/>
                PZO TICKET
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li >
                        <a class="js-arrow"  href="/admin/quanlinguoidung">
                            <i class="fas fa-tachometer-alt"></i>Quản Lí Người Dùng</a>
                    </li>
                    <li class="active has-sub">
                        <a href="/admin/quanliphim">
                            <i class="fas fa-chart-bar"></i>Quản Lí Phim
                        </a>
                    </li>
                    <li >
                        <a href="/admin/quanlive">
                            <i class="fas fa-table"></i>Quản Lí vé
                        </a>

                    </li>
                    <li >
                        <a href="/admin/quanlibinhluan">
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

                        <form class="form-header" action="search?cid=0&uid=0&fid=0&tid=1" method="get">
                            <input class="au-input au-input--xl" type="text" name="search" placeholder="ID Rạp chiếu phim"/>
                            <button class="au-btn--submit" type="submit">
                                <i class="zmdi zmdi-search"></i>
                            </button>
                        </form>

                        <div class="header-button">
                            <div class="noti-wrap">
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-comment-more"></i>
                                    <span class="quantity">1</span>
                                    <div class="mess-dropdown js-dropdown">
                                        <div class="mess__title">
                                            <p>Bạn có 2 tin nhắn</p>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">
                                                <img src="${pageContext.request.contextPath}/assets/images/thanh_phat_avt.png" alt="Thanh Phát"/>
                                            </div>
                                            <div class="content">
                                                <h6>Thanh Phát</h6>
                                                <p>Đã gửi một bức ảnh</p>
                                                <span class="time">3 phút trước</span>
                                            </div>
                                        </div>
                                        <div class="mess__item">
                                            <div class="image img-cir img-40">
                                                <img src="${pageContext.request.contextPath}/assets/images/thanh_phat_avt.png" alt="Thanh Phát"/>
                                            </div>
                                            <div class="content">
                                                <h6>Thanh Phát</h6>
                                                <p>bây giờ bạn đã kết nối qua tin nhắn</p>
                                                <span class="time">Hôm qua</span>
                                            </div>
                                        </div>
                                        <div class="mess__footer">
                                            <a href="#">Xem tất cả tin nhắn</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="noti__item js-item-menu">
                                    <i class="zmdi zmdi-email"></i>
                                    <span class="quantity">1</span>
                                    <div class="email-dropdown js-dropdown">
                                        <div class="email__title">
                                            <p>Bạn có 3 email mới</p>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="${pageContext.request.contextPath}/assets/images/thanh_phat_avt.png" alt="Thanh Phát"/>
                                            </div>
                                            <div class="content">
                                                <p>Cuộc họp về bảng điều khiển mới...</p>
                                                <span>Thanh Phát, 3 phút trước</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="${pageContext.request.contextPath}/assets/images/thanh_phat_avt.png" alt="Thanh Phát"/>
                                            </div>
                                            <div class="content">
                                                <p>Cuộc họp về Database...</p>
                                                <span>Thanh Phát, Hôm qua</span>
                                            </div>
                                        </div>
                                        <div class="email__item">
                                            <div class="image img-cir img-40">
                                                <img src="${pageContext.request.contextPath}/assets/images/thanh_phat_avt.png" alt="Thanh Phát"/>
                                            </div>
                                            <div class="content">
                                                <p>Cuộc họp về Database...</p><p>Meeting about new dashboard...</p>
                                                <span>Thanh phát, 22-1-2024</span>
                                            </div>
                                        </div>
                                        <div class="email__footer">
                                            <a href="#">Xem tất cả email</a>
                                        </div>
                                    </div>
                                </div>
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
                                        <div class="notifi__item">
                                            <div class="bg-c2 img-cir img-40">
                                                <i class="zmdi zmdi-account-box"></i>
                                            </div>
                                            <div class="content">
                                                <p>Bạn có 1 email mới</p>
                                                <span class="date">22-01-2024, 09:30</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c3 img-cir img-40">
                                                <i class="zmdi zmdi-file-text"></i>
                                            </div>
                                            <div class="content">
                                                <p>Bạn có một tập tin mới</p>
                                                <span class="date">22-01-2024, 11:01</span>
                                            </div>
                                        </div>
                                        <div class="notifi__footer">
                                            <a href="#">Tất cả thông báo</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="${pageContext.request.contextPath}/assets/images/thanh_quyen_avt.png" alt="Thanh Quyen"/>
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">Thanh Quyen</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="${pageContext.request.contextPath}/assets/images/thanh_quyen_avt.png" alt="Thanh Quyen"/>
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
                                            <a href="logout">
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
            <div>
                <div class="card">
                    <div class="card-body">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm phim mới</h4>
                                <button type="button" class="close" data-dismiss="modal"></button>
                            </div>

                            <!-- Modal Body -->
                            <div class="modal-body">
                                <!-- Đặt nội dung form ở đây -->
                                <form action="quanliphim/addMovie" method="post">
                                    <div class="form-group">
                                        <label>Tên </label>
                                        <input type="text" class="form-control" name="movieName" placeholder="Tên phim">
                                    </div>
                                    <div class="form-group">
                                        <label>Thể loại</label>
                                        <input type="text" class="form-control" name="movieCategory"
                                               placeholder="Thể loại">
                                    </div>
                                    <div class="form-group">
                                        <label>Ngày phát hành</label>
                                        <input type="text" class="form-control" name="releaseDate"
                                               placeholder="yyyy-MM-dd">
                                    </div>
                                    <div class="form-group">
                                        <label>Tác giả</label>
                                        <input type="text" class="form-control" name="director" placeholder="Đạo diễn">
                                    </div>
                                    <div class="form-group">
                                        <label>Thời gian</label>
                                        <input type="text" class="form-control" name="duration"
                                               placeholder="Thời gian: hh/mm/ss">
                                    </div>
                                    <div class="form-group">
                                        <label>Quốc gia</label>
                                        <input type="text" class="form-control" name="country" placeholder="Quốc gia">
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả</label>
                                        <div>
                                            <textarea class="form-control" name="movieDescription"
                                                      placeholder="Mô tả"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Nội dung</label>
                                        <div>
                                            <textarea class="form-control" name="movieContent"
                                                      placeholder="nội dung"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Trạng thái</label>
                                        <div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="isPublished"
                                                       value="1"
                                                       id="flexRadioDefault1">
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Đã chiếu
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="isPublished"
                                                       value="0"
                                                       id="flexRadioDefault2">
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Chưa chiế<u></u>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Đánh giá</label>
                                        <input type="text" class="form-control" name="movieScore"
                                               placeholder="Đánh giá: điểm">
                                    </div>
                                    <select class="form-control" name="priceID">
                                        <label>Chọn giá</label>
                                        <c:forEach var="p" items="${priceList}">
                                            <option value="${p.priceID}" ${movie.getMoviePrice().getPriceID() == p.priceID ? "selected" : ""}>
                                                    ${p.price} VNĐ
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <div class="form-group">
                                        <label>Link trailer</label>
                                        <input type="text" class="form-control" name="movieMediaLink.linkMovieTrailer"
                                               placeholder="Link trailer">
                                    </div>
                                    <div class="form-group">
                                        <label>Link ảnh</label>
                                        <input type="text" class="form-control" name="movieMediaLink.linkMovieImage"
                                               placeholder="Link ảnh">
                                    </div>
                                    <div class="modal-footer">
                                        <a href="quanliphim">
                                            <button type="button" class="btn btn-secondary">Đóng</button>
                                        </a>
                                        <button type="submit" class="btn btn-primary">add</button>
                                    </div>

                                </form>
                            </div>

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
