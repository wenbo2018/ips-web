package com.mips;

import com.github.pagehelper.PageInfo;
import com.ips.dao.PositioningDataDao;
import com.ips.dto.PositioningData;
import com.ips.dto.RadioSignalStrength;
import com.ips.services.api.DataCollectRecordService;
import com.ips.services.api.LbsService;
import com.ips.services.api.PositioningDataService;
import com.ips.services.api.UserService;
import com.ips.util.MapUtils;
import org.aspectj.bridge.MessageWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shenwenbo on 2016/11/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring/application-*.xml",
        "classpath*:config/spring/spring-*.xml"})
public class test {

    @Resource
    private PositioningDataDao positioningDataDao;
    @Resource
    private PositioningDataService positioningDataService;
    @Resource
    private DataCollectRecordService dataCollectRecordService;

    @Resource
    private UserService userService;

    @Resource
    private LbsService lbsService;

    @Test
    public void  test() {
        PositioningData positioningData=new PositioningData();
        positioningData.setMagneticX(1);
        positioningData.setMagneticY(1);
        positioningData.setMagneticZ(1);

        positioningData.setAccelerationX(1);
        positioningData.setAccelerationY(1);
        positioningData.setAccelerationZ(1);

        positioningData.setOrientationX(1);
        positioningData.setOrientationY(1);
        positioningData.setOrientationZ(1);

        positioningData.setGyroscopeX(1);
        positioningData.setGyroscopeY(1);
        positioningData.setGyroscopeZ(1);

        positioningData.setCampassX(1);
        positioningData.setCampassY(1);
        positioningData.setCampassZ(1);

        positioningData.setPresure(1);

        positioningData.setPosition(1);
        positioningData.setIndexId(1);
        positioningDataDao.add(positioningData);

    }

    @Test
    public void queryByPageTest(){
        PageInfo<PositioningData> page = positioningDataService.queryByPage( 15,5);
        for (PositioningData positioningData:page.getList())
        System.out.println(positioningData.getIndexId());

    }

    @Test
    public void test3() {
        System.out.println(userService.queryByUserNameAndPassWord("123","456"));
    }

    @Test
    public void test4() {
        RadioSignalStrength radioSignalStrength= new RadioSignalStrength();
        radioSignalStrength.setAP1(-54);
        radioSignalStrength.setAP2(-68);
        radioSignalStrength.setAP3(-59);
        radioSignalStrength.setAP4(-38);
        radioSignalStrength.setAP5(-62);
        radioSignalStrength.setAP6(-72);
        radioSignalStrength.setAP7(-72);
        radioSignalStrength.setAP8(-68);
        radioSignalStrength.setAP9(-78);
        radioSignalStrength.setAP10(-59);
        System.out.println(lbsService.lbsLocation(radioSignalStrength,10));
    }





}
