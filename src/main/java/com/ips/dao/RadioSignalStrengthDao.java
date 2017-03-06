package com.ips.dao;

import com.ips.dto.PositioningData;
import com.ips.dto.RadioSignalStrength;
import java.util.List;

/**
 * Created by shenwenbo on 2016/12/23.
 */
public interface RadioSignalStrengthDao {

    public void  add(RadioSignalStrength radioSignalStrength);

    public List<RadioSignalStrength> load(int Cin);

    public List<RadioSignalStrength> list();

    public void delete(int id);


    List<RadioSignalStrength> quertDistinct();


}
