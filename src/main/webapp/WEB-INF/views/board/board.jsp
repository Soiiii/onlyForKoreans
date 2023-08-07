<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/boardSidebar.jsp"%>

    <div class="col-sm-7">


        <c:forEach var="board" items="${board}">
            <div>
                <a href="/board/${board.id}" class="">
                    <p>[${board.category.name}] ${board.title} view ${board.count} </p>
                </a>
            </div>


      <div class="row">
        <div class="col-sm-12">
          <div class="panel panel-default text-left">
            <div class="panel-body">
              <p contenteditable="true"> Category</p>
                <c:forEach items="${category}" var="categoryName">
                  <button type="button" class="btn btn-default btn-sm">
                    <span class="glyphicon glyphicon-thumbs-up"></span> ${categoryName.name}
                  </button>
               </c:forEach>
            </div>
          </div>
        </div>
      </div>

      <div class="row">




        <div class="col-sm-6"><a href="/board/detail">
            <div class="well">
              <div class="title">
               <h7>제목:${board.title}</h7>
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
               <p>Date: 2023/07/02</p>
              </div>
            </div></a>
        </div>
        <div class="col-sm-6">
            <div class="well">
              <div class="title">
               <h7>제목:Hi</h7>
              </div>
              <div class="country">
               <p>베트남</p>
              </div>
              <div class="view">
               <p>view: 3</p>
              </div>
              <div class="comment">
               <p>comment: 3</p>
              </div>
              <div class="bookmark">
               <p>bookmark: 3</p>
              </div>
              <div class="date">
               <p>Date: 2023/07/02</p>
              </div>
            </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6">
            <div class="well">
              <div class="title">
               <h7>제목:Hi</h7>
              </div>
              <div class="country">
               <p>베트남</p>
              </div>
              <div class="view">
               <p>view: 3</p>
              </div>
              <div class="comment">
               <p>comment: 3</p>
              </div>
              <div class="bookmark">
               <p>bookmark: 3</p>
              </div>
              <div class="date">
               <p>Date: 2023/07/02</p>
              </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="well">
              <div class="title">
               <h7>제목:Hi</h7>
              </div>
              <div class="country">
               <p>베트남</p>
              </div>
              <div class="view">
               <p>view: 3</p>
              </div>
              <div class="comment">
               <p>comment: 3</p>
              </div>
              <div class="bookmark">
               <p>bookmark: 3</p>
              </div>
              <div class="date">
               <p>Date: 2023/07/02</p>
              </div>
            </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6">
            <div class="well">
              <div class="title">
               <h7>제목:Hi</h7>
              </div>
              <div class="country">
               <p>베트남</p>
              </div>
              <div class="view">
               <p>view: 3</p>
              </div>
              <div class="comment">
               <p>comment: 3</p>
              </div>
              <div class="bookmark">
               <p>bookmark: 3</p>
              </div>
              <div class="date">
               <p>Date: 2023/07/02</p>
              </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="well">
              <div class="title">
               <h7>제목:Hi</h7>
              </div>
              <div class="country">
               <p>베트남</p>
              </div>
              <div class="view">
               <p>view: 3</p>
              </div>
              <div class="comment">
               <p>comment: 3</p>
              </div>
              <div class="bookmark">
               <p>bookmark: 3</p>
              </div>
              <div class="date">
               <p>Date: 2023/07/02</p>
              </div>
            </div>
        </div>
      </div>
    </div>
            </c:forEach>

   </div>
<%@ include file="../layout/footer.jsp"%>

</html>
