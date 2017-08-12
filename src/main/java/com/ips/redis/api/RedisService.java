package com.ips.redis.api;

import com.ips.redis.RedisKeyDto;

/**
 * Created by shenwenbo on 2017/3/6.
 */
public interface RedisService {
    void addData(RedisKeyDto redisKeyDto);
    void delete(RedisKeyDto redisKeyDto);
    RedisKeyDto redisGet(RedisKeyDto redisKeyDto);
    void addRedisData(RedisKeyDto redisKeyDto,int outTime);
}
