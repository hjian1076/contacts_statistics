package com.xyk.controller;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.bean.Result;
import com.xyk.dao.AdSpaceDao;
import com.xyk.entity.AdSpace;
import com.xyk.enums.ResultEnum;
import com.xyk.service.AdSpaceService;
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
@RequestMapping("/admin/adSpace")
public class AdSpaceController extends BaseController{
    @Autowired
    AdSpaceService adSpaceService;
    @Autowired
    AdSpaceDao adSpaceDao;
    @RequestMapping("/adSpaceList")
    public String adSpaceList(){
        return "/admin/adSpace/list";
    }

    /**
     * 异步查询广告位信息列表
     * @param param
     * @return
     */
    @RequestMapping("/getAdSpaceAll")
    @ResponseBody
    public Result getAdSpaceAll(QueryParam param){
        Pageinfo<AdSpace> adSpaceList = adSpaceService.findAdSpaceList(param);
        return ResultUtil.success(adSpaceList);
    }
     /**
     * 跳转到添加广告位页面
     * @return
     */
    @RequestMapping(value = "/addList")
    public String add(){

        return "/admin/adSpace/addList";

    }
    /**
     * 添加广告位
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(String jsonParam){
        AdSpace adSpace = JsonUtil.GSON.fromJson(jsonParam, AdSpace.class);
        if(StringUtil.isNull(adSpace.getAdSpaceName())){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"广告位名称不能为空");
        }
        if(StringUtil.isNull(adSpace.getImage())){
            return  ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"上传图片不能为空");
        }
        adSpaceService.validateAdSpaceUnique(adSpace);
        adSpaceService.addAdSpace(adSpace);
        return ResultUtil.success();
    }

    /**
     *
     * 修改广告位信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updatePage")
    public String updatePage(@RequestParam("id") String id, Model model){
        int pfId = Integer.valueOf(id);
        AdSpace adSpace = adSpaceDao.findAdSpaceById(pfId);
        model.addAttribute("adSpace",JsonUtil.toJsonByGson(adSpace));
        model.addAttribute("update",6);
        return "/admin/adSpace/addList";
    }

    /**
     * 修改信息
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public  Result updatePlatform(String jsonParam){
        AdSpace adSpace = JsonUtil.GSON.fromJson(jsonParam, AdSpace.class);
        //获取修改后的品牌名称
        String newAdSpaceName = adSpace.getAdSpaceName();
        AdSpace oldAdSpace = adSpaceDao.findAdSpaceById(adSpace.getId());
        //获取修改之前的品牌名称
        String oldAdSpaceName = oldAdSpace.getAdSpaceName();
        AdSpace adSpaceByName =adSpaceDao.findAdSpaceByName(adSpace.getAdSpaceName());
        if (adSpaceByName==null){
            adSpaceService.updateAdSpace(adSpace);
            return ResultUtil.success();
        }
        if (newAdSpaceName.equals(oldAdSpaceName)){
            adSpaceService.updateAdSpace(adSpace);
            return ResultUtil.success();
        }else if(adSpace==null ||newAdSpaceName.equals(adSpaceByName.getAdSpaceName())){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"广告位不能为空或已存在请重新输入");
        }

        return ResultUtil.success();
    }

    /**
     * 删除
     * @param pfIds
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result deletePlatform(@RequestParam("pfIds[]") Integer[] pfIds){
        if(pfIds==null || pfIds.length==0){
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }
        adSpaceService.deleteAdSpaceByIdS(pfIds);
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
        String path = "/images/adSpace/";
        return super.uploadImage(file,request,path);
    }
}
