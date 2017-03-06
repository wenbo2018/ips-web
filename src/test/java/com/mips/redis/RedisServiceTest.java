package com.mips.redis;

import com.ips.dto.User;
import com.ips.redis.RedisKeyDto;
import com.ips.redis.api.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by shenwenbo on 2017/3/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring/application-*.xml",
        "classpath*:config/spring/spring-*.xml"})
public class RedisServiceTest {
    @Resource
    private RedisService redisService;

    @Test
    public void testAdd() {
        User user=new User();
        user.setId(123456);
        user.setUsername("shenwenbo");
        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(String.valueOf(user.getId()));
        redisKeyDto.setValues(user.getUsername());
        redisService.addData(redisKeyDto);
    }

    @Test
    public void testGet() {
        User user=new User();
        user.setId(123456);
        user.setUsername("shenwenbo");
        RedisKeyDto redisKeyDto=new RedisKeyDto();
        redisKeyDto.setKeys(String.valueOf(user.getId()));
        redisKeyDto.setValues(user.getUsername());
        System.out.println(redisService.redisGet(redisKeyDto).getValues());
    }

}
