package com.zheng.upms.rpc.service.impl;

import com.zheng.common.annotation.BaseService;
import com.zheng.common.base.BaseServiceImpl;
import com.zheng.upms.dao.mapper.UpmsUserIpMapper;
import com.zheng.upms.dao.model.UpmsUserIp;
import com.zheng.upms.dao.model.UpmsUserIpExample;
import com.zheng.upms.rpc.api.UpmsUserIpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserIpService实现
* Created by shuzheng on 2018/3/16.
*/
@Service
@Transactional
@BaseService
public class UpmsUserIpServiceImpl extends BaseServiceImpl<UpmsUserIpMapper, UpmsUserIp, UpmsUserIpExample> implements UpmsUserIpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserIpServiceImpl.class);

    @Autowired
    UpmsUserIpMapper upmsUserIpMapper;

}