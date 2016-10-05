package com.ips.dao;

import com.ips.dto.PositioningData;
import com.ips.dto.User;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public interface PositioningDataDao {

    public void add(PositioningData psitioningData);

    public User load(int psitioningDataId);

    public void delete(int psitioningDataId);

    public void update(PositioningData psitioningData);

}
