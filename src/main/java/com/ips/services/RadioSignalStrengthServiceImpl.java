package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.RadioSignalStrengthDao;
import com.ips.dto.RadioSignalStrength;
import com.ips.dto.User;
import com.ips.services.api.RadioSignalStrengthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/15.
 */
@Service
public class RadioSignalStrengthServiceImpl implements RadioSignalStrengthService {
    @Resource
    private RadioSignalStrengthDao radioSignalStrengthDao;
    @Override
    public PageInfo<RadioSignalStrength> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?1:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<RadioSignalStrength> list = radioSignalStrengthDao.list();
        //用PageInfo对结果进行包装
        PageInfo<RadioSignalStrength> page = new PageInfo<RadioSignalStrength>(list);
        return page;
    }

    @Override
    public void delete(int id) {
        radioSignalStrengthDao.delete(id);
    }

    @Override
    public List<RadioSignalStrength> queryByPosition(int position) {
        return radioSignalStrengthDao.load(position);
    }

    @Override
    public List<RadioSignalStrength> quertDistinct() {
        return radioSignalStrengthDao.quertDistinct();
    }
}
