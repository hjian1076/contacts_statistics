package com.xyk.dao;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.PlatformConfig;
import com.xyk.entity.StatisticsUser;
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
     /**
     * 分页条件查询信息
     * @param param
     * @return
     */
    public Pageinfo<PlatformConfig> findPlatformByPage(QueryParam param){
        Pageinfo<PlatformConfig> pageinfo = new Pageinfo<>();
        String sql = "select tpf.id,tpf.platform_name,tpf.website,tpf.create_time from tb_platform_config tpf  ";
        String count_sql = "select count(tpf.id) from tb_platform_config tpf   ";
        sql += " ORDER BY tpf.create_time DESC";
        //判断分页条件是否为空
        if(param.getOffset()!=null && param.getLimit() != null){
            sql += " limit "+ param.getOffset()+","+param.getLimit();
        }
        Query query = em.createNativeQuery(count_sql);
        int count = Integer.parseInt(query.getResultList().get(0).toString());
        pageinfo.setTotalSize(count);//总数据条数

        query = em.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();
        List list = null;
        try {
            list = DBHelperUtil.fillDataInfo(rows,PlatformConfig.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pageinfo.setDataList(list);
        return  pageinfo;
    }
}
