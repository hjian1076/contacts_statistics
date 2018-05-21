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
import java.io.File;
import java.util.UUID;

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
        if(platformConfigDao.findPfByName(platform.getPlatformName())!=null){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"品牌已存在请重新输入");
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

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ResponseBody
    private String fildUpload(@RequestParam(value="itemImagers",required=false) MultipartFile file,
                              HttpServletRequest request, Model model)throws Exception{
            //基本表单

            //获得物理路径webapp所在路径
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            String path="";
            if(!file.isEmpty()){
                //生成uuid作为文件名称
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                //获得文件类型（可以判断如果不是图片，禁止上传）
                String contentType=file.getContentType();
                //获得文件后缀名称
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                //地址
                path="/static/img/"+uuid+"."+imageName;
                file.transferTo(new File(pathRoot+path));
            }else {
                //可以使用以下包装类。响应结果，请看附件
                //ResponseResult.build(400,"上传图片失败");
            }
            System.out.println(path);
            request.setAttribute("imagesPath", path);
            model.addAttribute("imgPath",path);
            return path;
        }
}
