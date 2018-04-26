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
    @Query(value = "select pf.* from tb_platform_config pf  where pf.id = ?1",nativeQuery = true)
    PlatformConfig findPfById(int pfId);
    /**
     * 查询所有信息
     */
    @Query(value = "select pf.* from  tb_platform_config pf",nativeQuery = true)
    List<PlatformConfig> findPlatformList();
//    /**
//     * 添加平台信息
//     */
//    @Query(value = "insert into tb_platform_config(platform_name,website,create_time) values(?1,?2,?3)",nativeQuery = true)
//    void addPlatform(String platformName,String website,Date createTime);
}
