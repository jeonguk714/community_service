package com.greenart.controller;

import java.util.List;

import com.greenart.service.BoardService;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IntroduceController {
    @Autowired
    BoardService service;
    @GetMapping("/notice")
    public String getNotice(
        @RequestParam @Nullable Integer offset, 
        @RequestParam @Nullable String keyword, 
        @RequestParam @Nullable String type,
        Model model
    ){
        if(offset == null) offset = 0;
        if(keyword == null) keyword = "%%";
        else keyword = "%"+keyword+"%";
        if(type == null) type = "title";
        List<PostVO> list = service.getPostList(offset, 1, keyword, type);

        // Integer total = service.getBoardPostCount(1);
        // for(int i=0; i<list.size(); i++){
        //     list.get(i).setNo(total-i-offset);
        // }

        model.addAttribute("list", list);
        model.addAttribute("board_seq", 1);
        return "/introduce/notice";
    }
    @GetMapping("/notice/detail")
    public String getNoticeDetail(@RequestParam Integer no, Model model){
        PostVO data = service.getPostBySeq(no);
        model.addAttribute("data", data);
        // CommentVO vo = new CommentVO();
        // vo.setCi_pi_seq(no);

        CommentReqVO vo = new CommentReqVO();
        vo.setBoard_seq(no);
        vo.setOffset(0);
        List<CommentVO> comments = service.selectComment(vo);
        model.addAttribute("comments", comments);

        List<Integer> likes = service.selectPostLikesCount(no);
        model.addAttribute("likes", likes);

        return "/introduce/detail";
    }

    @GetMapping("/notice/write")
    public String getNewNotice(){
        return "/introduce/write";
    }

    @GetMapping("/notice/modify")
    public String getModifyNotice(@RequestParam Integer seq, Model model){
        PostVO vo = service.getPostBySeq(seq);
        model.addAttribute("postInfo", vo);
        return "/introduce/modify";
    }
}
