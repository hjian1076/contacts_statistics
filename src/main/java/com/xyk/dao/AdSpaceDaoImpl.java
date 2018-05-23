package com.xyk.dao;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.AdSpace;
import com.xyk.util.DBHelperUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AdSpaceDaoImpl {
      @PersistenceContext(unitName = "backDataSource")
      private EntityManager em;
    /**
     * 分页条件查询信息
     * @param param
     * @return
     */
      public Pageinfo<AdSpace> findPlatformByPage(QueryParam param){
            Pageinfo<AdSpace> pageinfo = new Pageinfo<>();
            String sql = "select tas.id,tas.adSpace_name,tas.create_time from tb_ad_space tas  ";
            String count_sql = "select count(tas.id) from tb_ad_space tas   ";
            sql += " ORDER BY tas.create_time DESC";
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
                list = DBHelperUtil.fillDataInfo(rows,AdSpace.class);
            }catch (Exception e){
                e.printStackTrace();
            }
            pageinfo.setDataList(list);
            return  pageinfo;
        }
}
