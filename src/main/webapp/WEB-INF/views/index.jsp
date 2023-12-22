<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>
<style>
  .container {
    padding: 80px 120px;
  }
</style>

<!--
    <div class="input-group">
    <input type="text" class="form-control" placeholder="Search Blog..">
    <span class="input-group-btn">
      <button class="btn btn-default" type="button">
        <span class="glyphicon glyphicon-search"></span>
      </button>
    </span>
  </div>
  -->

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
    <c:set var="dailyStoryDisplayed" value="false" />
    <c:set var="relationshipMarriageDisplayed" value="false" />
    <c:set var="workDisplayed" value="false" />
    <c:set var="investmentDisplayed" value="false" />

    <c:forEach var="board" items="${boards}">
        <c:choose>
            <c:when test="${board.category.id eq 1 and dailyStoryDisplayed eq 'false'}">
                <c:set var="dailyStoryDisplayed" value="true" />
                <div class="col-sm-6">
                    <h3><i class="bi bi-chat-quote"></i> Daily Story </h3>
                    <hr>
                    <c:forEach var="dailyBoard" items="${boards}" varStatus="loop">
                        <c:if test="${dailyBoard.category.id eq 1}">
                            <a href="/board/${dailyBoard.id}" class="">
                                <p>${dailyBoard.title} <i class="bi bi-eye" style="float:right;"> ${dailyBoard.count}</i></p>
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </c:when>
            <c:when test="${board.category.id eq 2 and relationshipMarriageDisplayed eq 'false'}">
                <c:set var="relationshipMarriageDisplayed" value="true" />
                <div class="col-sm-6">
                    <h3><i class="bi bi-heart"></i> Relationship / Marriage </h3>
                    <hr>
                    <c:forEach var="relationshipMarriage" items="${boards}" varStatus="loop">
                        <c:if test="${relationshipMarriage.category.id eq 2}">
                            <a href="/board/${relationshipMarriage.id}" class="">
                                <p>${relationshipMarriage.title} <i class="bi bi-eye" style="float:right;"> ${relationshipMarriage.count}</i></p>
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </c:when>
            <c:when test="${board.category.id eq 8 and workDisplayed eq 'false'}">
                <c:set var="workDisplayed" value="true" />
                <div class="col-sm-6">
                    <h3><i class="bi bi-person-workspace"></i> Work </h3>
                    <hr>
                    <c:forEach var="work" items="${boards}" varStatus="loop">
                        <c:if test="${work.category.id eq 8}">
                            <a href="/board/${work.id}" class="">
                                <p>${work.title} <i class="bi bi-eye" style="float:right;"> ${work.count}</i></p>
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </c:when>
            <c:when test="${board.category.id eq 3 and investmentDisplayed eq 'false'}">
                <c:set var="investmentDisplayed" value="true" />
                <div class="col-sm-6">
                   <h3><i class="bi bi-currency-exchange"></i> Investment</h3>
                    <hr>
                    <c:forEach var="investment" items="${boards}" varStatus="loop">
                        <c:if test="${investment.category.id eq 3}">
                            <a href="/board/${investment.id}" class="">
                                <p>${investment.title} <i class="bi bi-eye" style="float:right;"> ${investment.count}</i></p>
                            </a>
                        </c:if>
                    </c:forEach>
                </div>
            </c:when>

        </c:choose>
    </c:forEach>
</div>
<br>
<br>


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
</ul>
    --%>
