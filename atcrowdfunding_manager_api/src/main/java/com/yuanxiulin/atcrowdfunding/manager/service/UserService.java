package com.yuanxiulin.atcrowdfunding.manager.service;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.util.Page;

import java.util.Map;

public interface UserService {
    User queryUserByLogin(Map<String, Object> paramMap);

    Page queryPage(Integer pageNo, Integer pageSize);
}
