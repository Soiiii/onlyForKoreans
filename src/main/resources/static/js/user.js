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
            //정상적 처리가 되면
            if(resp.status === 200){
              alert("회원가입 완료");
              location.href="/";
            } else{
            //에러가 처리가 되면
                console.log(resp.data);
                  if(resp.message)
                  {
                  //이메일 오류 처리
                    if(resp.message.includes("이메일")){
                        $("#valid_email").text(resp.message);
                        $("#valid_email").css('color', 'red');
                    }
                    else{
                        $("#valid_email").text("");
                    }
                  //비밀번호 오류 처리
                    if(resp.message.includes("비밀번호")){
                        $("#valid_password").text(resp.message);
                        $("#valid_password").css('color', 'red');
                    } else{
                        $("#valid_password").text("");
                    }
                  //나라 오류 처리
                    if(resp.message.includes("나라")){
                        $("#valid_country").text(resp.message);
                        $("#valid_country").css('color', 'red');
                    }
                    else{
                        $("#valid_country").text("");
                    }
                  //닉네임 오류 처리
                    if(resp.message.includes("닉네임")){
                        $("#valid_name").text(resp.message);
                        $("#valid_name").css('color', 'red');
                    }
                    else{
                        $("#valid_name").text("");
                    }
               }
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
                name: $("#username").val(),
                password: $("#password").val(),
                email: $("#email").val(),
                country: $("#country").val()
           };

           $.ajax({
               type:"POST",
               url:"/updateUser",
               data:JSON.stringify(data),//http body 데이터 //그냥 던지면 자바가 이해할 수없기 때문에 JSON.stringify에 data객체를 담아 전달
               contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MINE)
               dataType:"json" // 요청을 서버로해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴 Json이라면) => javascript object로 변경
           //회원가입 수행을 요청
           }).done(function(resp){
                console.log(resp)
                //회원가입이 정상적으로 성공하는 실행 하는 함수
                if (resp.status === 200) {
                    alert("회원수정이 완료되었습니다.");
                    location.href = "/"; // 홈페이지로 이동하거나 원하는 페이지로 리디렉션할 수 있습니다.
                } else {
                  //비밀번호 오류 처리
                    if(resp.message.includes("비밀번호")){
                        $("#valid_password").text(resp.message);
                        $("#valid_password").css('color', 'red');
                    } else{
                        $("#valid_password").text("");
                    }
                }
           });
//           .fail(function(error){
//                //회원가입에 실패하면 실행하는 함수
//                alert("회원수정에 실패했습니다. 오류 메시지: " + JSON.stringify(error));
//           });
          event.preventDefault();
    },
}

index.init();