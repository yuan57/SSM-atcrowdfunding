package com.yuanxiulin.atcrowdfunding.manager.service.impl;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.manager.dao.UserMapper;
import com.yuanxiulin.atcrowdfunding.manager.service.UserService;
import com.yuanxiulin.atcrowdfunding.util.MD5Util;
import com.yuanxiulin.atcrowdfunding.util.Page;
import com.yuanxiulin.atcrowdfunding.util.exception.LoginFailexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    @Override
    public Page queryPage(Map<String, Object> paramMap) {

        Integer pageNo = (Integer) paramMap.get("pageNo");
        Integer pageSize = (Integer) paramMap.get("pageSize");
        Page page = new Page(pageNo,pageSize);
        Integer startIndex = page.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<User> data = userMapper.queryList(paramMap);
        page.setData(data);
        Integer totalSize = userMapper.queryCount(paramMap);
        page.setTotalSize(totalSize);
        return page;
    }

    @Override
    public int addUser(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createtime = sdf.format(new Date());
        user.setCreatetime(createtime);
        user.setUserpswd(MD5Util.digest("123456"));
        int count = userMapper.insert(user);
        return count;
    }

    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int doDeleteUserBatch(Integer[] ids) {
        int count = 0;
        for(Integer id:ids){
            int i = userMapper.deleteByPrimaryKey(id);
            count++;
        }
        return count;
    }

    /*@Override
    public Page queryPage(Integer pageNo, Integer pageSize) {
        Page page = new Page(pageNo,pageSize);
        Integer startIndex = page.getStartIndex();
        List<User> data = userMapper.queryList(startIndex,pageSize);
        page.setData(data);
        Integer totalSize = userMapper.queryCount();
        page.setTotalSize(totalSize);
        return page;
    }*/
}
