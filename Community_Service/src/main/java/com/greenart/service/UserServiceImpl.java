package com.greenart.service;

import com.greenart.dao.UserDao;
import com.greenart.utils.AESAlgorithm;
import com.greenart.vo.LoginVO;
import com.greenart.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao dao;
    @Override
    public boolean isDuplicatedUser(String userid) {
        // TODO Auto-generated method stub
        // if(dao.selectUserCntById(userid) == 1){
        //     return true;
        // }
        // else {
        //     return false;
        // }
        // return false;
        return dao.selectUserCntById(userid) == 1;
    }

    @Override
    public Integer insertUser(UserVO vo) {
        // 프론트에서 이미 validation을 했지만, ARC같은 RestRequest 툴로 강제 요청을
        // 막아주는 역할을 한다. (Front에서 Validation한 항목들을 Back에서 한 번 더 확인)
        if(vo.getUi_id().equals("") || vo.getUi_id() == null) {
            System.out.println("아이디 누락");
            return 400;
        }
        if(vo.getUi_pwd().equals("") || vo.getUi_pwd() == null) {
            System.out.println("비밀번호 누락");
            return 400;
        }
        if(vo.getUi_name().equals("") || vo.getUi_name() == null) {
            System.out.println("이름 누락");
            return 400;
        }
        if(vo.getUi_email().equals("") || vo.getUi_email() == null) {
            System.out.println("이메일 누락");
            return 400;
        }
        // 암호화
        String pwd = vo.getUi_pwd();
        try{
            pwd = AESAlgorithm.Encrypt(pwd);
            vo.setUi_pwd(pwd);
        }
        catch(Exception e){
            System.out.println("암호화 실패 : "+e.getMessage());
            return 500;
        }

        dao.insertUser(vo);
        return 200;
    }

    @Override
    public boolean loginUser(LoginVO vo) {
        // TODO Auto-generated method stub
        Integer result = dao.loginUser(vo);
        if(result == 1) return true;
        return false;
    }

    @Override
    public UserVO selectUserById(LoginVO vo) {
        // TODO Auto-generated method stub
        return dao.selectUserById(vo);
    }

    @Override
    public UserVO selectUserBySeq(Integer seq) {
        // TODO Auto-generated method stub
        return dao.selectUserBySeq(seq);
    }
    @Override
    public Integer selectUserPostCount(Integer seq) {
        // TODO Auto-generated method stub
        return dao.selectUserPostCount(seq);
    }
    @Override
    public Integer selectUserGoodBadCount(Integer seq, Integer good_bad) {
        // TODO Auto-generated method stub
        return dao.selectUserGoodBadCount(seq, good_bad);
    }
    
    @Override
    public void updateUserInfo(UserVO vo) {
    	// TODO Auto-generated method stub
    	dao.updateUserInfo(vo);
    }
}
