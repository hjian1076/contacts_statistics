package com.xyk.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
import org.springframework.stereotype.Repository;
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
    @Autowired
    PlatformConfigDao platformConfigDao;
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

    /**
     *
     * 修改品牌信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updatePage")
    public String updatePage(String id, Model model){
        int pfId = Integer.valueOf(id);
        PlatformConfig platform = platformConfigDao.findPfById(pfId);
        model.addAttribute("platform",JsonUtil.toJsonByGson(platform));
        model.addAttribute("update",6);
        return "/admin/platform/addList";
    }

    /**
     * 修改信息
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public  Result updatePlatform(String jsonParam){
        PlatformConfig platform = JsonUtil.GSON.fromJson(jsonParam, PlatformConfig.class);
        if(platform == null) return ResultUtil.error(ResultEnum.PARAM_ERROR);
        platformConfigService.updatePlatform(platform);
        return ResultUtil.success();
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result deletePlatform(@RequestParam("pfId") String pfId){
        if(StringUtil.isNull(pfId)){
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }
        int id = Integer.valueOf(pfId);
        platformConfigDao.deletePlatformById(id);
        return ResultUtil.success();
    }
}
