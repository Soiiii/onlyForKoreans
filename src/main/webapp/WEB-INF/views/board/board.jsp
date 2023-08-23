<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/boardSidebar.jsp"%>

    <div class="col-sm-7">
              <div class="row">
                <div class="col-sm-12">
                  <div class="panel panel-default text-left">
                    <div class="panel-body">
                      <p contenteditable="true"> Category</p>
                        <a href="/board/${categoryId}">
                        <c:forEach items="${category}" var="categoryName">
                          <button type="button" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-thumbs-up"></span> ${categoryName.name}
                          </button>
                       </c:forEach>
                       </a>
                       <a th:href="@{/category?category=이야기}">이야기</a>
                    </div>
                  </div>
                </div>
              </div>


    <c:forEach var="board" items="${board}" varStatus="status">
        <c:if test="${status.index % 2 == 0}">
            <div class="row">
        </c:if>
        <div class="col-sm-6">
            <a href="/board/${board.id}">
                <div class="well">
                    <div class="title">
                        <h5>${board.title}</h5>
                    </div>
                    <div class="country">
                        <p>${board.country.name}</p>
                    </div>
                    <div class="view">
                        <p>view: ${board.count}</p>
                    </div>
                    <div class="comment">
                        <p>comment: 3</p>
                    </div>
                    <div class="bookmark">
                        <p>bookmark: 3</p>
                    </div>
                    <div class="date">
        <p><fmt:formatDate value="${board.create_at}" pattern="yyyy-MM-dd HH:mm" /></p>
                    </div>
                </div>
            </a>
        </div>
        <c:if test="${status.index % 2 != 0 || status.last}">
            </div>
        </c:if>
    </c:forEach>

</div>

   </div>
<%@ include file="../layout/footer.jsp"%>

</html>