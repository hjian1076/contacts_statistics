package com.xyk.dao;

import com.xyk.entity.PageRes;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageResDao extends PagingAndSortingRepository<PageRes,Integer>,JpaSpecificationExecutor<PageRes>{

}
