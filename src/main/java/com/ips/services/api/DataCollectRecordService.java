package com.ips.services.api;

import com.github.pagehelper.PageInfo;
import com.ips.dto.ApStringMac;
import com.ips.dto.DataCollectRecord;
import com.ips.dto.PositioningData;
import com.ips.dto.RadioSignalStrength;

import java.util.List;

/**
 * Created by shenwenbo on 2016/10/30.
 */
public interface DataCollectRecordService {

    public void  add(DataCollectRecord dataCollectRecord);

    public DataCollectRecord  load(int position);

    public void addApStringMac(ApStringMac apStringMac);

    public void deleteApStringMac();

    public List<ApStringMac> getApList();

    public List<DataCollectRecord> list();


    public List<PositioningData> list_byPosition(int pos);

    public PageInfo<DataCollectRecord> queryByPage(Integer pageIndex, Integer pageSize);


    public void delete(int reocderId);


}
