package com.team.mapper;

import com.team.bean.Material;
import com.team.bean.MaterialReceive;
import com.team.bean.MaterialReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialReceiveMapper {
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> queryMaterialReceive();

    List<MaterialReceive> searchMaterialByCondition(@Param("flag")int flag , @Param("searchValue") String searchValue);
}