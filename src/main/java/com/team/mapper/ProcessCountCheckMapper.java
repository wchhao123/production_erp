package com.team.mapper;

import com.team.bean.ProcessCountCheck;
import com.team.bean.ProcessCountCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessCountCheckMapper {
    long countByExample(ProcessCountCheckExample example);

    int deleteByExample(ProcessCountCheckExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByExample(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);

    List<ProcessCountCheck> getPageProcessCountCheck();

    List<ProcessCountCheck> searchProcessCountCheckByCondition(@Param("searchValue") String s);
}