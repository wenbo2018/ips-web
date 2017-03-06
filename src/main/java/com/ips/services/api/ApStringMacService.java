package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.ApStringMac;
import com.ips.dto.User;

/**
 * Created by shenwenbo on 2017/2/16.
 */
public interface ApStringMacService {
    /**
     * PositioningData 分页查询接口
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ApStringMac> queryByPage(Integer pageIndex, Integer pageSize);

    public void delete(int apId);
}
