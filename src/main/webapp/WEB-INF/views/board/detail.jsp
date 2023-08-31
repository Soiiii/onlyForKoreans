<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate value="${board.create_at}" pattern="yyyy-MM-dd HH:mm" var="formattedDate" />

<%@ include file="../layout/header.jsp"%>
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
        <div class="col-sm-3 sidebar">
          <h4>나라 별 게시판</h4>
             <ul class="nav nav-pills nav-stacked">
              <li>
                 <a href="/board" class="list-button" data-country="" >
                    <button type="button buttonSide" class="btn">
                       전체
                    </button>
                 </a>
                <c:forEach items="${country}" var="countryName">
                    <a href="#" class="list-button" data-country="${countryName.id}">
                      <button type="button" class="btn">
                        ${countryName.name}
                      </button>
                   </a>
               </c:forEach>
              </li>
          </ul>
          <br>
        </div>

<!--
    <div id="new-board-list-container">
        <c:forEach var="object" items="${boardsList}" varStatus="status">
            <c:if test="${status.index % 2 == 0}">
                <div class="row">
            </c:if>
            <div class="col-sm-6">
                <a href='/board/${object.id}'>
                    <div class="well">
                        <div class="title">
                            <h5>${object.title}</h5>
                        </div>
                        <div class="country">
                            <p>${object.country.name}</p>
                        </div>
                        <div class="view">
                            <p>view: ${object.count}</p>
                        </div>
                        <div class="comment">
                            <p>comment: 3</p>
                        </div>
                        <div class="bookmark">
                            <p>bookmark: 3</p>
                        </div>
                        <div class="date">
                        <p>
                            <fmt:formatDate value="${object.create_at}" pattern="yyyy-MM-dd HH:mm" />
                        </p>
                        </div>
                    </div>
                </a>
            </div>
            <c:if test="${status.index % 2 != 0 || status.last}">
                </div>
            </c:if>
        </c:forEach>
    </div>
-->

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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        $(document).ready(function() {
            function fetchFilteredData(country) {
                $.ajax({
                    url: "/category",
                    data: {country: country },
                    success: function(data) {
                        var extractedData = $(data).find("#new-board-list-container").html();
                        $("#new-board-list-container").html(extractedData);
                    }
                });
            }

            // Click event handler for filter buttons
            $(".list-button").click(function() {
                var country = $(this).data("country");
                fetchFilteredData(country);
            });
        });
    </script>

</html>




<script src="/js/board.js"></script>
