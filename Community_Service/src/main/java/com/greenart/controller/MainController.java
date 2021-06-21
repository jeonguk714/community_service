package com.greenart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.greenart.service.BoardService;
import com.greenart.service.UserService;
import com.greenart.utils.AESAlgorithm;
import com.greenart.vo.LoginVO;
import com.greenart.vo.PostVO;
import com.greenart.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    BoardService service;
    @Autowired
    UserService uService;
    
    @GetMapping("/")
    public String getMain(Model model){
        List<PostVO> noticeList = service.getPostList(0, 1, "%%", null);
        List<PostVO> newNoticeList = new ArrayList<PostVO>();
        
        int limit = 0;
        ///// noticeList의 글 개수가 5개보다 작으면 에러가 날 수 있으니, 미리 필터링
        if(noticeList.size() < 5) limit = noticeList.size(); // 5개보다 적으면, 리스트의 크기로 설정
        else limit = 5; // 5개 이상이면 5로 설정
        for(int i=0; i < limit; i++){
            newNoticeList.add(noticeList.get(i));
        }

        List<PostVO> stockList = service.getPostList(0, 5, "%%", null);
        List<PostVO> newStockList = new ArrayList<PostVO>();
        
        limit = 0;
        ///// noticeList의 글 개수가 5개보다 작으면 에러가 날 수 있으니, 미리 필터링
        if(stockList.size() < 5) limit = stockList.size(); // 5개보다 적으면, 리스트의 크기로 설정
        else limit = 5; // 5개 이상이면 5로 설정
        for(int i=0; i < limit; i++){
            newStockList.add(stockList.get(i));
        }
        model.addAttribute("noticeList", newNoticeList);
        model.addAttribute("stockList", newStockList);

        return "/main";
    }
    @GetMapping("/member/join")
    public String getJoin(){
        return "/member/join";
    }
    @GetMapping("/member/login")
    public String getLogin(){
        return "/member/login";
    }
    @GetMapping("/member/logout")
    public String getLogout(HttpSession session) {
    	session.setAttribute("userInfo", null);
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/member/detail")
    public String getMemberDetail(@RequestParam Integer ui_seq, Model model){
        UserVO vo = uService.selectUserBySeq(ui_seq);
        Integer postCnt = uService.selectUserPostCount(ui_seq);
        Integer likeCnt = uService.selectUserGoodBadCount(ui_seq, 1);
        Integer dislikeCnt = uService.selectUserGoodBadCount(ui_seq, 0);
        
        List<PostVO> postList = service.selectPostByUserId(ui_seq);

        model.addAttribute("user_detail", vo);
        model.addAttribute("postCnt", postCnt);
        model.addAttribute("likeCnt", likeCnt);
        model.addAttribute("dislikeCnt", dislikeCnt);
        model.addAttribute("recentPosts", postList);
        
        return "/member/detail";
    }
    
    @GetMapping("/member/modify")
    public String getMemberModify() {
    	return "/member/modify";
    }
    
    @PostMapping("/member/cert")
    public String getMemberCert(@RequestParam String user_id, @RequestParam String user_pwd) {
    	boolean result = false;
    	LoginVO vo = new LoginVO();
    	vo.setId(user_id);
    	try {
        	vo.setPwd(AESAlgorithm.Encrypt(user_pwd));
    	}
    	catch(Exception e) {e.printStackTrace(); }
    	result = uService.loginUser(vo);
    	
    	if(result) {
    		return "/member/modify_info";
    	}
    	else {
    		return "/member/modify";
    	}
    }
}
