$(function(){
    let dupCheck = false; // 중복 검사 결과 저장
    $("#join_btn").click(function(){
        if(dupCheck == false) {
            alert("아이디 중복 여부를 확인해주세요");
            return;
        }
        if($("#user_id").val() == "") {
            alert("아이디를 입력해주세요");
            return;
        }
        if($("#user_email").val() == "") {
            alert("메일주소를 입력해주세요");
            return;
        }
        if($("#user_pwd").val() == "") {
            alert("비밀번호를 입력해주세요");
            return;
        }
        else {
            if($("#user_pwd").val() != $("#user_pwd_confirm").val()){
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                return;
            }
        }
        // 서버로 데이터 전송
        let userdata = {
            "ui_id":$("#user_id").val(),
            "ui_pwd":$("#user_pwd").val(),
            "ui_name":$("#user_name").val(),
            "ui_email":$("#user_email").val(),
            "ui_blog":$("#user_blog").val(),
            "ui_profile_img":$("#user_pf_img").val(),
            "ui_introduce":$("#user_pf_msg").val(),
            "ui_ip":"127.0.0.1"
        }
        $.ajax({
            url:"/api/useradd",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(userdata),
            success:function(data){
                console.log(data);
                alert("가입되었습니다.");
            },
            error:function(data) {
                alert("에러");
            }
        })
    });

    $("#id_dup_chk").click(function(){
        if($("#user_id").val() == "") {
            alert("아이디를 입력해주세요");
            return;
        }
        if($("#user_id").val().length < 4) {
            alert("아이디는 4글자 이상 입력해주세요");
            return;
        }
        // dupCheck = true;
        let data = {
            ui_id:$("#user_id").val()
        };

        // JSON.stringify(객체) - 객체를 JSON 문자열 형태로 변환
        $.ajax({
            url:"/api/userchk",
            type:"post",
            contentType:"application/json",
            resultType:"json",
            data:JSON.stringify(data),
            success:function(data) {
                console.log(data);
                dupCheck = !data.result; // 중복일 때 true, 아닐때 false
                if(data.result == true){
                    $(".err_msg").html("["+$("#user_id").val()+"]은/는 이미 가입된 아이디입니다.");
                    $(".err_msg").addClass("err").removeClass("ok");
                }
                else {
                    $(".err_msg").html("["+$("#user_id").val()+"]은/는 가입가능한 아이디입니다.");
                    $(".err_msg").addClass("ok").removeClass("err");
                }
            },
            error:function(data) {
                alert("에러 발생");
                console.log(data);
            }
        })
    })

    $("#user_id").keyup(function(){
        $(".err_msg").html("");
        dupCheck = false;
    })
})