package com.xyk.dao;

import com.xyk.entity.StatisticsUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticsUserDao extends PagingAndSortingRepository<StatisticsUser,Long>,JpaSpecificationExecutor<StatisticsUser> {
    @Query("select su.id,su.person,su.iphone,su.address,su.createTime,su.platfrom from StatisticsUser  su ")
    public List<StatisticsUser> statisticsList();
    @Query(value = "INSERT INTO tb_statistics_user(person,iphone,address,create_time) values(?1,?2,?3,?4)",nativeQuery = true)
    void addStatisticsUser(String person, String iphone, String address, Date createTime);
}
