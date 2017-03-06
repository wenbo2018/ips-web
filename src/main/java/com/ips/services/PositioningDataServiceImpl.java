package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.PositioningDataDao;
import com.ips.dao.RssIDataDao;
import com.ips.dto.PositioningData;
import com.ips.dto.RssIData;
import com.ips.dto.User;
import com.ips.services.api.PositioningDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Service
public class PositioningDataServiceImpl implements PositioningDataService {

    @Resource
    PositioningDataDao positioningDataDao;
    @Resource
    RssIDataDao rssIDataDao;

    @Override
    public void add(PositioningData positioningData) {
       positioningDataDao.add(positioningData);
    }

    @Override
    public void addRssIData(RssIData rssIData) {
        rssIDataDao.addRssIData(rssIData);
    }

    @Override
    public User load(int positioningDataId) {
        return null;
    }

    @Override
    public void delete(int positioningDataId) {

    }

    @Override
    public void update(PositioningData positioningData) {

    }

    @Override
    public PageInfo<PositioningData> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?1:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<PositioningData> list = positioningDataDao.list();
        //用PageInfo对结果进行包装
        PageInfo<PositioningData> page = new PageInfo<PositioningData>(list);
        return page;
    }

    @Override
    public List<PositioningData> queryByPosition(int position) {
        return  positioningDataDao.list_byPosition(position);
    }

    @Override
    public List<PositioningData> quertDistinct() {
        return positioningDataDao.quertDistinct();
    }
}
