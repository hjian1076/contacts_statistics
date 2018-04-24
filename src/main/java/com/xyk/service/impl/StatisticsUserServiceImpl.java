package com.xyk.service.impl;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.dao.StatisticsUserDao;
import com.xyk.dao.StatisticsUserDaoImpl;
import com.xyk.entity.StatisticsUser;
import com.xyk.service.StatisticsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticsUserServiceImpl implements StatisticsUserService {
    @Autowired
    StatisticsUserDaoImpl statisticsUserDaoImpl;
    @Autowired
    StatisticsUserDao statisticsUserDao;
    @Override
    public Pageinfo<StatisticsUser> statisticsList(QueryParam param) {
        return statisticsUserDaoImpl.findStatisticsByPage(param);
    }

    @Override
    public void addStatisticsUser(String person, String iphone, String address, Date createTime) {
        statisticsUserDao.addStatisticsUser(person,iphone,address,createTime);
    }
}
