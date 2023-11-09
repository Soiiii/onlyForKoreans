function commentEdit(commentIndex) {
    // Rest of your JavaScript code
    console.log('commentIndex:' + commentIndex)
    $(document).ready(function() {
        // 수정 버튼의 클릭 이벤트 핸들러
        $("[id^=btn-comment-edit]").click(function() {
            // 버튼의 ID에서 고유한 인덱스를 추출
            var index = $(this).attr("id").replace("btn-comment-edit", "");
            console.log('index:'+index)
            // 해당 댓글과 그 ID에 액세스하기 위해 인덱스 사용
            var commentId = $("#commentId" + index).val();
            console.log('commentId:'+commentId)


            // 해당 댓글에 대한 수정 작업을 수행
            // 댓글 내용을 수정하는 모달을 열거나 수정할 댓글을 가져오기 위해 AJAX 요청을 수행할 수 있습니다.

            let data = {
        //        content: content,
                commentId: commentId
            }

            $.ajax({
                type: "POST",
                url: "/api/comment/edit",
                data: JSON.stringify(data),
                contentType:"application/json; charset=utf-8",
                dataType: "json"
            });
        });
    });
}

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
        /*
        $(".list-button").on("click", ()=>{
            this.listButton();
        });
        */
    },
    /*
    listButton:function(){
        console.log("@@@@@@@@@");

        var category = $(this).data("category");
        var country = $(this).data("country");

        console.log("category:" + category);
        console.log("country:" + country);

        $.ajax({
            url: "/category",
            data: { category: category, country: country },

            success: function(data) {
                $("#board-list").html(data);
            }
        });
    },
*/
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

    commentEdit:function(commentIndex){
       console.log(commentIndex)
        let content = $("#content" + commentIndex).val();
        let commentId = $("#commentId" + commentIndex).val();
//        let content = $("#content" + content).val();
//        let commentId = $("#commentId" + commentId).val();
        console.log(content, commentId)

        let data = {
            content: content,
            commentId: commentId
        }
        console.log('data:', data)

        $.ajax({
            type: "POST",
            url: "/api/comment/edit",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        })
        .done(function(resp){
            if(resp.data == 1){
                alert("댓글 수정 완료");
                // Reload the page on success
                location.reload();
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}
index.init();