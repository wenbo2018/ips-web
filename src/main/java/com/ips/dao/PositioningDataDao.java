package com.ips.dao;

import com.ips.dto.PositioningData;
import com.ips.dto.User;

import java.util.List;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public interface PositioningDataDao {

    public void add(PositioningData psitioningData);

    public List<PositioningData> list();

    public List<PositioningData> list_byPosition(int pos);

    List<PositioningData> quertDistinct();
}
