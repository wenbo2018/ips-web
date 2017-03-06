package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.MapData;

/**
 * Created by shenwenbo on 2017/2/16.
 */
public interface MapDataService {

    /**
     * PositioningData 分页查询接口
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<MapData> queryByPage(Integer pageIndex, Integer pageSize);


    public void add(MapData mapData);

    public void delete(int mapId);
}
