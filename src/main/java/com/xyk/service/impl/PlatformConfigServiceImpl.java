package com.xyk.service.impl;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.dao.PlatformConfigDao;
import com.xyk.dao.PlatformConfigDaoImpl;
import com.xyk.entity.PlatformConfig;
import com.xyk.service.PlatformConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Date;
import java.util.List;

@Service
public class PlatformConfigServiceImpl implements PlatformConfigService {
    @Autowired
    PlatformConfigDao platformConfigDao;
    @Autowired
    PlatformConfigDaoImpl platformConfigDaoImpl;
    @Override
    public void addPlatform(PlatformConfig pf) {
        Date createTime = new Date();
        pf.setCreateTime(createTime);
        platformConfigDao.save(pf);
    }

    @Override
    public Pageinfo<PlatformConfig> findPlatformList(QueryParam param) {
        Pageinfo<PlatformConfig> platformByPage = platformConfigDaoImpl.findPlatformByPage(param);
        return platformByPage;
    }
}
