<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${board.create_at}" pattern="yyyy-MM-dd HH:mm" var="formattedDate" />

<%@ include file="../layout/header.jsp"%>

  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {
        height: 1500px
    }

    /* Set gray background color and 100% height */
    .sidebar {
      background-color: #f1f1f1;
      height: 100%;
    }

    /* Set black background color, white text and some padding */
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

    /* 삭제, 수정 버튼 */
    .btn-primary{
        float: right;
    }

  </style>


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
        <div class="col-sm-7">
          <div class="row">
            <div class="col-sm-11">
              <div class="panel panel-default text-left">
                <div class="panel-body">
                  <p contenteditable="true"> Category</p>
                     <a href="#" class="list-button" data-country="" data-category="">
                        <button type="button" class="btn btn-default btn-sm">
                           전체
                        </button>
                     </a>

                    <c:forEach items="${category}" var="categoryName">
                        <a href="#" class="list-button" data-category="${categoryName.id}" data-country="${countryName.id}">
                          <button type="button" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-thumbs-up"></span> ${categoryName.name}
                          </button>
                       </a>
                   </c:forEach>
                </div>
              </div>
            </div>
          </div>

        <div class="col-sm-12">
          <hr>

          <button class="btn btn-secondary" onclick="history.back()"> 돌아가기 </button>
          <input type="hidden" id="board_id" value="${board.id}"/>
          <input type="hidden" id="book_num" value="${board.book_num}"/>
          <input type="hidden" id="user_id" value="${board.user.id}"/>


              <c:if test="${board.user.id == principal.user.id}">
                  <a href="/board/${board.id}/updateForm" class="btn btn-primary"> Update </button></a>
                  <button id="btn-delete" class="btn btn-primary"> Delete </button>
              </c:if>
          <br>
          <br>

          <h5><a href=/board/${board.country.name}> ${board.country.name} </a> </h5>
          <button id="btn-bookmark" type="button" class="heart" style="border:none; background-color:white;">
                      <i class="bi bi-bookmark-heart-fill" style="color: green; border:none; background-color:white;"></i> Bookmark
          </button>

          <h2> ${board.title} </h2>
          <h5>
                <span class="glyphicon glyphicon-time"> </span>
                Post by ${board.user.username} , ${formattedDate}
                <i class="bi bi-bookmark-heart">${board.book_num}</i>

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
              <textarea class="form-control" id="content" rows="3" required></textarea>
            </div>
            <button id="btn-comment" type="button" class="btn btn-success">Submit</button>
          </form>
          <br><br>

          <p><span class="badge">${commentTotal}</span> Comments: </p><br>
            <c:forEach items="${comment}" var="comment">
              <div class="row">
                    <div class="col-sm-10">
                      <h4>${comment.user.username} <small>${comment.create_at}</small></h4>
                      <p>${comment.content}</p>
                      <br>
<%--
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
--%>
                    </div>
                    <div class="col-sm-2 text-center">
                </div>
              </div>
            </c:forEach>
        </div>
      </div>
      </div>
    </div>

<%@ include file="../layout/footer.jsp"%>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        $(document).ready(function() {
            function fetchFilteredData(category, country) {
                $.ajax({
                    url: "/category",
                    data: { category: category, country: country },
                    success: function(data) {
                        var extractedData = $(data).find("#new-board-list-container").html();

                        $(".col-sm-12").html(data);
                        console.log("!!!!" + $(".col-sm-12").html(extractedData));

                    }
                });
            }

            // Click event handler for filter buttons
            $(".list-button").click(function() {
                var category = $(this).data("category");
                var country = $(this).data("country");
                fetchFilteredData(category, country);
            });
        });
    </script>
</html>




<script src="/js/board.js"></script>
