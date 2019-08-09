package com.team.mapper;

import com.team.bean.COrder;
import com.team.bean.COrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface COrderMapper {
    long countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    /*pageOrders*/
    List<COrder> getPageCOrder(@Param("index") int index, @Param("pageSize") int pageSize);

    //批删除
    int batchDeleteByIds(@Param("ids") String[] ids);

    //条件查询
    List<COrder> searchOrderByCondition(@Param("flag") int flag,@Param("searchValue") String searchValue);
}