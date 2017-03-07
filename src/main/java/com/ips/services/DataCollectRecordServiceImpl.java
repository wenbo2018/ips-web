package com.ips.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ips.dao.ApStringMacDao;
import com.ips.dao.DataCollectRecordDao;
import com.ips.dao.PositioningDataDao;
import com.ips.dto.ApStringMac;
import com.ips.dto.DataCollectRecord;
import com.ips.dto.PositioningData;
import com.ips.dto.User;
import com.ips.services.api.DataCollectRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenwenbo on 2016/10/30.
 */
@Service
public class DataCollectRecordServiceImpl implements DataCollectRecordService {

    @Resource
    DataCollectRecordDao dataCollectRecordDao;

    @Resource
    ApStringMacDao apStringMacDao;


    @Resource
    PositioningDataDao positioningDataDao;



    @Override
    public void add(DataCollectRecord dataCollectRecord) {
        dataCollectRecordDao.add(dataCollectRecord);
    }

    @Override
    public DataCollectRecord load(int position) {
       return dataCollectRecordDao.load(position);
    }


    @Override
    public void addApStringMac(ApStringMac apStringMac) {
        apStringMacDao.addApStringMac(apStringMac);
    }
     @Override
    public void deleteApStringMac(){
        apStringMacDao.deleteApStringMac();
    }

    @Override
    public List<ApStringMac> getApList() {
        return apStringMacDao.list();
    }

    @Override
    public List<DataCollectRecord> list() {
        List<DataCollectRecord> list=new ArrayList<DataCollectRecord>();
        list=dataCollectRecordDao.list();
        return list;
    }

    @Override
    public List<PositioningData> list_byPosition(int pos) {
        return positioningDataDao.list_byPosition(pos);
    }

    @Override
    public PageInfo<DataCollectRecord> queryByPage(Integer pageIndex, Integer pageSize) {
        pageIndex = pageIndex == null?0:pageIndex;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        List<DataCollectRecord> list = dataCollectRecordDao.list();
        //用PageInfo对结果进行包装
        PageInfo<DataCollectRecord> page = new PageInfo<DataCollectRecord>(list);
        return page;
    }

    @Override
    public void delete(int reocderId) {
        dataCollectRecordDao.delete(reocderId);
    }

    @Override
    public void update(DataCollectRecord dataCollectRecord) {
        dataCollectRecordDao.update(dataCollectRecord);
    }
}
