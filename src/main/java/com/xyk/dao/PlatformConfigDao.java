package com.xyk.dao;

import com.xyk.entity.PlatformConfig;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface PlatformConfigDao extends PagingAndSortingRepository<PlatformConfig,Long>,JpaSpecificationExecutor<PlatformConfig>{
    @Modifying
    @Transactional
    @Query(value = "insert into tb_platform_config(platform_name,website,create_time) values (?1,?2,?3,?4,?5)",nativeQuery = true)
    void addPlatform(String platformName, String website, Date createTime,int staId);


}
