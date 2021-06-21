package com.greenart.dao;

import com.greenart.mapper.UserMapper;
import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserDaoImpl implements UserDao {
    @Autowired
    UserMapper mapper;
    @Override
    public Integer selectUserCntById(String userid) {
        // TODO Auto-generated method stub
        return mapper.selectUserCntById(userid);
    }

    @Override
    public void insertUser(UserVO vo) {
        // TODO Auto-generated method stub
        mapper.insertUser(vo);        
    }

    @Override
    public Integer loginUser(LoginVO vo) {
        // TODO Auto-generated method stub
        return mapper.loginUser(vo);
    }

    @Override
    public UserVO selectUserById(LoginVO vo) {
        // TODO Auto-generated method stub
        return mapper.selectUserById(vo);
    }

    @Override
    public UserVO selectUserBySeq(Integer seq) {
        // TODO Auto-generated method stub
        return mapper.selectUserBySeq(seq);
    }

    @Override
    public Integer selectUserPostCount(Integer seq) {
        // TODO Auto-generated method stub
        return mapper.selectUserPostCount(seq);
    }

    @Override
    public Integer selectUserGoodBadCount(Integer seq, Integer good_bad) {
        // TODO Auto-generated method stub
        return mapper.selectUserGoodBadCount(seq, good_bad);
    }
    
    @Override
    public void updateUserInfo(UserVO vo) {
    	// TODO Auto-generated method stub
    	mapper.updateUserInfo(vo);
    }
}
