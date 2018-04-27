package com.xyk.service.impl;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.dao.PlatformConfigDao;
import com.xyk.dao.PlatformConfigDaoImpl;
import com.xyk.dao.UserDao;
import com.xyk.entity.PlatformConfig;
import com.xyk.exception.UserRepeatException;
import com.xyk.service.PlatformConfigService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class PlatformConfigServiceImpl implements PlatformConfigService {
     @PersistenceContext(unitName="backDataSource")
    private EntityManager em;

    @Autowired
    PlatformConfigDao platformConfigDao;
    @Autowired
    PlatformConfigDaoImpl platformConfigDaoImpl;
     private Logger logger = Logger.getLogger(PlatformConfigServiceImpl.class);
    /**
     * 添加
     * @param pf
     */
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

    /**
     * 修改
     * @param pf
     */
    @Override
    public void updatePlatform(PlatformConfig pf) {
        pf.setCreateTime(new Date());
        platformConfigDao.save(pf);
    }
    /**
     * 验证联系人信息的唯一性
     * @param pf
     * @throws UserRepeatException
     */
    @Override
    public void validatePlatformUnique(PlatformConfig pf) throws UserRepeatException {
        PlatformConfig oldPlatform = new PlatformConfig();
        oldPlatform = platformConfigDao.findPfByName(pf.getPlatformName());
        if(oldPlatform!=null && oldPlatform.getId()==pf.getId()){
            logger.error("品牌已存在："+pf.getPlatformName());
            throw new UserRepeatException("品牌已存在！！！");
        }
    }

    /**
     * 删除
     * @param pfIds
     * @return
     */
     @Transactional
    @Override
    public int deletePlatformByIdS(Integer[] pfIds) {
        String del_sql = "DELETE pf FROM tb_platform_config pf where pf.id IN(";
        for(int i=0;i<pfIds.length;i++){
            if(i>0){
                del_sql+=",";
            }
            del_sql+=pfIds[i];
        }
        del_sql+=")";
       Query query =  em.createNativeQuery(del_sql);
        int i = query.executeUpdate();
        return i;
    }
}
