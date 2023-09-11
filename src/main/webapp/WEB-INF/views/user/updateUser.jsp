<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}

    /* Set gray background color and 100% height */
    .sidenav {
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
    <div class="col-sm-3 sidenav">
      <h4>ACTIVITIES</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="/user/myPage">내가 작성한 글</a></li>
        <li><a href="/user/bookmark">BOOKMARK</a></li>
      </ul><br>
      <h4>MY PAGE</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="/user/myPage">회원정보 수정</a></li>
      </ul><br>

    </div>


    <div class="col-sm-9">
      <h4><small>회원정보 수정<small></h4>
      <hr>

<div class="container">
    <form>
          <input type="hidden" id="id" value="${principal.user.id}" />
          <div class="col-sm-7">
            <label for="username">Username:</label>
            <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter Username" id="username" readonly>
          <br>
          </div>

          <div class="col-sm-7">
            <label for="email">Email address:</label>
            <input type="email"  value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email" readonly>
          <br>
          </div>

          <div class="col-sm-7">
          <div class="form-group">
                <label for="country">Country:</label>
                    <select class="form-control" id="country" value="${principal.user.country}">
                        <option value="${object[0].name}" ${principal.user.country.name == object[0].name ? "selected" : ""}>${object[0].name}</option>
                        <option value="${object[1].name}" ${principal.user.country.name == object[1].name ? "selected" : ""}>${object[1].name}</option>
                        <option value="${object[2].name}" ${principal.user.country.name == object[2].name ? "selected" : ""}>${object[2].name}</option>
                        <option value="${object[3].name}" ${principal.user.country.name == object[3].name ? "selected" : ""}>${object[3].name}</option>
                        <option value="${object[4].name}" ${principal.user.country.name == object[4].name ? "selected" : ""}>${object[4].name}</option>
                    </select>
                    <p id="valid_country"></p>
                <span style="color: red">${valid_country}</span>
          </div>
          </div>

          <div class="col-sm-7">
            <label for="password">Password:</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password"
            value="${userDto.password}" required/>
            <p id="valid_password">${valid_password}</p>

          <br>
          <br>
          </div>
          <button id="btn-update" class="col-sm-7 btn btn-primary" align="center">회원수정완료</button>

    </form>

</div>


    </div>

  </div>

</div>
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>



</body>
</html>
