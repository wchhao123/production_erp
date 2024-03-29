package com.team.mapper;

import com.team.bean.Device;
import com.team.bean.DeviceType;
import com.team.bean.DeviceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeMapper {
    long countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> selectDeviceTypeList(@Param("index") int index, @Param("pageSize") int pageSize);

    List<DeviceType> search_deviceType_by_condition(@Param("flag") int flag, @Param("condition") String condition);
}