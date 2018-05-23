package com.xyk.service.impl;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.dao.AdSpaceDao;
import com.xyk.dao.AdSpaceDaoImpl;
import com.xyk.entity.AdSpace;
import com.xyk.exception.UserRepeatException;
import com.xyk.service.AdSpaceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Service
public class AdSpaceServiceImpl implements AdSpaceService {
    @PersistenceContext(unitName="backDataSource")
    private EntityManager em;
    @Autowired
    AdSpaceDaoImpl adSpaceDaoImpl;
    @Autowired
    AdSpaceDao adSpaceDao;
    private Logger logger = Logger.getLogger(AdSpaceServiceImpl.class);
    @Override
    public Pageinfo<AdSpace> findAdSpaceList(QueryParam param) {
        return adSpaceDaoImpl.findPlatformByPage(param);
    }

    /**
     * 修改信息
     * @param ad
     */
    @Override
    public void updateAdSpace(AdSpace ad) {
        ad.setCreateTime(new Date());
        adSpaceDao.save(ad);
    }

    /**
     * 删除
     * @param pfIds
     * @return
     */
    @Override
    public int deleteAdSpaceByIdS(Integer[] pfIds) {
        String del_sql = "DELETE ad FROM tb_ad_space ad where ad.id IN(";
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

    /**
     * 验证广告位名字的唯一性
     * @param ad
     * @throws UserRepeatException
     */
    @Override
    public void validateAdSpaceUnique(AdSpace ad) throws UserRepeatException {
        AdSpace oldAdSpace = new AdSpace();
        oldAdSpace = adSpaceDao.findAdSpaceByName(ad.getAdSpaceName());
        if(oldAdSpace!=null && oldAdSpace.getId()==ad.getId()){
            logger.error("广告位已存在："+ad.getAdSpaceName());
            throw new UserRepeatException("广告位已存在！！！");
        }
    }

    @Override
    public void addAdSpace(AdSpace ad) {
        ad.setCreateTime(new Date());
        adSpaceDao.save(ad);
    }
}
