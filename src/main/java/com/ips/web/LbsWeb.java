package com.ips.web;

import com.github.pagehelper.PageInfo;
import com.ips.dao.RadioSignalStrengthDao;
import com.ips.dto.PositioningData;
import com.ips.dto.RadioSignalStrength;
import com.ips.dto.RssIData;
import com.ips.services.api.LbsService;
import com.ips.util.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenwenbo on 2016/12/23.
 */
@Controller
@RequestMapping(value ="api/lbs")
public class LbsWeb {

    @Resource
    LbsService lbsService;

    @Resource
    RadioSignalStrengthDao radioSignalStrengthDao;

    //http接口地址:ip/api/data/PositioningData/addRssIData
    @RequestMapping(value = "/positioning", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> lbs(@RequestBody Map<String, String> rssIDataMap) {
        RadioSignalStrength radioSignalStrength=
                (RadioSignalStrength) MapUtils.convert2Bean(rssIDataMap,new RadioSignalStrength());
        int pos=lbsService.lbsLocation(radioSignalStrength,40);
        Map<String,String> re=new HashMap<String,String>();
        if (pos>0) {
            re.put("code","200");
            re.put("pos",String.valueOf(pos));
        } else {
            re.put("code","400");
        }
        return re;
    }

    //http接口地址:ip/api/data/PositioningData/addRssIData
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addRssIData(@RequestBody Map<String, String> rssIDataMap) {
        RadioSignalStrength radioSignalStrength=
                (RadioSignalStrength) MapUtils.convert2Bean(rssIDataMap,new RadioSignalStrength());
        radioSignalStrengthDao.add(radioSignalStrength);
        Map<String,String> re=new HashMap<String,String>();
            re.put("code","200");
        return re;
    }


}
