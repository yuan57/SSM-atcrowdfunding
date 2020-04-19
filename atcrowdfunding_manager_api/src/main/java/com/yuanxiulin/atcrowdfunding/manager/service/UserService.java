package com.yuanxiulin.atcrowdfunding.manager.service;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.util.Page;

import java.util.Map;

public interface UserService {
    User queryUserByLogin(Map<String, Object> paramMap);

//    Page queryPage(Integer pageNo, Integer pageSize);

    Page queryPage(Map<String, Object> paramMap);

    int addUser(User user);

    User queryUserById(Integer id);

    int updateUser(User user);

    int deleteUserById(Integer id);

    int doDeleteUserBatch(Integer[] ids);
}
