package com.ips.services.api;

import com.ips.dto.RadioSignalStrength;

/**
 * Created by shenwenbo on 2016/12/23.
 */
public interface LbsService {

    public int lbsLocation(RadioSignalStrength radioSignalStrength,int k);
    public void addCache(RadioSignalStrength radioSignalStrength);

}
