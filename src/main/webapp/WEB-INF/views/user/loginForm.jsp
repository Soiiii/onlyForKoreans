<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
    <form action="/auth/loginProc" method="post">
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" name="email" class="form-control" placeholder="Enter email" id="email">
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" name="password" class="form-control" placeholder="Enter your password" id="password">
      </div>

        <button id="btn-login" class="btn btn-primary">LOGIN</button>

        <hr>

    <span>
        <c:if test="${error}">
            <p id="valid" class="alert alert-danger">${exception}</p>
        </c:if>
    </span>
    </form>

            <a href="#"><h7> FORGOTTEN PASSWORD? </h7></a>

</div>

<%@ include file="../layout/footer.jsp"%>
