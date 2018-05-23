package com.xyk.service;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.AdSpace;
import com.xyk.exception.UserRepeatException;

public interface AdSpaceService {
    /**
     * 查询广告位信息
     * @return
     */
    Pageinfo<AdSpace> findAdSpaceList(QueryParam param);
    /**
     * 添加平台
     * @param ad
     */
    void addAdSpace(AdSpace ad);
    /**
     * 修改信息
     */
    void updateAdSpace(AdSpace ad);
    /**
     * 删除
     */
    int deleteAdSpaceByIdS(Integer[] pfIds);
     /**
     * 验证广告位名字的唯一性
     * @param ad
     * @throws UserRepeatException
     */
    void validateAdSpaceUnique(AdSpace ad) throws UserRepeatException;
}
