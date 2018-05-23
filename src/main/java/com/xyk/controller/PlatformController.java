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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/platform")
public class PlatformController extends BaseController{

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
     * 添加品牌
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(String jsonParam){
        PlatformConfig platform = JsonUtil.GSON.fromJson(jsonParam, PlatformConfig.class);
        if(StringUtil.isNull(platform.getPlatformName())){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"品牌名称不能为空");
        }
        if(StringUtil.isNull(platform.getWebsite())){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"品牌地址不能为空");
        }
        if(StringUtil.isNull(platform.getImage())){
            return  ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"上传图片不能为空");
        }
        platformConfigService.validatePlatformUnique(platform);
        platformConfigService.addPlatform(platform);
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
    public String updatePage(@RequestParam("id") String id, Model model){
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
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public  Result updatePlatform(String jsonParam){
        PlatformConfig platform = JsonUtil.GSON.fromJson(jsonParam, PlatformConfig.class);
        //获取修改后的品牌名称
        String newPlatformName = platform.getPlatformName();
        PlatformConfig oldPlatform = platformConfigDao.findPfById(platform.getId());
        //获取修改之前的品牌名称
        String oldPlatformName = oldPlatform.getPlatformName();
        PlatformConfig pfByName = platformConfigDao.findPfByName(platform.getPlatformName());
        if (newPlatformName.equals(oldPlatformName)){
            platformConfigService.updatePlatform(platform);
            return ResultUtil.success();
        }else if(platform==null ||newPlatformName.equals(pfByName.getPlatformName())){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"品牌不能为空或已存在请重新输入");
        }
        platformConfigService.updatePlatform(platform);
        return ResultUtil.success();
    }
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result deletePlatform(@RequestParam("pfIds[]") Integer[] pfIds){
        if(pfIds==null || pfIds.length==0){
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }
        platformConfigService.deletePlatformByIdS(pfIds);
        return ResultUtil.success();
    }

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    private Result uploadImage(@RequestParam("file") MultipartFile file,
                              HttpServletRequest request){
        String path = "/images/platform/";
        return super.uploadImage(file,request,path);
    }
}
