package com.ips.web;

import com.ips.dto.PositioningData;
import com.ips.services.api.PositioningDataService;
import com.ips.util.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenwenbo on 2016/10/4.
 */
@Controller
@RequestMapping(value ="/api/data")
public class PositioningDataWeb {

    @Resource
    private PositioningDataService positioningDataService;

    //http接口地址:ip/api/data/PositioningData/add
    @RequestMapping(value = "/PositioningData/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addPositioningData(@RequestBody Map<String, String> positioningDataMap) {
        PositioningData positioningData= (PositioningData)MapUtils.convert2Bean(positioningDataMap,new PositioningData());
        positioningDataService.add(positioningData);
        Map<String,String> re=new HashMap<String,String>();
        re.put("code","200");
        return re;
    }
}
