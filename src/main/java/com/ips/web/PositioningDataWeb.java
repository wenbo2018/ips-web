package com.ips.web;

import com.google.gson.Gson;
import com.ips.dao.RadioSignalStrengthDao;
import com.ips.dto.*;
import com.ips.services.api.DataCollectRecordService;
import com.ips.services.api.PositioningDataService;
import com.ips.util.MapUtils;
import com.sun.org.apache.bcel.internal.generic.POP;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Controller
@RequestMapping(value = "/api/data")
public class PositioningDataWeb {

    @Resource
    private PositioningDataService positioningDataService;
    @Resource
    private DataCollectRecordService dataCollectRecordService;

    //http接口地址:ip/api/data/PositioningData/addPositioningData
    @RequestMapping(value = "/PositioningData/addPositioningData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addPositioningData(@RequestBody Map<String, String> parm) {

        PositioningData positioningData=new Gson().fromJson(parm.get("json"),PositioningData.class);
        positioningDataService.add(positioningData);
        Map<String, String> re = new HashMap<String, String>();
        re.put("code", "200");
        return re;
    }


    //http接口地址:ip/api/data/PositioningData/addRssIData
    @RequestMapping(value = "/PositioningData/addRssIData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addRssIData(@RequestBody Map<String, String> rssIDataMap) {

        RssIData rssIData = new Gson().fromJson(rssIDataMap.get("json"),RssIData.class);
        positioningDataService.addRssIData(rssIData);
        Map<String, String> re = new HashMap<String, String>();
        re.put("code", "200");
        return re;
    }

    //http接口地址:ip/api/data/PositioningService/test
    @RequestMapping(value = "/PositioningService/test", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> test() {
        Map<String, String> re = new HashMap<String, String>();
        re.put("code", "200");
        re.put("msg", "success");
        return re;
    }


    //http接口地址:ip/api/data/PositioningService/checkOutDataCollectRecord
    @RequestMapping(value = "/PositioningService/checkOutDataCollectRecord", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> checkOutDataCollectRecord(@RequestBody Map<String, String> info) {
        Map<String, String> re = new HashMap<String, String>();
        if (dataCollectRecordService.load(NumberUtils.toInt(info.get("POSITION"))) == null) {
            re.put("code", "200");
            re.put("msg", "success");
        } else {
            re.put("code", "201");
            re.put("msg", "success");
        }
        return re;
    }


    //http接口地址:ip/api/data/PositioningService/checkOutDataCollectRecord
    @RequestMapping(value = "/PositioningService/DataCollectRecordAdd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> dataCollectRecordAdd(@RequestBody Map<String, String> parm) {
        DataCollectRecord dataCollectRecord = new DataCollectRecord();
        dataCollectRecord.setDataSizes(NumberUtils.toInt(parm.get("dataSize")));
        dataCollectRecord.setDataType(NumberUtils.toInt(parm.get("dataType")));
        dataCollectRecord.setMobilePhone(parm.get("mobilePhone"));
        dataCollectRecord.setPosition(NumberUtils.toInt(parm.get("position")));
        dataCollectRecordService.update(dataCollectRecord);
        Map<String, String> re = new HashMap<String, String>();
        re.put("code", "200");
        return re;
    }


    //http接口地址:ip/api/data/PositioningService/checkOutDataCollectRecord
    @RequestMapping(value = "/PositioningService/apStringMacAdd", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Map<String, String> apStringMacAdd(@RequestBody Map<String, String> apStringMasMap) {
        dataCollectRecordService.deleteApStringMac();
        for (Map.Entry<String, String> entry : apStringMasMap.entrySet()) {
            ApStringMac apStringMac = new ApStringMac();
            apStringMac.setMacName(entry.getValue());
            dataCollectRecordService.addApStringMac(apStringMac);
        }
        Map<String, String> re = new HashMap<String, String>();
        re.put("code", "200");
        return re;
    }

    //http接口地址:ip/api/data/PositioningService/checkOutDataCollectRecord
    @RequestMapping(value = "/PositioningService/getAPlist", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> getApList(@RequestBody Map<String, String> apStringMasMap) {
        Map<String, String> map = new HashMap<>();
        List<ApStringMac> list = new ArrayList<>();
        list = dataCollectRecordService.getApList();
        for (ApStringMac asm : list) {
            map.put(asm.getMacName(), asm.getMacName());
        }
        return map;
    }


    //http接口地址:ip/api/data/PositioningService/checkOutDataCollectRecord
    @RequestMapping(value = "/PositioningService/dataRecoderList", method = RequestMethod.GET)
    @ResponseBody
    public List<DataCollectRecord> getDataRecoder() {
        return dataCollectRecordService.list();
    }


    @Resource
    RadioSignalStrengthDao radioSignalStrengthDao;


    @RequestMapping(value = "/PositioningService/getRssList", method = RequestMethod.POST)
    @ResponseBody
    public List<RadioSignalStrength> getRssList(@RequestBody Map<String, String> apMap) {
        int pos = Integer.parseInt(apMap.get("pos"));
        return radioSignalStrengthDao.load(pos);
    }


    @ResponseBody
    @RequestMapping(value = "/PositioningService/getPosList", method = RequestMethod.POST)
    public List<PositioningData> getPositioningDataList(@RequestBody Map<String, String> apMap) {
        int pos = Integer.parseInt(apMap.get("pos"));
        List<PositioningData> list = dataCollectRecordService.list_byPosition(pos);
        return list;
    }

}
