<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>
<style>
  .container {
    padding: 80px 120px;
  }
</style>

  <div class="input-group">
    <input type="text" class="form-control" placeholder="Search Blog..">
    <span class="input-group-btn">
      <button class="btn btn-default" type="button">
        <span class="glyphicon glyphicon-search"></span>
      </button>
    </span>
  </div>

<div id="band" class="container">
  <div class="row">
        <h3> MOST POPULAR </h3>
        <hr>
        <c:forEach var="board" items="${boards}">
            <div>
                <a href="/board/${board.id}" class="">
          <div>
              <span class="label label-success">${board.category.name}</span>
              ${board.title}
              <div class="text-right">
                <i class="bi bi-bookmark-heart-fill" style="color: green; border:none; background-color:white;"></i> Bookmark 3
                <i class="bi bi-chat-right-dots"></i> Comment 3
              </div>
          </div>
                </a>
            </div>
        </c:forEach>
  </div>
  <br>
  <br>

    <div class="row">
      <div class="col-sm-6">
        <h3><i class="bi bi-chat-quote"></i> Daily Story</h3>
        <hr>
        <p>제목1 <i class="bi bi-eye" style="float:right;"> view 3</i></p>
      </div>

      <div class="col-sm-6">
        <h3><i class="bi bi-heart"></i></i> Relationship / Marriage</h3>
        <hr>
        <p>제목1 <i class="bi bi-eye" style="float:right;"> view 3</i></p>
      </div>
    </div>
  <br>
  <br>
  <div class="row">
    <div class="col-sm-6">
      <h3><i class="bi bi-person-workspace"></i> Work</h3>
      <hr>
        <p>제목1 <i class="bi bi-eye" style="float:right;"> view 3</i></p>
    </div>
    <div class="col-sm-6">
      <h3><i class="bi bi-currency-exchange"></i> Investment</h3>
      <hr>
        <p>제목1 <i class="bi bi-eye" style="float:right;"> view 3</i></p>
    </div>
  </div>
</div>


<%--
<c:forEach var="board" items="${boards.content}">
<div class="card m-2">
    <div class="card-body">
        <h4 class="card-title">${board.title}</h4>
        <h3> aaa</h3>
            <a href="/board/${board.id}" class="btn btn-primary"> details</a>
    </div>
</div>
</c:forEach>


<ul class="pagination justify-content-center">
    <c:choose>
        <c:when test="{boards.first}">
            <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="{boards.last}">
            <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
        </c:otherwise>
    </c:choose>
    --%>
</ul>
