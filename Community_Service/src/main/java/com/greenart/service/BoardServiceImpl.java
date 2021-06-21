package com.greenart.service;

import java.util.List;

import com.greenart.dao.BoardDao;
import com.greenart.vo.CategoryVO;
import com.greenart.vo.CommentReqVO;
import com.greenart.vo.CommentVO;
import com.greenart.vo.GoodBadVO;
import com.greenart.vo.PostRegistVO;
import com.greenart.vo.PostVO;
import com.greenart.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao dao;
    @Override
    public List<CategoryVO> getCategoryList() {
        // TODO Auto-generated method stub
        return dao.getCategoryList();
    }
    @Override
    public List<PostVO> getPostList(Integer offset, Integer board, String keyword, String type) {
        // TODO Auto-generated method stub
        List<PostVO> postList = dao.getPostList(offset, board, keyword, type);
        postList.forEach(post -> {
            Integer seq = post.getPi_seq();
            CommentReqVO vo = new CommentReqVO();
            vo.setBoard_seq(seq);
            Integer commentCnt = dao.selectCommentCount(vo);
            if(commentCnt > 0) {
                post.setPi_title(post.getPi_title()+" ("+commentCnt+")");
            }
        });

        Integer total = this.getBoardPostCount(board, "%%", null);
        for(int i=0; i<postList.size(); i++){
            postList.get(i).setNo(total-i-offset);
        }
        return postList;
    }
    @Override
    public PostVO getPostBySeq(Integer no) {
        // TODO Auto-generated method stub
        return dao.getPostBySeq(no);
    }
    @Override
    public void insertComment(CommentVO vo){
        dao.insertComment(vo);
    }
    @Override
    public List<CommentVO> selectComment(CommentReqVO vo){
        return dao.selectComment(vo);
    }
    @Override
    public Integer selectCommentCount(CommentReqVO vo) {
        // TODO Auto-generated method stub
        return dao.selectCommentCount(vo);
    }

    @Override
    public void updatePostCount(Integer seq) {
        // TODO Auto-generated method stub
        dao.updatePostCount(seq);
    }

    @Override
    public void insertPost(PostRegistVO vo) {
        // TODO Auto-generated method stub
        dao.insertPost(vo);
    }
    @Override
    public void deletePost(Integer seq) {
        // TODO Auto-generated method stub
        dao.deletePost(seq);
    }

    @Override
    public void updatePost(PostVO vo) {
        // TODO Auto-generated method stub
        dao.updatePost(vo);
    }

    @Override
    public Integer getBoardPostCount(Integer board_seq, String keyword, String type) {
        // TODO Auto-generated method stub
        return dao.getBoardPostCount(board_seq, keyword, type);
    }

    @Override
    public void insertPostGoodBad(GoodBadVO vo) {
        // TODO Auto-generated method stub
        dao.insertPostGoodBad(vo);
    }

    @Override
    public GoodBadVO selectPostGoodBad(GoodBadVO vo) {
        // TODO Auto-generated method stub
        return dao.selectPostGoodBad(vo);
    }

    @Override
    public void updatePostGoodBad(GoodBadVO vo) {
        // TODO Auto-generated method stub
        dao.updatePostGoodBad(vo);
    }

    @Override
    public List<Integer> selectPostLikesCount(Integer seq) {
        // TODO Auto-generated method stub
        return dao.selectPostLikesCount(seq);
    }

    @Override
    public void insertCommentGoodBad(GoodBadVO vo) {
        // TODO Auto-generated method stub
        dao.insertCommentGoodBad(vo);
    }
    @Override
    public GoodBadVO selectCommentGoodBad(GoodBadVO vo) {
        // TODO Auto-generated method stub
        return dao.selectCommentGoodBad(vo);
    }
    @Override
    public List<Integer> selectCommentLikesCount(Integer seq) {
        // TODO Auto-generated method stub
        return dao.selectCommentLikesCount(seq);
    }
    @Override
    public void updateCommentGoodBad(GoodBadVO vo) {
        // TODO Auto-generated method stub
        dao.updateCommentGoodBad(vo);
    }
    @Override
    public void deleteComment(Integer seq) {
        // TODO Auto-generated method stub
        dao.deleteComment(seq);
    }
    
    @Override
    public List<PostVO> selectPostByUserId(Integer user_seq) {
    	// board이름을 sql에서 가져오지 않았을 때의 처리
//    	List<PostVO> list = dao.selectPostByUserId(user_seq);
//    	list.forEach(post -> {
//    		String board_name = "";
//    		switch(post.getPi_board_seq()) {
//    		case 1:
//    			board_name = "공지사항";
//    			break;
//    		case 5:
//    			board_name = "주식";
//    			break;
//    		case 6:
//    			board_name = "-";
//    		}
//    		post.setBi_name(board_name);
//    	});
//    	return list;
    	return dao.selectPostByUserId(user_seq);
    }
    
    @Override
    public void updateUserInfo(UserVO vo) {
    	// TODO Auto-generated method stub
    	dao.updateUserInfo(vo);
    }
}
