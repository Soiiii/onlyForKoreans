let index={
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
//        $("#btn-login").on("click", ()=>{
//            this.login();
//        });
        $("#btn-update").on("click", ()=>{
            this.update();
        });
    },

    save:function(){
        let data={
            name:$("#name").val(),
            password:$("#password").val(),
            email:$("#email").val(),
            country:$("#country").val()
        };
        console.log("data: ", data)

        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            if(resp.status === 200){
              alert("회원가입 완료");
              location.href="/";
            } else{
                console.log(resp.data);
                console.log(resp.message);

                  alert("회원가입 정보를 다시 확인해 주세요.")
//                  if(resp.data.hasOwnProperty("valid_email"))
                  if(resp.message.hasOwnProperty("valid_email"))

                  {
                    $("#valid_email").text(response.data.valid_email);
                    $("#valid_email").css('color', 'red');
                  }
                 else{
                   $("#valid_email").text("");
                  }
//                  if(resp.data.hasOwnProperty("valid_password"))
                  if(resp.message.hasOwnProperty("valid_password"))
                  {
                    $("#valid_password").text(response.data.valid_password);
                    $("#valid_password").css('color', 'red');
                  }
                  else{
                    $("#valid_password").text("");
                  }

//                if(resp.data === 0){
//                    let passwordError = resp.message;
//                    $("#valid_password").text(passwordError).css("color", "red");
//                }
//                else{
//                    alert("회원가입 중 오류가 발생하였습니다.")
//                }
           }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

//    login:function(){
//        let data={
//            email:$("#email").val(),
//            password:$("#password").val(),
//        };
//        console.log("data: ", data)
//
//        $.ajax({
//            type: "POST",
//            url: "/auth/loginProc",
//            data: JSON.stringify(data),
//            contentType:"application/json; charset=utf-8",
//            dataType: "json"
//        }).done(function(resp){
//            location.href="/";
//        }).fail(function(error){
//            alert(JSON.stringify(error));
//        });
//    },

    update:function(){

        //입력 값을 찾아서 자바스큽트 오브젝트에 넣음 #-> #username 은 id=username 으로 되어있는 곳의 입력값을 찾음
           let data = {
                id : $("#id").val(),
                name: $("#name").val(),
                password: $("#password").val(),
                email: $("#email").val()
           };

           $.ajax({
               type:"PUT",
               url:"/user",
               data:JSON.stringify(data),//http body 데이터 //그냥 던지면 자바가 이해할 수없기 때문에 JSON.stringify에 data객체를 담아 전달
               contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MINE)
               dataType:"json" // 요청을 서버로해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴 Json이라면) => javascript object로 변경
           //회원가입 수행을 요청
           }).done(function(resp){

                //회원가입이 정상적으로 성공하는 실행 하는 함수
                alert("회원수정이 완료 되었습니다.");
                //console.log(resp);
                location.href="/";
           }).fail(function(error){
                //회원가입에 실패하면 실행하는 함수
                alert(JSON.stringify(error));
           });
    },
}

index.init();