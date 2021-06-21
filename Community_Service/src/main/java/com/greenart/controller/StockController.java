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
public class StockController {
    @Autowired
    BoardService service;
    @GetMapping("/stock")
    public String getStock(
        @RequestParam @Nullable Integer offset,
        @RequestParam @Nullable String keyword,
        @RequestParam @Nullable String type,
        Model model
    ){
        if(offset == null) offset = 0;
        if(keyword == null) keyword = "%%";
        else keyword = "%"+keyword+"%";

        List<PostVO> list = service.getPostList(offset, 5, keyword, type);

        // Integer total = service.getBoardPostCount(5);
        // for(int i=0; i<list.size(); i++){
        //     list.get(i).setNo(total-i-offset);
        // }

        model.addAttribute("list", list);
        model.addAttribute("board_seq", 5);
        return "/stock/board";
    }
    @GetMapping("/stock/detail")
    public String getStockDetail(@RequestParam Integer no, Model model) {
        PostVO data = service.getPostBySeq(no);
        model.addAttribute("data", data);

        CommentReqVO vo = new CommentReqVO();
        vo.setBoard_seq(no);
        vo.setOffset(0);
        List<CommentVO> comments = service.selectComment(vo);
        model.addAttribute("comments", comments);

        List<Integer> likes = service.selectPostLikesCount(no);
        model.addAttribute("likes", likes);
        
        return "/stock/detail";
    }

    @GetMapping("/stock/write")
    public String getStockWrite(){
        return "/stock/write";
    }
}
