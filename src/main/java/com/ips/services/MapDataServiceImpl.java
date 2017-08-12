package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.MapDataDao;
import com.ips.dto.MapData;
import com.ips.dto.User;
import com.ips.services.api.MapDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shenwenbo on 2017/2/16.
 */
@Service
public class MapDataServiceImpl implements MapDataService {

    @Resource
    private MapDataDao mapDataDao;

    @Override
    public PageInfo<MapData> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?0:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<MapData> list = mapDataDao.list();
        //用PageInfo对结果进行包装
        PageInfo<MapData> page = new PageInfo<MapData>(list);
        return page;
    }

    @Override
    public void add(MapData mapData) {
        mapDataDao.add(mapData);
    }

    @Override
    public void delete(int mapId) {
        mapDataDao.delete(mapId);
    }
}
