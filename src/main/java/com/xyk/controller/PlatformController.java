package com.xyk.controller;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.bean.Result;
import com.xyk.dao.PlatformConfigDao;
import com.xyk.entity.PlatformConfig;
import com.xyk.enums.ResultEnum;
import com.xyk.service.PlatformConfigService;
import com.xyk.util.JsonUtil;
import com.xyk.util.ResultUtil;
import com.xyk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/platform")
public class PlatformController {

    @Autowired
    PlatformConfigService platformConfigService;
    /**
     * 跳转到平台页面
     * @return
     */
    @RequestMapping(value = "/platformList")
    public String platformList(){
        return "/admin/platform/list";
    }
    @RequestMapping(value = "/getPlatformAll")
    @ResponseBody
    public Result queryPlatformList(QueryParam param){
        Pageinfo<PlatformConfig> platformList = platformConfigService.findPlatformList(param);
        return ResultUtil.success(platformList);
    }
    /**
     * 跳转到添加平台页面
     * @return
     */
    @RequestMapping(value = "/addList")
    public String add(){

        return "/admin/platform/addList";

    }
    /**
     * 添加平台
     * @param platformName 平台名称
     * @param website 平台地址
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(@RequestParam("platformName") String platformName,@RequestParam("website") String website){
        PlatformConfig pf = new PlatformConfig();
        pf.setPlatformName(platformName);
        pf.setWebsite(website);
        if(StringUtil.isNull(platformName)){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"平台名称不能为空");
        }
        if(StringUtil.isNull(website)){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"平台地址不能为空");
        }
        if(pf!=null){
            platformConfigService.addPlatform(pf);
        }
        return ResultUtil.success();
    }
}
