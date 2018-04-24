package com.xyk.dao;

import com.xyk.entity.PageRes;
import com.xyk.util.DBHelperUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PageResDaoImpl {
    @PersistenceContext(unitName = "backDataSource")
    private EntityManager em;

    /**
     * 根据userId查询用户的权限
     * @return
     */
    public List<PageRes> findResByUserId(){
        String sql = "SELECT pr.id,pr.res_name,pr.res_type,pr.res_url,pr.show_menu,pr.parent_res_id from tb_page_res pr  ";
        Query query = em.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();
        List<PageRes> pageResList = null;
        try {
            pageResList = DBHelperUtil.fillDataInfo(rows,PageRes.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  pageResList;
    }
}
