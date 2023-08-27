<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../layout/header.jsp"%>

<!-- <%@ include file="../layout/boardSidebar.jsp"%> -->
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
        <div class="col-sm-3 sidebar">
          <h4>나라 별 게시판</h4>
             <ul class="nav nav-pills nav-stacked">
              <li>
                  <a href="#" class="list-button" data-country="all">
                    <button type="button buttonSide" class="btn">
                       전체
                    </button>
                 </a>
                <c:forEach items="${country}" var="countryName">
                    <a href="#" class="list-button" data-country="${countryName.name}" data-category="${categoryName.name}" >
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
                <div class="col-sm-12">
                  <div class="panel panel-default text-left">
                    <div class="panel-body">
                      <p contenteditable="true"> Category</p>
                        <a href="#" class="category-button-all">
                          <button type="button" class="btn btn-default btn-sm">
                             전체
                          </button>
                       </a>

                        <c:forEach items="${category}" var="categoryName">
                        <a href="#" class="list-button" data-category="${categoryName.name}" data-country="${countryName.name}">
                          <button type="button" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-thumbs-up"></span> ${categoryName.name}
                          </button>
                       </a>
                       </c:forEach>
                    </div>
                  </div>
                </div>
              </div>

    <div id="board-list">
    <c:forEach var="board" items="${board}" varStatus="status">
        <c:if test="${status.index % 2 == 0}">
            <div class="row">
        </c:if>
        <div class="col-sm-6">
            <a href='/board/${board.id}'>
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
                    <p>
                        <fmt:formatDate value="${board.create_at}" pattern="yyyy-MM-dd HH:mm" />
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

</div>

   </div>
</body>
<%@ include file="../layout/footer.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        $(document).ready(function() {
            $(".list-button").click(function() {
                console.log("@@@@@@@@@");
                var category = $(this).data("category");
                var country = $(this).data("country");

                console.log("category:" + category);
                console.log("country:" + country);

                $.ajax({
                    url: "/category",
                    data: { category: category, country: country },
                    //data: { category: category },

                    success: function(data) {
                        $("#board-list").html(data);
                    }
                });
            });
        });

        $(document).ready(function() {
            $(".category-button-all").click(function() {
                console.log("!!!!!");
                $.ajax({
                    url: "/category",
                    data: { category: "all" },
                    success: function(data) {
                        $("#board-list-all").html(data);
                    }
                });
            });
        });
    </script>


</html>
<script src="/js/board.js"></script>
