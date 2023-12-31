let index={
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-delete").on("click", ()=>{
            this.deleteBoard();
        });
        $("#btn-update").on("click", ()=>{
            this.update();
        });
        $("#btn-bookmark").on("click", ()=>{
            this.bookmark();
        });
        $("#btn-comment").on("click", ()=>{
            this.comment();
        });
        $("#btn-comment-edit").on("click", ()=>{
            this.commentEdit();
        });
    },

    save:function(){
        let data={
            country:$("#country").val(),
            category:$("#category").val(),
            title:$("#title").val(),
            content: $("#content").val(),
        };
        console.log("data: ", data)

        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("글쓰기 완료");
            location.href="/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    deleteBoard:function(){
        let id = $("#id").val();
         console.log("deleteById called"); // 디버깅 메시지 추가
        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
            dataType: "json"
        }).done(function(resp){
            alert("삭제 완료");
            location.href="/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    update:function(){
        let id = $("#id").val();

        let data={
            id: $("#id").val(),
            title:$("#title").val(),
            content:$("#content").val(),
        };
        console.log("data: ", data)

        $.ajax({
            type: "POST",
            url: "/api/board/" + id + "/updateForm",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("글수정 완료");
            location.href="/board/" + id;
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    bookmark:function(){
        let data = {
            book_num: $("#book_num").val(),
            board_id: $("#board_id").val(),
            user_id: $("#user_id").val(),
        }
        console.log("data:", data)

        $.ajax({
            type: "POST",
            url: "/api/board/bookmark",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        })
        .done(function(resp){
            alert(resp.data);
            if(resp.data == 1){
                alert("즐겨찾기 완료");
            } else if(resp.data ==0){
                alert("즐겨찾기 취소 완료");
            }

            location.href="/board/" + document.getElementById("board_id").value;
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
        ;

    },

    comment:function(){
        let data = {
            content: $("#content").val(),
            board_id: $("#board_id").val(),
            user_id: $("#user_id").val(),
        }
        console.log('data:', data)

        $.ajax({
            type: "POST",
            url: "/api/comment",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        })
        .done(function(resp){
            if(resp.data == 1){
                alert("댓글 작성 완료");
                // Reload the page on success
                location.reload();
            } else if(resp.data == 0){
                alert("댓글을 입력해주세요");
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

}
index.init();