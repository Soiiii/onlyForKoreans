<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

<form action="/auth/loginProc" method="post">
  <div class="form-group">
    <label for="username">Email:</label>
    <input type="text" name="username" class="form-control" placeholder="Enter Email address" id="username">
  </div>

  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" name="password" class="form-control" placeholder="Enter your password" id="password">
  </div>

    <button id="btn-login" class="btn btn-primary">LOGIN</button>
    <hr>
    <a href="#"><h7> FORGOTTEN PASSWORD? </h7></a>
</form>
</div>

<%@ include file="../layout/footer.jsp"%>
