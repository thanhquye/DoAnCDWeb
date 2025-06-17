<%@ page import="java.util.List" %>
<%@ page import="com.example.Movie_Ticket_Website.beans.ShoppingCart" %>
<%@ page import="com.example.Movie_Ticket_Website.beans.CartItem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rrioz
  Date: 1/21/2024
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
    if(shoppingCart == null) {
        shoppingCart = new ShoppingCart();
        List<CartItem> cartItem = shoppingCart.getCartItem();
    }
    List<CartItem> cartItem = shoppingCart.getCartItem();
%>
<html>
<head>
    <title>Giỏ hàng</title>
    <jsp:include page="../views/layout-view/head_libraries.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/shoppingCart.css">
</head>
<body>
    <jsp:include page="../views/layout-view/header.jsp"/>
    <div class="w3l-breadcrumbs" style="padding-top: 70px;padding-bottom: 0px">
        <nav id="breadcrumbs" class="breadcrumbs">
            <div class="container page-wrapper">
                <a href="/">Home</a> » <span class="breadcrumb_last" aria-current="page">Giỏ hàng</span>
            </div>
        </nav>
    </div>
    <div class="container px-3 my-5 clearfix" style="margin-top: 10px !important;">
        <div class="card">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered m-0">
                        <thead>
                            <tr>
                                <th class="text-center py-3 px-4" style="min-width: 400px;">Vé &amp; Thông tin vé đặt</th>
                                <th class="text-right py-3 px-4" style="width: 100px;">Giá vé</th>
                                <th class="text-center py-3 px-4" style="width: 120px;">Số lượng</th>
                                <th class="text-center py-3 px-4" style="width: 120px">Tổng</th>
                                <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="p-4">
                                    <div class="media align-items-center">
                                        <img src="${pageContext.request.contextPath}assets/movie-image/ke-an-hon.png" class="d-block ui-w-40 ui-bordered mr-4" alt="">
                                        <div class="media-body">
                                            <a href="#" class="d-block text-dark">Kẻ ăn hồn</a>
                                            <small>
                                                <span class="text-muted">ngày: </span> 16/6/2025
                                                <span class="text-muted">ghế: </span> a1
                                                <span class="text-muted">thời gian </span> 19:00:00
                                            </small>
                                        </div>
                                    </div>
                                </td>
                                <td class="text-right font-weight-semibold align-middle p-4">50000</td>
                                <td class="align-middle p-4"><input type="text" class="form-control text-center" value="1"></td>
                                <td class="text-right font-weight-semibold align-middle p-4">50000</td>
                                <td class="text-center align-middle px-0"><a href="#" class="shop-tooltip close float-none text-danger" title="" data-original-title="Remove">×</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                    <div class="mt-4">
                        <label class="text-muted font-weight-normal">Mã giảm giá</label>
                        <input type="text" placeholder="Nhập voucher tại đây" class="form-control">
                    </div>
                    <div class="d-flex">
                        <div class="text-right mt-4 mr-5">
                            <label class="text-muted font-weight-normal m-0">Khuyến mãi</label>
                            <div class="text-large"><strong>0</strong></div>
                        </div>
                        <div class="text-right mt-4">
                            <label class="text-muted font-weight-normal m-0">Tổng thanh toán</label>
                            <div class="text-large"><strong>50000</strong></div>
                        </div>
                    </div>
                </div>

                <div class="float-right">
                    <button href="home?action=direct" type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3" >Quay lại</button>
                    <button type="button" class="btn btn-lg btn-primary mt-2">Thanh toán</button>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../views/layout-view/script-libraries.jsp" />
    <jsp:include page="../views/layout-view/js-function-slider.jsp" />
</body>
</html>
<%--<script src="assets/js/jquery-3.7.1.min.js"></script>--%>
<script src="${pageContext.request.contextPath}assets/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}assets/js/easyResponsiveTabs.js"></script>
<!--/theme-change-->
<script src="${pageContext.request.contextPath}assets/js/theme-change.js"></script>
<script src="${pageContext.request.contextPath}assets/js/owl.carousel.js"></script>
<script src="${pageContext.request.contextPath}assets/js/main.js"></script>
