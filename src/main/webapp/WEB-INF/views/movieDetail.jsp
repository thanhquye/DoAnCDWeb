<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Chi Tiết Phim - ${movie.movieName}</title>
    <jsp:include page="../views/layout-view/head_libraries.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css_made/comment_movieDetail.css">
</head>
<body>
<jsp:include page="../views/layout-view/header.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/movie_detail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}assets/css/movieDetail.css">
<%-- BREADCRUMBS --%>
<div class="w3l-breadcrumbs">
    <nav id="breadcrumbs" class="breadcrumbs">
        <div class="container page-wrapper">
            <a href="/">Trang Chủ</a> » <span class="breadcrumb_last" aria-current="page">${movie.movieName}</span>
        </div>
    </nav>
</div>

<%-- Section thể hiện chi tiết phim--%>
<section class="film-detail"
         style="background: url(${pageContext.request.contextPath}/assets/movie-image/${movie.linkMovieImage}) no-repeat center ; background-size: cover; position: relative;overflow: hidden">
    <div class="container" id="film-detailBackground">
        <div class="row">
            <div class="col-4" id="film-detail__poster">
                <img src="${pageContext.request.contextPath}/assets/movie-image/${movie.linkMovieImage}" id="poster"
                     alt="" style="border: 2px groove whitesmoke;">
            </div>
            <div class="col-8" id="film-detail__context" style="; margin: 25px 0px ; padding-left: 0px">
                <div class="film-detail__txt" id="filmCategory-detail">Thể loại : ${movie.movieCategory}</div>
                <div class="film-detail__txt" id="filmName-detail"
                     style="font-style: italic ;font-family: 'SansSerif', sans-serif;"><i
                        class="fa-solid fa-film"></i>${movie.movieName}</div>
                <div class="film-detail__txt" id="filmDes-detail"> ' ${movie.movieDescription} '</div>
                <div class="film-detail__txt" id="filmDirector-detail">Từ đạo diễn ${movie.director}
                    - ${movie.country}</div>
                <div class="film-detail__txt" id="filmDuration-detail">Thời lượng - <i class="fa-solid fa-clock"></i>
                    : ${movie.duration}</div>
                <div class="film-detail__txt" id="filmScore-detail"><i class="fa-solid fa-star"></i> ${movie.movieScore}
                </div>
                <div class="film-detail__txt" id="filmDate-detail">Ngày ra rạp : ${movie.releaseDate}</div>
                <div class="film-detail__txt">Nội dung :</div>
                <div class="film-detail__txt" id="filmDescription-detail">${movie.movieContent}</div>
                <%-- btn để thực hiện đặt vé cho bộ phim đang hiển thị --%>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="button-center text-center mt-4" style="margin-top: 0px">
                            <a href="bookingTicket?action=init&movieID=${movie.movieID}" class="btn watch-button"
                               style="color: white;  font-size: 25px">Đặt vé ngay</a>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="button-center text-center mt-4" style="margin-top: 0px">
                            <a href="#" class="btn watch-button" style="color: white;  font-size: 25px">Thêm vào giỏ</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%--Section hiển thị lịch chiếu phim --%>
<section class="showtimes-section" id="showtimeSection">
    <div class="showtimes-title" style="padding : 20px 0px 30px 0px;"> LỊCH CHIẾU PHIM - ${movie.movieName}</div>
    <div class="border-div-1">
        <div class="container">
            <div class="row">
                <div class="col-5">
                    <%-- thực hiện tìm kiếm tên rạp - ten rap chieu phim can tim den HomeController servlet --%>
                    <form action="movieDetail" method="post">
                        <input type="hidden" name="action" value="cinemaSearch">
                        <input type="hidden" name="cid" value="${cinemaDetail.cinemaID}">
                        <input type="hidden" name="movieID" value="${movie.movieID}">
                        <input class="form-control" type="text" name="cinemaName" placeholder="Nhập tên rạp để tìm kiếm"
                               aria-label="search" value="${txtHistory}">
                    </form>
                    <br>
                    <div id="showtimes-list_cinema" style="padding-bottom: 30px">
                        <%-- hien thi toan bo danh sach cinema, click 1 cinema thuc hien truyen cid toi servlet home --%>
                        <c:if test="${(allCinema != null) && (searchedResultCinemaListSize == 0) }">
                            <c:forEach items="${allCinema}" var="cinema">
                                <div class="row_cinemaName">
                                    <i class="fa-solid fa-film"> </i>
                                    <a href="movieDetail?action=show-cinemaShowtime&cid=${cinema.cinemaID}&movieID=${movie.movieID}"
                                       style="color: whitesmoke">${cinema.cinemaName}</a>
                                </div>
                            </c:forEach>
                        </c:if>
                        <c:if test="${isShowAllCinema}">
                            <c:forEach items="${allCinema}" var="cinema">
                                <div class="row_cinemaName">
                                    <i class="fa-solid fa-film"> </i>
                                    <a href="movieDetail?action=show-cinemaShowtime&cid=${cinema.cinemaID}&movieID=${movie.movieID}"
                                       style="color: whitesmoke">${cinema.cinemaName}</a>
                                </div>
                            </c:forEach>
                        </c:if>
                        <c:if test="${searchedResultCinemaListSize > 0}">
                            <c:forEach items="${searchedResultCinemaList}" var="cinema">
                                <div class="row_cinemaName">
                                    <i class="fa-solid fa-film"> </i>
                                    <a href="movieDetail?action=show-cinemaShowtime&cid=${cinema.cinemaID}&movieID=${movie.movieID}"
                                       style="color: whitesmoke">${cinema.cinemaName}</a>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="col-7">
                    <div id="showtimes-rightBox">
                        <%-- hien thi noi dung cinema lay duoc tu home-servlet --%>
                        <div class="showtimes-cinema_title" id="cinemaTitle">
                            <c:if test="${(cinemaDetail == null) && (searchedResultCinemaListSize == 0)}">
                                <h2 style="font-size: 25px;padding-bottom: 5px"><i class="fa-solid fa-film"> </i> Bạn
                                    chưa chọn rạp phim</h2>
                                <h4 style="font-size: 17px; font-weight: lighter;padding-bottom: 10px"></h4>
                            </c:if>
                            <c:if test="${cinemaDetail != null}">
                                <h2 style="font-size: 25px;padding-bottom: 5px"><i
                                        class="fa-solid fa-film"> </i> ${cinemaDetail.cinemaName}</h2>
                                <h4 style="font-size: 17px; font-weight: lighter;padding-bottom: 10px"> ${cinemaDetail.location}</h4>
                            </c:if>
                        </div>
                        <div class="showtimes-calendar">
                            <div class="showtimes-btn_group">
                                <%-- hien thi 7 ngay tinh tu HOM NAY de dat ve --%>
                                <div class="showtimes-calenderBox" style="text-align: center">
                                    <%--  dùng javaBean để lấy ngày tháng và hiển thị ngày hôm nay--%>
                                    <jsp:useBean id="date" class="com.example.Movie_Ticket_Website.beans.DateBean"
                                                 scope="session"/>
                                    <a class="showtimes-dateItem"
                                       href="movieDetail?action=showShowTime&date=${date.formatDate(date.currentDate)}&cid=${cinemaDetail.cinemaID}&movieID=${movie.movieID}">
                                        <fmt:formatDate value="${date.currentDate}" pattern="dd/MM"/>
                                    </a>
                                    <c:forEach var="i" begin="1" end="6">
                                        <%-- hien thi 6 ngay bat dau tu ngay chieu phim dang duoc chon --%>
                                        <a class="showtimes-dateItem"
                                           href="movieDetail?action=showShowTime&date=${date.formatDate(date.addDate(i))}&cid=${cinemaDetail.cinemaID}&movieID=${movie.movieID}">
                                            <fmt:formatDate value="${date.addDate(i)}" pattern="dd/MM"/>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                            <br>
                            <div class="showtimes-show">
                                <%-- neu user chua chon ten rap phim va thoi gian --%>
                                <c:if test="${movieListForCNameAndShowtime == null}">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title"
                                                style="color: whitesmoke;font-weight: bolder; margin-bottom: 5px; background-color: rgba(121,177,187,0.35); border-radius: 5px">
                                                Chưa có Phim để hiển thị</h5>
                                            <p class="card-text" style="color: whitesmoke;"></p>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${movieListForCNameAndShowtime != null}">
                                    <c:forEach items="${movieListForCNameAndShowtime}" var="m">
                                        <%-- hien thi cac phim trong ngay duoc chon --%>
                                        <div class="card">
                                            <div class="card-body"
                                                 style="background: url(${pageContext.request.contextPath}/assets/movie-image/${m.linkMovieImage}) no-repeat center; background-size: cover;  margin: 5px 0px 0px 0px;border-radius: 5px;">
                                                <h5 class="card-title"
                                                    style="color: whitesmoke;font-weight: bolder; margin-bottom: 5px; background-color: rgba(121,177,187,0.35); border-radius: 5px">${m.movieName}</h5>
                                                <p class="card-text"
                                                   style="color: whitesmoke;">${m.movieDescription}</p>
                                                <a href="bookingTicket?action=init&movieID=${m.movieID}"
                                                   class="btn btn-primary" style="margin-top: 5px">Đặt vé
                                                    ngày ${wantedBookDate}</a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%-- Phần comment người dùng cho từng bộ phim --%>
<div class="comment-section">
    <div class="comment-header">BÌNH LUẬN</div>

    <!-- Form gửi comment mới -->
    <div class="comment-form">
        <form id="commentForm" method="post" action="${pageContext.request.contextPath}/movieDetail/comment">
            <input type="hidden" name="movieID" value="${movie.movieID}"/>
            <textarea name="commentText" placeholder="Viết bình luận của bạn" required></textarea>
            <button type="submit">Gửi</button>
        </form>
    </div>

    <!-- Danh sách comment hiện có -->
    <div class="comment-list">
        <c:choose>
            <c:when test="${not empty comments}">
                <c:forEach var="comment" items="${comments}">
                    <div class="comment-item">
                        <div class="comment-user">${comment.fullName}</div>
                        <div class="comment-content">${comment.commentText}</div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>Chưa có bình luận nào. Hãy là người bình luận đầu tiên!</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<!-- End Comment Section -->

<jsp:include page="../views/layout-view/footer.jsp"/>
<jsp:include page="../views/layout-view/js-function-slider.jsp"/>
<jsp:include page="../views/layout-view/script-libraries.jsp"/>
</body>
</html>
<!-- responsive tabs -->
<script src="${pageContext.request.contextPath}assets/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}assets/js/easyResponsiveTabs.js"></script>
<!--/theme-change-->
<script src="${pageContext.request.contextPath}assets/js/theme-change.js"></script>
<script src="${pageContext.request.contextPath}assets/js/owl.carousel.js"></script>
<script src="${pageContext.request.contextPath}assets/js/main.js"></script>