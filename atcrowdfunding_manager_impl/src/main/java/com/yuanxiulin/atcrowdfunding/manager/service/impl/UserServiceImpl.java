package com.yuanxiulin.atcrowdfunding.manager.service.impl;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.manager.dao.UserMapper;
import com.yuanxiulin.atcrowdfunding.manager.service.UserService;
import com.yuanxiulin.atcrowdfunding.util.exception.LoginFailexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByLogin(Map<String, Object> paramMap) {
        User user =  userMapper.queryUserByLogin(paramMap);
        if(user==null){
            throw new LoginFailexception("用户账号或密码不正确！");
        }
        return user;
    }
}
