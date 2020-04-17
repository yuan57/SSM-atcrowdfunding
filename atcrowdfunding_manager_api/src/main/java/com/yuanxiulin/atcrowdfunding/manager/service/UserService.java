package com.yuanxiulin.atcrowdfunding.manager.service;

import com.yuanxiulin.atcrowdfunding.bean.User;

import java.util.Map;

public interface UserService {
    User queryUserByLogin(Map<String, Object> paramMap);
}
