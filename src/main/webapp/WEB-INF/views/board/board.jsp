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
                <div class="col-sm-12">
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
</div>

   </div>
</body>
<%@ include file="../layout/footer.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        $(document).ready(function() {
            function fetchFilteredData(category, country) {
                $.ajax({
                    url: "/category",
                    data: { category: category, country: country },
                    success: function(data) {
                        var extractedData = $(data).find("#new-board-list-container").html();
                        $("#new-board-list-container").html(extractedData);
                    }
                });
            }
            // Initial page load: Fetch the entire board list
            fetchFilteredData(null, null);

            // Click event handler for filter buttons
            $(".list-button").click(function() {
                var category = $(this).data("category");
                var country = $(this).data("country");
                fetchFilteredData(category, country);
            });


/*
            $(".list-button").click(function() {
                console.log("@@@@@@@@@");
                var category = $(this).data("category");
                var country = $(this).data("country");

                console.log("category:" + category);
                console.log("country:" + country);

                $.ajax({
                    url: "/category",
                    data: { category: category, country: country },

                    success: function(data) {
                        var extractedData = $(data).find("#new-board-list-container").html();
                        $("#new-board-list-container").html(extractedData);
                        console.log(extractedData);
                    }
                });
            });
*/
        });
    </script>
</html>
