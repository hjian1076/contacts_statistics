package com.xyk.dao;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.StatisticsUser;
import com.xyk.util.DBHelperUtil;
import com.xyk.util.StringUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class StatisticsUserDaoImpl {
    @PersistenceContext(unitName = "backDataSource")
    private EntityManager em;

    /**
     * 分页条件查询信息
     * @param param
     * @return
     */
    public Pageinfo<StatisticsUser> findStatisticsByPage(QueryParam param){
        Pageinfo<StatisticsUser> pageinfo = new Pageinfo<>();
        String sql = "select tsu.id,tsu.person,tsu.iphone,tsu.address,tsu.birth_date,tsu.create_time,tpf.platform_name from tb_statistics_user tsu left join tb_platform_config tpf on tsu.pf_id=tpf.id  where 1=1  ";
        String count_sql = "select count(tsu.id) from tb_statistics_user tsu left join tb_platform_config tpf on tsu.pf_id=tpf.id  where 1=1  ";
        //开始时间
        //boolean oneDay = beginTime.equals(endTime);//判断是否是一天
        if(param.getPfId()>0){
            sql +=" AND tsu.pf_id = " + param.getPfId();
            count_sql += " AND tsu.pf_id = " + param.getPfId();
        }
        if(!StringUtil.isNull(param.getKeyword())){
            String keyword = StringEscapeUtils.escapeSql(param.getKeyword());
            sql += " AND locate ('"+keyword+"',tsu.person)";
            count_sql += " AND locate ('"+keyword+"',tsu.person)";
        }

        if(!StringUtil.isNull(param.getBeginTime())){
            String beginTime = StringEscapeUtils.escapeSql(param.getBeginTime());
            beginTime += " 00:00:00";
            sql += " AND tsu.create_time >= '"+beginTime+"'";
        }
        if(!StringUtil.isNull(param.getEndTime())){
            String  endTime = StringEscapeUtils.escapeSql(param.getEndTime());
            endTime += " 23:59:59";
            sql += " AND tsu.create_time <= '"+endTime+"'";
            count_sql += " AND tsu.create_time >= '"+endTime+"'";
        }
        sql += " ORDER BY tsu.create_time DESC";
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
            list = DBHelperUtil.fillDataInfo(rows,StatisticsUser.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pageinfo.setDataList(list);
        return  pageinfo;
    }

//    /**
//     * 保存联系信息
//     * @param id
//     */
//    public void addStaUserById(int id){
//        String sql = "insert into tb_statistics_user tsu tsu.person,tsu.iphone,tsu.address values"
//    }
}
