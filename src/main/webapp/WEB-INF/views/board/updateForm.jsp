<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/boardSidebar.jsp"%>

<body>

    <div class="container-fluid">
      <div class="row content">
        <div class="col-sm-3 sidebar">
          <h4>나라 별 게시판</h4>
             <ul class="nav nav-pills nav-stacked">
              <li>
                  <a href="#" class="list-button" data-country="" data-category="">
                    <button type="button buttonSide" class="btn">
                       전체
                    </button>
                 </a>
                <c:forEach items="${country}" var="countryName">
                    <a href="#" class="list-button" data-country="${countryName.id}" data-category="${categoryName.id}" >
                      <button type="button" class="btn">
                        ${countryName.name}
                      </button>
                   </a>
               </c:forEach>
              </li>
          </ul>
          <br>
        </div>

        <div class="container-fluid">
  <div class="row content">
      <div class="col-sm-9">
        <h4> <small>POSTS</small> </h4>
      <hr>
      <button class="btn btn-secondary" onclick="history.back()"> 돌아가기 </button>
      <br>
      <br>
      <h5><a href=/board/${board.country.name}> ${board.country.name} </a> </h5>
      <h5>
            <span class="glyphicon glyphicon-time"> </span>
            Post by ${board.user.username} , ${formattedDate}
      </h5>

    <form>
        <input type="hidden" id="id" value="${board.id}"/>
              <div class="form-group">
                <textarea class="form-control summernote" rows="5" id="title">${board.title}</textarea>

                <input type="${board.title}" class="form-control" id="title">${board.title}</input>
              </div>
              <div class="form-group">
                <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
              </div>
    </form>
        <button id="btn-update" class="btn btn-primary">수정 완료</button>
          </div>
  </div>
</div>
<%@ include file="../layout/footer.jsp" %>

</body>

<script src="/js/board.js"></script>





