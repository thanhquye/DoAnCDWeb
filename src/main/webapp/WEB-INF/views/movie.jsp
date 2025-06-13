<%@ page import="com.example.Movie_Ticket_Website.model.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Movie_Ticket_Website.model.Movie" %>
<%@ page import="com.example.Movie_Ticket_Website.dto.MovieWithMediaDTO" %>
<%@ page import="com.example.Movie_Ticket_Website.model.MovieMediaLink" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách phim mới nhất</title>
    <style>
        .pagination {
            margin-top: 20px;
        }

        .pagination a {
            padding: 5px 10px;
            margin: 0 5px;
            border: 1px solid #ddd;
        }

        .current-page {
            font-weight: bold;
        }
    </style>
</head>
<body>
<%List<MovieWithMediaDTO> movies = (List<MovieWithMediaDTO>) request.getAttribute("movies");%>
<h1>Danh sách phim mới nhất</h1>

<table border="1">
    <thead>
    <tr>
        <th class="align-middle">Tên</th>
        <th class="align-middle">Thể loại</th>
        <th class="align-middle">Ngày phát hành</th>
        <th class="align-middle">Tác giả</th>
        <th class="align-middle">Thời gian</th>
        <th class="align-middle">Quốc gia</th>
        <th class="align-middle">Mô tả</th>
        <th class="align-middle">Mô tả</th>
        <th class="align-middle">Mô tả</th>
        <th class="align-middle">Mô tả</th>
        <th class="align-middle">Mô tả</th>
        <th class="align-middle">Mô tả</th>
        <th class="align-middle">Mô tả</th>
    </tr>
    </thead>
    <tbody>

    <% for (MovieWithMediaDTO movie : movies){%>
    <tr>
        <td class="align-middle"><%=movie.getMovieName()%>
        </td>
        <td class="align-middle"><%=movie.getMovieCategory()%>
        </td>
        <td class="align-middle"><%=movie.getReleaseDate()%>
        </td>
        <td class="align-middle"><%=movie.getDirector()%>
        </td>
        <td class="align-middle"><%=movie.getDuration()%>
        </td>
        <td class="align-middle"><%=movie.getCountry()%>
        </td>
        <td class="align-middle"><%=movie.getMovieContent()%>
        </td>
        <td class="align-middle"><%=movie.getMovieDescription()%>
        </td>
        <td class="align-middle"><%=movie.getIsPublished()%>
        </td>
        <td class="align-middle"><%=movie.getMovieScore()%>
        </td>
        <td class="align-middle"><%=movie.getLinkMovieImage()%>
        </td>
        <td class="align-middle"><%=movie.getLinkMovieTrailer()%>
        </td>

    </tr>
    <%}%>
    </tbody>
</table>



</body>
</html>