
let index={
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-delete").on("click", ()=>{
            this.deleteById();
        });
        $("#btn-update").on("click", ()=>{
            this.update();
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

    deleteById:function(){
        console.log("@@@@@");
        let id = $("#id").val();
         console.log("deleteById called"); // 디버깅 메시지 추가
         console.log(id); // 디버깅 메시지 추가

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



}
index.init();