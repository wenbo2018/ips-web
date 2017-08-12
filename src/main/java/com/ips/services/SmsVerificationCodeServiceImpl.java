package com.ips.services;

import com.ips.redis.RedisKeyDto;
import com.ips.redis.api.RedisService;
import com.ips.services.api.SmsVerificationCodeService;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by shenwenbo on 2017/3/13.
 */
@Service
public class SmsVerificationCodeServiceImpl implements SmsVerificationCodeService {

    private static Logger LOGGER= LoggerFactory.getLogger(SmsVerificationCodeService.class);
    //短信验证码过期时间
    private  static int  EXPIRATIONTIME=3000;
    @Resource
    private RedisService redisService;

    @Transactional
    @Override
    public String sendMessage(String phoneName) {
        String rusult = null;
        String url = "http://gw.api.taobao.com/router/rest";
        // 成为开发者，创建应用后系统自动生成
        String appkey = "********";
        String secret = "*******";
        String code = getRandNum(6);
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("1234");
        req.setSmsType("normal");
        req.setSmsFreeSignName("个人测试");
        req.setSmsParamString("{\"code\":\""+code+"\"}");
        req.setRecNum(phoneName);
        req.setSmsTemplateCode("SMS_54300021");
        try {
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            System.out.println(rsp.getBody());
            rusult = rsp.getSubMsg();
        } catch (Exception e) {
            LOGGER.error("message code check error",e);
        }
        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(phoneName);
        redisKeyDto.setValues(code);
        redisService.addRedisData(redisKeyDto,EXPIRATIONTIME);
        return rusult;
    }

    @Override
    public boolean checkIsCorrectCode(String phone, String code) {
        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(phone);
        RedisKeyDto result=redisService.redisGet(redisKeyDto);
        if (result!=null&&result.getValues().equals(String.valueOf(code)))
            return true;
        return false;
    }
    /***
     * 获取6位验证码
     * @param charCount
     * @return
     */
    public String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    public RedisService getRedisService() {
        return redisService;
    }

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }
}
