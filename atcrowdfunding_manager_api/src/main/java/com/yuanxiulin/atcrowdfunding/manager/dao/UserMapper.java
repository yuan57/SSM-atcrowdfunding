package com.yuanxiulin.atcrowdfunding.manager.dao;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUserByLogin(Map<String, Object> paramMap);

    List<User> queryList(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    Integer queryCount();
}