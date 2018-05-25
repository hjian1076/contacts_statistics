package com.xyk.dao;

import com.xyk.entity.AdSpace;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface AdSpaceDao extends PagingAndSortingRepository<AdSpace,Integer>,JpaSpecificationExecutor<AdSpace> {
    @Query(value = "select ad.* from tb_ad_space ad  where ad.id = ?1",nativeQuery = true)
    AdSpace findAdSpaceById(int id);

    /**
     * 根据广告位名字查找
     */
    @Query(value = "select ad.* from tb_ad_Space ad   where ad.adSpace_name=?1",nativeQuery = true)
    AdSpace findAdSpaceByName(String adSpaceName);
}
