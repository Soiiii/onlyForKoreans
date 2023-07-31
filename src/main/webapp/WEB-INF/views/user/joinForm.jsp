<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

<form>
  <div class="form-group">
        <label for="email">Email address:</label>
        <input type="email" class="form-control" placeholder="Enter your email" id="email"
        value="${userDto.email}" required/>
        <p id="valid_email"></p>
  </div>

  <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" placeholder="Enter your password" id="password"
        value="${userDto.password}" required/>
        <p id="valid_password">${valid_password}</p>

  </div>

  <div class="form-group">
        <label for="country">Country:</label>
            <select class="form-control" id="country">
              <option>${object[0].name}</option>
              <option>${object[1].name}</option>
              <option>${object[2].name}</option>
              <option>${object[3].name}</option>
              <option>${object[4].name}</option>
            </select>
            <p id="valid_country"></p>
        <span style="color: red">${valid_country}</span>
  </div>
  <div class="form-group">
            <label for="name">Username:</label>
            <input type="name" class="form-control" placeholder="Enter Username" id="name"
            value="${userDto.name}" />
            <p id="valid_name"></p>
  </div>

<br>
<br>
</form>
  <button id="btn-save" class="btn btn-primary">CREATE MY ACCOUNT</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
</div>
