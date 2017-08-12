package com.ips.dao;

import com.ips.dto.DataCollectRecord;

import java.util.List;

/**
 * Created by shenwenbo on 2016/10/30.
 */
public interface DataCollectRecordDao {

    public void  add(DataCollectRecord dataCollectRecord);

    public DataCollectRecord  load(int position);


    public List<DataCollectRecord> list();


    public  void delete(int recoderId);

    void update(DataCollectRecord dataCollectRecord);
}
