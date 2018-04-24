package com.xyk.dao;

import com.xyk.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends PagingAndSortingRepository<User,Long>,JpaSpecificationExecutor<User> {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Query("select  u from  User u where  u.username=?1 AND  u.password=?2")
    public User findUserByUsernameAndPwd(String username,String password);
    /**
     * 修改密码
     */
    @Modifying
    @Transactional
    @Query("update User u SET u.password=?1 where u.id=?2" )
    public void updatePassword(String password,long id);
}
