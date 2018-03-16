package com.zheng.upms.dao.mapper;

import com.zheng.upms.dao.model.UpmsUserIp;
import com.zheng.upms.dao.model.UpmsUserIpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpmsUserIpMapper {
    long countByExample(UpmsUserIpExample example);

    int deleteByExample(UpmsUserIpExample example);

    int deleteByPrimaryKey(Integer usersipid);

    int insert(UpmsUserIp record);

    int insertSelective(UpmsUserIp record);

    List<UpmsUserIp> selectByExample(UpmsUserIpExample example);

    UpmsUserIp selectByPrimaryKey(Integer usersipid);

    int updateByExampleSelective(@Param("record") UpmsUserIp record, @Param("example") UpmsUserIpExample example);

    int updateByExample(@Param("record") UpmsUserIp record, @Param("example") UpmsUserIpExample example);

    int updateByPrimaryKeySelective(UpmsUserIp record);

    int updateByPrimaryKey(UpmsUserIp record);
}