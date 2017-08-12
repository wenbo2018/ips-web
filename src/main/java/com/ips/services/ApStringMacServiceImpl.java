package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.ApStringMacDao;
import com.ips.dto.ApStringMac;
import com.ips.services.api.ApStringMacService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/16.
 */
@Service
public class ApStringMacServiceImpl implements ApStringMacService {

    @Resource
    private ApStringMacDao apStringMacDao;

    @Override
    public PageInfo<ApStringMac> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?0:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<ApStringMac> list = apStringMacDao.list();
        //用PageInfo对结果进行包装
        PageInfo<ApStringMac> page = new PageInfo<ApStringMac>(list);
        return page;
    }

    @Override
    public void delete(int apId) {
        apStringMacDao.delete(apId);
    }
}
