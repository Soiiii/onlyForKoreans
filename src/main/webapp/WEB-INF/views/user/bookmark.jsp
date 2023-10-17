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
        <li><a href="/user/myPage">내가 작성한 글</a></li>
        <li class="active"><a href="/user/bookmark">BOOKMARK</a></li>
      </ul>
      <br>
      <h4>MY PAGE</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="/user/updateUser">회원정보 수정</a></li>
      </ul><br>

    </div>

    <div class="col-sm-9">
      <h4><small>BOOKMARK</small></h4>
      <hr>
    </div>

<div id="new-board-list-container">
  <c:forEach items="${bookmark}" var="bookmarkList" varStatus="status">
    <c:if test="${status.index % 2 == 0}">
        <div class="row">
    </c:if>
    <a href=/board/${bookmarkList.id}>
        <div class="col-sm-4">
            <div class="well">
              <div class="title">
               <h7>제목 : ${bookmarkList.title}</h7>
              </div>
              <div class="country">
               <p>${bookmarkList.country.name}</p>
              </div>
              <div class="content">
               <p>${bookmarkList.content}</p>
              </div>
              <div class="date">
               <p>${bookmarkList.create_at}</p>
            </div>
        </div>
      </div>
    </a>
    <c:if test="${status.index % 2 != 0 || status.last}">
    </c:if>
  </c:forEach>

</div>
</div>

<%@ include file="../layout/footer.jsp"%>

</body>
</html>
