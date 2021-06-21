$(function(){
	$("#join_btn").click(function(){
		if($("#user_name").val() == ''){
			alert("이름을 입력하세요.");
			return;
		}
		if($("#user_email").val() == ''){
			alert("이메일을 입력하세요.");
			return;
		}
		if($("#prev_pwd").val().length > 0){
			if($("#user_pwd").val() != $("#user_pwd_confirm").val()){
				alert("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				return;
			}
		}
		
		let data = {
			"ui_seq":ui_seq,
			"ui_id":$("#user_id").val(),
			"ui_name":$("#user_name").val(),
			"ui_email":$("#user_email").val(),
			"ui_blog":$("#user_blog").val(),
			"ui_profile_img":$("#user_pf_ing").val(),
			"ui_introduce":$("#user_pf_msg").val(),
			"ui_pwd":$("#prev_pwd").val(),
			"confirm_pwd":$("#user_pwd").val()
		}
		console.log(JSON.stringify(data));
		$.ajax({
			url:"/api/modify_user",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				alert(data.message);
			},
			error:function(){
				alert("에러");
			}
		})
	})
})