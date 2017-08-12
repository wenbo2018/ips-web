package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.RadioSignalStrength;

import java.util.List;

/**
 * Created by shenwenbo on 2017/2/15.
 */
public interface RadioSignalStrengthService {
    /**
     * PositioningData 分页查询接口
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<RadioSignalStrength> queryByPage(Integer pageIndex, Integer pageSize);

    public void delete(int id);

    List<RadioSignalStrength> queryByPosition(int position);


    List<RadioSignalStrength> quertDistinct();
}
