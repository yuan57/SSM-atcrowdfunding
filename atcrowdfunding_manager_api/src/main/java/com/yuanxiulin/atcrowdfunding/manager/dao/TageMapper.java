package com.yuanxiulin.atcrowdfunding.manager.dao;

import com.yuanxiulin.atcrowdfunding.bean.Tage;
import com.yuanxiulin.atcrowdfunding.bean.TageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TageMapper {
    long countByExample(TageExample example);

    int deleteByExample(TageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tage record);

    int insertSelective(Tage record);

    List<Tage> selectByExample(TageExample example);

    Tage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tage record, @Param("example") TageExample example);

    int updateByExample(@Param("record") Tage record, @Param("example") TageExample example);

    int updateByPrimaryKeySelective(Tage record);

    int updateByPrimaryKey(Tage record);
}