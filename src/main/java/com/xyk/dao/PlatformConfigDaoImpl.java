package com.xyk.dao;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.PlatformConfig;
import com.xyk.util.DBHelperUtil;
import com.xyk.util.ObjectUtil;
import com.xyk.util.StringUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class PlatformConfigDaoImpl {
      @PersistenceContext(unitName = "backDataSource")
      private EntityManager em;
     /**
     * 根据id查找官网
     * @param pfId
     * @return
     */
     public PlatformConfig findPlatformById(int pfId){
        String sql = "select pf.website,pf.id,pf.platform_name from tb_platform_config pf  where pf.id = "+pfId;
        Query query = em.createNativeQuery(sql);
        List<Object[]> dataList = query.getResultList();
        PlatformConfig platform = null;
         for (Object[] obj:dataList) {
             platform = new PlatformConfig();
             platform.setWebsite(ObjectUtil.objectToString(obj[0]));
             platform.setId(ObjectUtil.objectToInt(obj[1]));
             platform.setPlatformName(ObjectUtil.objectToString(obj[2]));

         }
         return platform;
     }

}
