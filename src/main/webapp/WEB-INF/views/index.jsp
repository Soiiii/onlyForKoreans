<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>

  <div class="input-group">
    <input type="text" class="form-control" placeholder="Search Blog..">
    <span class="input-group-btn">
      <button class="btn btn-default" type="button">
        <span class="glyphicon glyphicon-search"></span>
      </button>
    </span>
  </div>

  <div class="row">
    <div class="col-sm-5">
        <h3> MOST POPULAR </h3>
        <hr>
        <c:forEach var="board" items="${boards}">
            <div>
                <a href="/board/${board.id}" class="">
                    <p>[${board.category.name}] ${board.title} view ${board.count} comment 3</p>
                </a>
            </div>
        </c:forEach>
    </div>
  </div>
  <br>
  <br>

  <div class="row">
    <div class="col-sm-5 ">
      <p>이야기</p>
      <hr>
      <p>제목1 view 3</p>
      <p>제목2 view 3</p>
      <p>제목3 view 3</p>
      <p>제목4 view 3</p>
    </div>
    <div class="col-sm-5">
      <p>연애/결혼</p>
      <hr>
      <p>제목1 view 3</p>
      <p>제목2 view 3</p>
      <p>제목3 view 3</p>
      <p>제목4 view 3</p>
    </div>
  </div>
  <br>
  <div class="row">
    <div class="col-sm-5">
      <p>회사</p>
      <hr>
      <p>제목1 view 3</p>
      <p>제목2 view 3</p>
      <p>제목3 view 3</p>
      <p>제목4 view 3</p>
    </div>
    <div class="col-sm-5">
      <p>투자</p>
      <hr>
      <p>제목1 view 3</p>
      <p>제목2 view 3</p>
      <p>제목3 view 3</p>
      <p>제목4 view 3</p>
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
