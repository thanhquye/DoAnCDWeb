<%--
  Created by IntelliJ IDEA.
  User: rrioz
  Date: 12/6/2023
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Xác thực tài khoản</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/assets/images/x-icon.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/contact.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/assets/fonts/fontawesome-free-6.5.1/css/all.min.css">
    <link href="//fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;1,600&display=swap"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css"
          integrity="sha512-sMXtMNL1zRzolHYKEujM2AqCLUR9F2C4/05cdbxjjLSRvMQIciEPCQZo++nk7go3BtSuK9kfa/s+a4f4i5pLkw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
          integrity="sha512-tS3S5qG0BlhnQROyJXvNjeEM4UpMXHrQfTGmbQ1gKmelCxlSEBUaxhRBj/EFTzpbP4RVSrpEikbmdJobCvhE3g=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css_made/gmailVerify.css">

</head>
<body>
<%-- Header --%>
<%--<jsp:include page="layout-view/header.jsp"></jsp:include>--%>

<%-- Breadcrumbs --%>
<div class="w3l-breadcrumbs">
    <nav id="breadcrumbs" class="breadcrumbs">
        <div class="container page-wrapper">
            <a href="index.jsp">Home</a> » <span class="breadcrumb_last" aria-current="page">Xác Thực Gmail</span>
        </div>
    </nav>
</div>

<%-- Gmail verify section start --%>
<section class="ftco-section contact-section" style="padding-bottom: 20px">
    <div class="gmail-verify-wrapper">
        <div class="container">
            <div class="row d-flex mb-5 contact-info">
                <div class="container">

                    <% if ("invalid_code".equals(request.getParameter("status"))) { %>
                    <div class="alert alert-danger">Mã xác minh không hợp lệ hoặc đã hết hạn.</div>
                    <% } %>

                    <h2>
                        Tài khoản <span class="email">${user.userName}</span> với Gmail là
                        <span class="email">${user.email}</span> chưa được xác minh
                    </h2>
                    <p style="font-size: 20px">Vui lòng bấm nút "Gửi mã xác minh" và kiểm tra gmail của bạn để xác minh
                        tài khoản.</p>

                    <button id="btnResendCode" style="margin-top: 20px"
                            class="btn btn-success" disabled>
                        Gửi mã xác minh
                    </button>

                    <%-- Đếm ngược --%>
                    <div id="countdown"
                         style="margin-top: 10px; font-size: 13px; color: orange; font-weight: bold;"></div>
                </div>
            </div>
        </div>
    </div>
</section>
<%-- Gmail verify section end --%>

<script src="${pageContext.request.contextPath}/static/assets/js/gmailVerify.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%-- Footer --%>
<%--<jsp:include page="layout-view/footer.jsp"></jsp:include>--%>

<%-- Scripts --%>
<script src="${pageContext.request.contextPath}/static/assets/js/main.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/contact.js"></script>
<script src="${pageContext.request.contextPath}/static/assets/js/theme-change.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
        integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
        integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>