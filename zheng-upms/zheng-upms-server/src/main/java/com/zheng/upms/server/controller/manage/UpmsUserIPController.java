package com.zheng.upms.server.controller.manage;

import com.alibaba.fastjson.JSONArray;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.zheng.common.base.BaseController;
import com.zheng.common.util.MD5Util;
import com.zheng.common.validator.LengthValidator;
import com.zheng.common.validator.NotNullValidator;
import com.zheng.upms.common.constant.UpmsResult;
import com.zheng.upms.common.constant.UpmsResultConstant;
import com.zheng.upms.dao.model.*;
import com.zheng.upms.rpc.api.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用户controller
 * Created by shuzheng on 2017/2/6.
 */
@Controller
@Api(value = "IP地址管理", description = "IP地址管理")
@RequestMapping("/manage/userip")
public class UpmsUserIPController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserIPController.class);

    @Autowired
    private UpmsUserIpService upmsUserIpService;

    @Autowired
    private UpmsUserService upmsUserService;

    @ApiOperation(value = "IP首页")
    @RequiresPermissions("upms:userip:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/userip/index.jsp";
    }

    @ApiOperation(value = "IP列表")
    @RequiresPermissions("upms:userip:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, defaultValue = "0", value = "userip4") String userip4,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order){
        UpmsUserIpExample upmsUserIpExample=new UpmsUserIpExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsUserIpExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsUserIpExample.or() .andUserip4EqualTo("%" + search + "%");
        }
        List<UpmsUserIp> rows = upmsUserIpService.selectByExampleForOffsetPage(upmsUserIpExample, offset, limit);
        long total = upmsUserIpService.countByExample(upmsUserIpExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @ApiOperation(value = "新增UserIp")
    @RequiresPermissions("upms:userip:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/manage/userip/create.jsp";
    }

    @ApiOperation(value = "新增UserIP")
    @RequiresPermissions("upms:userip:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsUserIp upmsUserIp) {
        ComplexResult result = FluentValidator.checkAll()
                .on(upmsUserIp.getUserip4(), new LengthValidator(1, 20,""))
                .doValidate()
                .result(ResultCollectors.toComplex());
        upmsUserIp.setCtime(new Date().getTime());
        upmsUserIpService.insertSelective(upmsUserIp);
        return new UpmsResult(UpmsResultConstant.SUCCESS, 1);
    }

    @ApiOperation(value = "删除IP地址")
    @RequiresPermissions("upms:userip:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        int count = upmsUserIpService.deleteByPrimaryKeys(ids);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }

    @ApiOperation(value = "修改IP地址")
    @RequiresPermissions("upms:userip:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsUserIp userip = upmsUserIpService.selectByPrimaryKey(id);
        modelMap.put("userip", userip);
        return "/manage/userip/update.jsp";
    }

    @ApiOperation(value = "修改IP地址")
    @RequiresPermissions("upms:userip:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id")  int id,UpmsUserIp upmsUserIp) {
//        ComplexResult result = FluentValidator.checkAll()
//                .on(upmsUserIp.getUserip4(), new LengthValidator(1, 20, "名称"))
//                .doValidate()
//                .result(ResultCollectors.toComplex());
//        if (!result.isSuccess()) {
//            return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
//        }
        upmsUserIp.setUsersipid(id);
        int count = upmsUserIpService.updateByPrimaryKeySelective(upmsUserIp);
        return new UpmsResult(UpmsResultConstant.SUCCESS, count);
    }
}