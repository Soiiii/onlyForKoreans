<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

<form>
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter your email" id="email">
  </div>

  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter your password" id="password">
  </div>

  <div class="form-group">
    <label for="country">Country:</label>
        <select class="form-control" id="country">
          <option>Japan</option>
          <option>China</option>
          <option>Vietnam</option>
          <option>Thai</option>
          <option>Philippines</option>
        </select>
  </div>
  <div class="form-group">
    <label for="name">Username:</label>
    <input type="text" class="form-control" placeholder="Enter Username" id="name">
  </div>

</form>
  <button id="btn-save" class="btn btn-primary">CREATE MY ACCOUNT</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
</div>