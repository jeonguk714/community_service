package com.greenart.dao;

import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public Integer selectUserCntById(String userid);
    public void insertUser(UserVO vo);
    public Integer loginUser(LoginVO vo);
    public UserVO selectUserById(LoginVO vo);

    public UserVO selectUserBySeq(Integer seq);
    public Integer selectUserPostCount(Integer seq);
    public Integer selectUserGoodBadCount(Integer seq, Integer good_bad);
    public void updateUserInfo(UserVO vo);
}
