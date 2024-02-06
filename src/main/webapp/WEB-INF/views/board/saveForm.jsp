<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>


<div class="container">
    <form>
          <div class="form-group">
                <label for="country">Country:</label>
                    <select class="form-control" id="country">
                      <option>${object[0].name}</option>
                      <option>${object[1].name}</option>
                      <option>${object[2].name}</option>
                      <option>${object[3].name}</option>
                      <option>${object[4].name}</option>
                    </select>
          </div>

          <div class="form-group">
            <label for="category">Category</label>
                    <select class="form-control" id="category">
                      <option>${category[0].name}</option>
                      <option>${category[1].name}</option>
                      <option>${category[2].name}</option>
                      <option>${category[3].name}</option>
                      <option>${category[5].name}</option>
                      <option>${category[6].name}</option>
                      <option>${category[7].name}</option>
                    </select>
          </div>

          <div class="form-group">
            <label for="title">제목</label>
            <input type="username" class="form-control" placeholder="Enter title" id="title">
          </div>

          <div class="form-group">
<!--            <label for="content">내용</label>-->
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
          </div>


        </form>
        <button id="btn-save" class="btn btn-primary">작성 완료</button>
</div>

<script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>



