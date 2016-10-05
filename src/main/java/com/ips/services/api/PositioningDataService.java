package com.ips.services.api;

import com.ips.dto.PositioningData;
import com.ips.dto.User;

/**
 * Created by shenwenbo on 2016/10/4.
 */
public interface PositioningDataService {

    public void add(PositioningData positioningData);

    public User load(int positioningDataId);

    public void delete(int positioningDataId);

    public void update(PositioningData positioningData);

}
