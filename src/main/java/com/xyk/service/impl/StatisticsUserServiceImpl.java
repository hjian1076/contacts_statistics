package com.xyk.service.impl;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.dao.StatisticsUserDao;
import com.xyk.dao.StatisticsUserDaoImpl;
import com.xyk.entity.StatisticsUser;
import com.xyk.exception.UserRepeatException;
import com.xyk.service.StatisticsUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatisticsUserServiceImpl implements StatisticsUserService {

    private Logger logger = Logger.getLogger(StatisticsUserServiceImpl.class);
    @Autowired
    StatisticsUserDaoImpl statisticsUserDaoImpl;
    @Autowired
    StatisticsUserDao statisticsUserDao;
    @Override
    public Pageinfo<StatisticsUser> statisticsList(QueryParam param) {
        return statisticsUserDaoImpl.findStatisticsByPage(param);
    }

    /**
     * 添加联系信息
     * @param staUser
     */
    @Override
    public void addStatisticsUser(StatisticsUser staUser) {
        Date createTime = new Date();
        staUser.setCreateTime(createTime);
        statisticsUserDao.save(staUser);
    }

    /**
     * 验证联系人信息的唯一性
     * @param staUser
     * @throws UserRepeatException
     */
    @Override
    public void validateStaUserUnique(StatisticsUser staUser) throws UserRepeatException {
        StatisticsUser oldStaUser = null;
        oldStaUser = statisticsUserDao.findStaUserByIphone(staUser.getIphone());
        if(oldStaUser!=null && oldStaUser.getId()==staUser.getId()){
            logger.error("手机号码已经存在："+staUser.getIphone());
            throw new UserRepeatException("手机号码已存在！！！");
        }
        StatisticsUser oldStaUser1 = null;
        statisticsUserDao.findStaUserByPerson(staUser.getPerson());
        if(oldStaUser!=null && oldStaUser.getId()==oldStaUser1.getId()){
             logger.error("联系人已经存在："+staUser.getPerson());
            throw new UserRepeatException("联系人已存在！！！");
        }
    }
}
