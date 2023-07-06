<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/css/bootstrap.min.css"></script> -->

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/"> OnlyForKoreans </a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <c:choose>
            <c:when test="${empty principal}">
              <ul class="nav navbar-nav">
                <li><a href="/notice">공지사항</a></li>
                <li><a href="/board">나라 별 게시판</a></li>
              </ul>

              <ul class="nav navbar-nav navbar-right">
                <li><a href="/auth/joinForm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/auth/loginForm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
              </ul>

            </c:when>

            <c:otherwise>
              <ul class="nav navbar-nav">
                <li><a href="/board/saveForm">글쓰기</a></li>
              </ul>

              <div class="input-group w-25 mb-3">
                <input type="text" class="form-control" placeholder="Search Blog..">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button">
                    <span class="glyphicon glyphicon-search"></span>
                  </button>
                </span>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li><a href="/auth/loginForm"><span class="glyphicon glyphicon-user"></span> My Page</a></li>
                <li><a href=/auth/logout><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
              </ul>

            </c:otherwise>
        </c:choose>

    </div>
  </div>
</nav>