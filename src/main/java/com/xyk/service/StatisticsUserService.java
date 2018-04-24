package com.xyk.service;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.StatisticsUser;

import java.util.Date;
import java.util.List;

public interface StatisticsUserService {
    /**
     * 查询联系人所有信息
     * @return
     */
    public Pageinfo<StatisticsUser> statisticsList(QueryParam param);
    /**
     * 添加联系人信息
     */
    void addStatisticsUser (String person, String iphone, String address, Date createTime);
}
