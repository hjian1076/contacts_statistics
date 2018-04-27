package com.xyk.dao;

import com.xyk.entity.PlatformConfig;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlatformConfigDao extends PagingAndSortingRepository<PlatformConfig,Integer>,JpaSpecificationExecutor<PlatformConfig>{
    @Query(value = "select pf.* from tb_platform_config pf  where pf.id = ?1",nativeQuery = true)
    PlatformConfig findPfById(int pfId);
    /**
     * 查询所有信息
     */
    @Query(value = "select pf.* from  tb_platform_config pf",nativeQuery = true)
    List<PlatformConfig> findPlatformList();

    /**
     * 根据品牌名字查找
     */
    @Query(value = "select pf.* from tb_platform_config pf   where pf.platform_name=?1",nativeQuery = true)
    PlatformConfig findPfByName(String platformName);
}
