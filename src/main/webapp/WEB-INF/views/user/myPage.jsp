<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

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
      <h4>ACTIVITIES</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="/user/myPage">내가 작성한 글</a></li>
        <li><a href="/user/bookmark">BOOKMARK</a></li>
      </ul><br>
      <h4>MY PAGE</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="/user/updateUser">회원정보 수정</a></li>
      </ul><br>

    </div>


    <div class="col-sm-9">
      <h4><small>내가 작성한 글</small></h4>
      <hr>
          <h2>내가 썼다</h2>
          <h5><span class="glyphicon glyphicon-time"></span> Post by John Doe, Sep 24, 2015.</h5>
    </div>
    <div class="col-sm-9">
      <hr>
          <h2>안뇽</h2>
          <h5><span class="glyphicon glyphicon-time"></span> Post by John Doe, Sep 24, 2015.</h5>
      <hr>
    </div>
  </div>
</div>

<%@ include file="../layout/footer.jsp"%>

</body>
</html>
