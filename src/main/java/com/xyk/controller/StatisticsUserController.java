package com.xyk.controller;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.bean.Result;
import com.xyk.dao.PlatformConfigDao;
import com.xyk.dao.PlatformConfigDaoImpl;
import com.xyk.dao.StatisticsUserDao;
import com.xyk.entity.PlatformConfig;
import com.xyk.entity.StatisticsUser;
import com.xyk.service.StatisticsUserService;
import com.xyk.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/admin/statisticsUser")
public class StatisticsUserController {
    @Autowired
    StatisticsUserService statisticsUserService;
    @Autowired
    StatisticsUserDao statisticsUserDao;
    @Autowired
    PlatformConfigDaoImpl platformConfigDaoImpl;
    @Autowired
    PlatformConfigDao platformConfigDao;
    /**
     * 跳转到信息统计页面
     * @return
     */
    @RequestMapping(value = "/statisticsList",method = RequestMethod.GET)
    public String statisticsList(Model model){
        List<PlatformConfig> platformList = platformConfigDao.findPlatformList();
        model.addAttribute("platformList",platformList);
        return "admin/statisticsUser/list";
    }

    /**
     * 异步查询所有的联系人信息
     * @param param
     * @return
     */
    @RequestMapping(value = "/getStatisticsAll",method = RequestMethod.POST)
    @ResponseBody
    public Result getStatisticsAll(QueryParam param){
        Pageinfo<StatisticsUser> pageinfo = statisticsUserService.statisticsList(param);
        List<StatisticsUser> staUsers = pageinfo.getDataList();
        for (StatisticsUser staUser: staUsers){
            if(staUser.getId()>0){
                PlatformConfig plfo = platformConfigDao.findPfById(staUser.getPfId());
                if(plfo!=null){
                    staUser.setPlatformName(plfo.getPlatformName());
                }
            }
        }
        return ResultUtil.success(pageinfo);
    }


}
