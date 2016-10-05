package com.ips.services;

import com.ips.dto.PositioningData;
import com.ips.dto.User;
import com.ips.services.api.PositioningDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Service
public class PositioningDataServiceImpl implements PositioningDataService {

    @Resource
    private PositioningDataService positioningDataService;

    @Override
    public void add(PositioningData positioningData) {
         positioningDataService.add(positioningData);
    }

    @Override
    public User load(int positioningDataId) {
        return positioningDataService.load(positioningDataId);
    }

    @Override
    public void delete(int positioningDataId) {
        positioningDataService.delete(positioningDataId);
    }

    @Override
    public void update(PositioningData positioningData) {
        positioningDataService.update(positioningData);
    }
}
