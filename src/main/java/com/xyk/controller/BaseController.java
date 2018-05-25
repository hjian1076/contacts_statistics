package com.xyk.controller;


import com.xyk.bean.Result;
import com.xyk.entity.User;
import com.xyk.enums.ResultEnum;
import com.xyk.util.ResultUtil;
import com.xyk.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class BaseController {
     /**
     * 获取当前登录的USER
     * @return
     */
    protected User getNowUser(){
        return (User)getSession().getAttribute("user");
    }
     public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
            System.out.println("getSession error...");
        }
        return session;
    }
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }

    /**
     * 上传文件
     * @param file 上传的文件
     * @param request 请求参数
     * @param path 存储的部分路径
     * @return
     */
    public Result uploadImage(MultipartFile file,HttpServletRequest request,String path){
//        //判断文件是否为空
        if(file.isEmpty()){
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        }
        //获取文件的原始文件名
        String originalFilename = "." + file.getOriginalFilename().split("\\.")[1];
        String realPath = request.getSession().getServletContext().getRealPath(path);//获取文件的真实文件名
        File f = new File(realPath);
        //判断路径下的文件是否存在
        if (!f.exists())
            //不存在则创建路径名指定的目录
            f.mkdir();

        String imageName = System.currentTimeMillis()+ StringUtil.createRandom(true,3)+originalFilename;
        String imageFilePath = realPath + "/" + imageName;
        try {
              //将接收到的文件传输到指定的目标文件
            file.transferTo(new File(imageFilePath));
        } catch (Exception e) {
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
        String imageUrl = path + imageName;
        return ResultUtil.success(imageUrl);
    }
}
