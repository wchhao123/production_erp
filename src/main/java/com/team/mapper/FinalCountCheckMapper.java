package com.team.mapper;

import com.team.bean.FinalCountCheck;
import com.team.bean.FinalCountCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}