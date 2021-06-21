// write.js
$(function(){
    $("#post_save").click(function(){
        if($("#post_title").val() == ''){
            alert("제목을 입력하세요");
            return;
        }
        if($("#post_content").val() == ''){
            alert("내용을 입력하세요");
            return;
        }
        // 데이터 전송
        let data = {
            "board_seq":board_seq,
            "user_seq":$(".title_area").attr("data-user-seq"),
            "post_title":$("#post_title").val(),
            "post_content":$("#post_content").val(),
            "post_ip":"127.0.0.1"
        }

        $.ajax({
            url:"/api/write",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(data) {
                console.log(data);
                alert("등록되었습니다.");
                history.back();
            },
            error:function(){
                alert("에러");
            }
        })

    });
    $("#post_cancel").click(function(){
        if(confirm("취소하시겠습니까?")){
            location.href="/notice";
        }
    })
})