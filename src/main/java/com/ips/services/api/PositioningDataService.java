package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.PositioningData;
import com.ips.dto.RssIData;
import com.ips.dto.User;

import java.util.List;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public interface PositioningDataService {

    public void add(PositioningData positioningData);

    public void addRssIData(RssIData rssIData);

    public User load(int positioningDataId);

    public void delete(int positioningDataId);

    public void update(PositioningData positioningData);

    /**
     * PositioningData 分页查询接口
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<PositioningData> queryByPage(Integer pageIndex, Integer pageSize);

    List<PositioningData> queryByPosition(int position);


    List<PositioningData> quertDistinct();



}
