package com.xyk.dao;

import com.xyk.entity.PlatformConfig;
import com.xyk.entity.StatisticsUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface PlatformConfigDao extends PagingAndSortingRepository<PlatformConfig,Long>,JpaSpecificationExecutor<PlatformConfig>{
    @Query(value = "select pf.* from tb_platform_config pf left join tb_statistics_user stu on pf.id = stu.pf_id where stu.pf_id = ?1",nativeQuery = true)
    PlatformConfig findPfById(int pfId);
    /**
     * 查询所有信息
     */
    @Query("select pf from  PlatformConfig pf")
    List<PlatformConfig> findPlatformList();
}
