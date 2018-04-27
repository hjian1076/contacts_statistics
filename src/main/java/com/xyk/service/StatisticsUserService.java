package com.xyk.service;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.StatisticsUser;
import com.xyk.exception.UserRepeatException;

import java.util.Date;
import java.util.List;

public interface StatisticsUserService {
    /**
     * 查询联系人所有信息
     * @return
     */
    Pageinfo<StatisticsUser> statisticsList(QueryParam param);
    /**
     * 添加联系人信息
     */
    void addStatisticsUser (StatisticsUser staUser);

    //验证user的唯一性
    void validateStaUserUnique(StatisticsUser staUser) throws UserRepeatException;
}
