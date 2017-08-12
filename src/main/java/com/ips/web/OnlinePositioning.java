package com.ips.web;

import com.ips.dao.RadioSignalStrengthDao;
import com.ips.dto.RadioSignalStrength;
import com.ips.services.api.LbsService;
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
 * Created by shenwenbo on 2017/2/9.
 */
@Controller
@RequestMapping(value ="/api/online/positioning")
public class OnlinePositioning {


    @Resource
    private RadioSignalStrengthDao radioSignalStrengthDao;
    @Resource
    private LbsService lbsService;

    /**
     * 构建位置指纹数据库时添加数据函数
     * @param rssIDataMap
     * @return
     */
    //http接口地址:ip/api/online/positioning/mapConstruction
    @RequestMapping(value = "/mapConstruction", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> mapConstruction(@RequestBody Map<String, String> rssIDataMap) {
        RadioSignalStrength radioSignalStrength=
                (RadioSignalStrength) MapUtils.convert2Bean(rssIDataMap,new RadioSignalStrength());
        radioSignalStrengthDao.add(radioSignalStrength);
        lbsService.addCache(radioSignalStrength);
        Map<String,String> re=new HashMap<String,String>();
        re.put("code","200");
        return re;
    }
}
