<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${board.create_at}" pattern="yyyy-MM-dd HH:mm" var="formattedDate" />

<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/boardSidebar.jsp"%>
  <style>
    .row.content {height: 1500px}
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
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

    <div class="col-sm-9">
      <h4> <small>POSTS</small> </h4>
      <hr>
      <button class="btn btn-secondary" onclick="history.back()"> 돌아가기 </button>
      <input type="hidden" id="id" value="${board.id}"/>
      <c:if test="${board.user.id == principal.user.id}">
          <a href="/board/${board.id}/updateForm" class="btn btn-primary"> 수정 </button></a>
          <button id="btn-delete" class="btn btn-primary"> 삭제 </button>
      </c:if>
      <br>
      <br>
                <button id="btn-update" class="btn btn-primary">수정 완료</button>

      <h5><a href=/board/${board.country.name}> ${board.country.name} </a> </h5>
      <h2> ${board.title} </h2>
      <h5>
            <span class="glyphicon glyphicon-time"> </span>
            Post by ${board.user.username} , ${formattedDate}
      </h5>
      <h5>
            <span class="label label-success"> ${board.category.name} </span>
      </h5>
      <br>
      <p> ${board.content} </p>
      <hr>

      <h4>Leave a Comment:</h4>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>

      <p><span class="badge">2</span> Comments:</p><br>

      <div class="row">
        <div class="col-sm-2 text-center">
        </div>
        <div class="col-sm-10">
          <h4>Anja <small>Sep 29, 2015, 9:12 PM</small></h4>
          <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          <br>
        </div>
        <div class="col-sm-2 text-center">
        </div>
        <div class="col-sm-10">
          <h4>John Row <small>Sep 25, 2015, 8:25 PM</small></h4>
          <p>I am so happy for you man! Finally. I am looking forward to read about your trendy life. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
          <br>
          <p><span class="badge">1</span> Comment:</p><br>
          <div class="row">
            <div class="col-sm-2 text-center">
            </div>
            <div class="col-xs-10">
              <h4>Nested Bro <small>Sep 25, 2015, 8:28 PM</small></h4>
              <p>Me too! WOW!</p>
              <br>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<%@ include file="../layout/footer.jsp"%>

</body>
</html>




<script src="/js/board.js"></script>
