package com.xyk.service;

import com.xyk.bean.Pageinfo;
import com.xyk.bean.QueryParam;
import com.xyk.entity.PlatformConfig;

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
}
