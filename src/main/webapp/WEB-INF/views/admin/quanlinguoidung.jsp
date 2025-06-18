<%@page import="java.util.List" %>
<%@ page import="com.example.Movie_Ticket_Website.model.UserLogin" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%--    <jsp:useBean id="user" class="model.User" scope="request"/>--%>
    <%--    <jsp:useBean id="userDAO" class="database.UserDAO" scope="request"/>--%>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- Title Page-->
    <title>ADMIN HOME</title>

    <!-- Fontfaces CSS-->
    <link href="${pageContext.request.contextPath}/admin/css/font-face.css" rel="stylesheet" media="all">
    <%--    <link href="admin/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">--%>
    <%--    <link href="admin/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">--%>
    <link href="${pageContext.request.contextPath}/admin/vendor/mdi-font/css/material-design-iconic-font.min.css"
          rel="stylesheet" media="all">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

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
    <%--    <script>--%>
    <%--        <% User user = (User) session.getAttribute("admin") == null ? null : (User) (session.getAttribute("admin"));  %>--%>
    <%--    </script>--%>

</head>

<body class="animsition">

<div class="page-wrapper">

    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a href="${pageContext.request.contextPath}/admin/home">
                        <img src="${pageContext.request.contextPath}/assets/images/icon_banner.jpg" alt="PZO TICKET"
                             title="PZO TICKET"
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
                        <a class="js-arrow" href="${pageContext.request.contextPath}/admin/userManagement">
                            <i class="fas fa-tachometer-alt"></i>Quản Lí Người Dùng</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/moviesManagement">
                            <i class="fas fa-chart-bar"></i>Quản Lí Phim
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/ticketManagement">
                            <i class="fas fa-table"></i>Quản Lí vé
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/commentManagement">
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
            <a href="${pageContext.request.contextPath}/admin/home">
                <img src="${pageContext.request.contextPath}/assets/images/icon_banner.jpg" alt="PZO TICKET"
                     title="PZO TICKET" style="height:35px;"/>
                PZO TICKET
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li>
                        <a class="js-arrow" href="${pageContext.request.contextPath}/admin/userManagement">
                            <i class="fas fa-tachometer-alt"></i>Quản Lí Người Dùng</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/moviesManagement">
                            <i class="fas fa-chart-bar"></i>Quản Lí Phim
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/ticketManagement">
                            <i class="fas fa-table"></i>Quản Lí vé
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/commentManagement">
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
                                                <img src="${pageContext.request.contextPath}/assets/images/thanh_phat_avt.png"
                                                     alt="Thanh Phát"/>
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
            <div>
                <div class="card">
                    <div class="card-body">

                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                            <tr>
                                <th class="align-middle">Id người dùng</th>
                                <th class="align-middle">Tên người dùng</th>
                                <th class="align-middle">Email người dùng</th>
                                <th class="align-middle">Trạng thái hoạt động</th>
                                <th class="align-middle">Chặn</th>
                                <th class="align-middle">Xóa</th>
                            </tr>
                            </thead>
                            <tbody class="align-middle" id="renderdata-user">
                            <%
                                boolean showAll = (boolean) request.getAttribute("showAll");
                                System.out.println(showAll);
                                if (showAll) {
                                    List<UserLogin> users = (List<UserLogin>) request.getAttribute("userList");
                                    for (UserLogin user : users) {
                                        int i = 1;
                                        i += i;
                            %>
                            <tr>
                                <td class="align-middle"><%=user.getUserId()%>
                                </td>

                                <td class="align-middle"><%=user.getUserName()%>
                                </td>

                                <td class="align-middle"><%=user.getEmail()%>
                                </td>

                                <td class="align-middle">
                                    <button class="btn btn-sm btn-primary"><%=user.isActive() ? "Đang hoạt động" : "Bị chặn"%>
                                    </button>
                                </td>

                                <td class="align-middle">
                                    <button id="btnBlock" data-id="<%=user.getUserId()%>" class="btn btn-sm btn-primary"
                                            data-toggle="modal" data-target="#blockUser"
                                            title=<%= user.isActive() ? "Chặn" : "Mở chặn" %>><i
                                            class="fa-solid fa-ban"></i></button>
                                </td>

                                <td class="align-middle">
                                    <button data-id="<%=user.getUserId()%>" class="btn btn-sm btn-primary"
                                            data-toggle="modal" data-target="#deleteUser" title="Xóa"><i
                                            class="fa fa-times"></i></button>
                                </td>

                            </tr>
                            <%}%>
                            <%
                            } else {
                                List<UserLogin> listUserSearch = (List<UserLogin>) request.getAttribute("userListS");
                                for (UserLogin user : listUserSearch) {
                            %>
                            <tr>
                                <td class="align-middle"><%=user.getUserName()%>
                                </td>

                                <td class="align-middle"><%=user.getEmail()%>
                                </td>

                                <td class="align-middle">
                                    <button class="btn btn-sm btn-primary"><%=user.isActive() ? "Đang hoạt động" : "Bị chặn"%>
                                    </button>
                                </td>

                                <td class="align-middle">
                                    <button id="btnBlock1" data-id="<%=user.getUserId()%>"
                                            class="btn btn-sm btn-primary"
                                            data-toggle="modal" data-target="#blockUser"
                                            title=<%= user.isActive() ? "Chặn" : "Mở chặn" %>><i
                                            class="fa-solid fa-ban"></i></button>
                                </td>

                                <td class="align-middle">
                                    <button data-id="<%=user.getUserId()%>" class="btn btn-sm btn-primary"
                                            data-toggle="modal" data-target="#deleteUser" title="Xóa"><i
                                            class="fa fa-times"></i></button>
                                </td>
                            </tr>

                            <%}%>
                            <%}%>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!-- END MAIN CONTENT-->

        <!-- END PAGE CONTAINER-->
    </div>

</div>


<%--<script>--%>
<%--    // Xóa người dùng--%>
<%--    $(document).on('click', '.btn-delete-user', function () {--%>
<%--        const userId = $(this).data('id');--%>
<%--        $.ajax({--%>
<%--            url: '/admin/userManagement?userID=' + userId,--%>
<%--            type: 'DELETE',--%>
<%--            success: function (res) {--%>
<%--                console.log("Xóa thành công:", res);--%>
<%--                swal("Thành công!", res.message, "success").then(() => {--%>
<%--                    location.reload();--%>
<%--                });--%>
<%--            },--%>
<%--            error: function (xhr) {--%>
<%--                console.error("Lỗi xóa:", xhr);--%>
<%--                swal("Lỗi!", "Không thể xóa người dùng.", "error");--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>

<%--    // Chặn / Mở chặn--%>
<%--    $(document).on('click', '.btn-block-user', function () {--%>
<%--        const userId = $(this).data('id');--%>
<%--        $.ajax({--%>
<%--            url: '/admin/userManagement?userID=' + userId,--%>
<%--            type: 'PUT',--%>
<%--            success: function (res) {--%>
<%--                console.log("Toggle trạng thái:", res);--%>
<%--                swal("Thành công!", res.message, "success").then(() => {--%>
<%--                    location.reload();--%>
<%--                });--%>
<%--            },--%>
<%--            error: function (xhr) {--%>
<%--                console.error("Lỗi toggle:", xhr);--%>
<%--                swal("Lỗi!", "Không thể thay đổi trạng thái.", "error");--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<!-- Modal xác nhận xóa người dùng -->
<div class="modal fade" id="deleteUser" tabindex="-1" role="dialog" aria-labelledby="deleteUserLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteUserLabel">Xác nhận xóa người dùng</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn xóa người dùng này không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="button" id="confirmDeleteUser" data-id="" class="btn btn-danger">Xác nhận</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal xác nhận chặn/mở chặn người dùng -->
<div class="modal fade" id="blockUser" tabindex="-1" role="dialog" aria-labelledby="blockUserLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="blockUserLabel">Xác nhận thay đổi trạng thái</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Bạn có chắc chắn muốn thay đổi trạng thái của người dùng này không?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="button" id="confirmToggleUser" data-id="" class="btn btn-primary">Xác nhận</button>
            </div>
        </div>
    </div>
</div>


<script>
    $(document).ready(function () {
        // Khi click nút xóa, mở modal và lưu lại userId
        $("#renderdata-user").on("click", "button[data-target='#deleteUser']", function () {
            var userId = $(this).data("id");
            $("#confirmDeleteUser").data("id", userId);
        });

        // Khi xác nhận xóa trong modal
        $("#confirmDeleteUser").on("click", function () {
            var userId = $(this).data("id");
            $.ajax({
                url: "/admin/userManagement",
                type: "DELETE",
                data: {userID: userId},
                success: function (response) {
                    if (response.status === 200) {
                        alert(response.message);
                        // Xóa dòng tương ứng trên bảng sau khi thành công, hoặc reload lại trang:
                        $("button[data-id='" + userId + "'][data-target='#deleteUser']").closest("tr").remove();
                    } else {
                        alert(response.message);
                    }
                    $("#deleteUser").modal("hide");
                },
                error: function () {
                    alert("Đã xảy ra lỗi khi xóa người dùng.");
                    $("#deleteUser").modal("hide");
                }
            });
        });

        // Khi click nút chặn/mở chặn, mở modal và lưu lại userId
        $("#renderdata-user").on("click", "button[data-target='#blockUser']", function () {
            var userId = $(this).data("id");
            $("#confirmToggleUser").data("id", userId);
        });

        // Khi xác nhận chặn/mở chặn trong modal
        $("#confirmToggleUser").on("click", function () {
            var userId = $(this).data("id");
            $.ajax({
                url: "/admin/userManagement",
                type: "PUT",
                data: {userID: userId},
                success: function (response) {
                    alert(response.message);
                    // Cập nhật lại trạng thái người dùng trong bảng (hoặc reload trang nếu cần)
                    location.reload();
                    $("#blockUser").modal("hide");
                },
                error: function () {
                    alert("Đã xảy ra lỗi khi thay đổi trạng thái người dùng.");
                    $("#blockUser").modal("hide");
                }
            });
        });
    });
</script>

<script src="${pageContext.request.contextPath}/admin/js/Dialog.js"></script>

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
