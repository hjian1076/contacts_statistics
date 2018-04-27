package com.xyk.service;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.PlatformConfig;
import com.xyk.exception.UserRepeatException;

import java.util.List;

public interface PlatformConfigService {
    /**
     * 添加平台
     * @param pf
     */
    void addPlatform(PlatformConfig pf);

    /**
     * 查询平台信息
     * @return
     */
    Pageinfo<PlatformConfig> findPlatformList(QueryParam param);
    /**
     * 修改信息
     */
    void updatePlatform(PlatformConfig pf);

    /**
     * 验证品牌名字的唯一性
     * @param staUser
     * @throws UserRepeatException
     */
    void validatePlatformUnique(PlatformConfig staUser) throws UserRepeatException;

    /**
     * 删除
     */
    int deletePlatformByIdS(Integer[] pfIds);
}
