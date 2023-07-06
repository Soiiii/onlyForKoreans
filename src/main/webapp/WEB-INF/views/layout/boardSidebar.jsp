<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}

    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }

    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }

    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;}
    }
  </style>

<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>나라 별 게시판</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="/board">전체</a></li>
        <li><a href="/board/thailand">태국</a></li>
        <li><a href="/board/vietnam">베트남</a></li>
        <li><a href="/board/singapore">싱가포르</a></li>
        <li><a href="/board/china">중국</a></li>
        <li><a href="/board/japan">일본</a></li>
      </ul><br>
    </div>


</html>