package com.ips.redis;

import com.ips.redis.api.RedisService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import java.io.Serializable;

/**
 * Created by shenwenbo on 2017/3/6.
 */
public class RedisServiceImpl implements RedisService {

    private RedisTemplate<Serializable, Serializable> redisTemplate;

    @Override
    public void addData(final RedisKeyDto redisKeyDto) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(
                        redisTemplate.getStringSerializer().serialize(redisKeyDto.getKeys()),
                        redisTemplate.getStringSerializer().serialize(redisKeyDto.getValues())
                );
                return null;
            }
        });
    }

    @Override
    public void delete(final RedisKeyDto redisKeyDto) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.del(redisTemplate.getStringSerializer().serialize(redisKeyDto.getKeys()));
                return null;
            }
        });
    }

    @Override
    public RedisKeyDto redisGet(final RedisKeyDto redisKeyDto) {
        return redisTemplate.execute(new RedisCallback<RedisKeyDto>() {
            public RedisKeyDto doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(redisKeyDto.getKeys());
                if (connection.exists(key)) {
                    byte[] value = connection.get(key);
                    //从redis中取出的需要反序列化--- deserialize
                    String redisValue=redisTemplate.getStringSerializer().deserialize(value);
                    RedisKeyDto re=new RedisKeyDto();
                    re.setKeys(redisKeyDto.getKeys());
                    re.setValues(redisValue);
                    return re;
                }
                return null;
            }
        });
    }

    @Override
    public void addRedisData(final RedisKeyDto redisKeyDto, final int outTime) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.set(
                        redisTemplate.getStringSerializer().serialize(redisKeyDto.getKeys()),
                        redisTemplate.getStringSerializer().serialize(redisKeyDto.getValues())
                );
                connection.expire(redisTemplate.getStringSerializer().serialize(redisKeyDto.getKeys()),outTime);
                return null;
            }
        });
    }


    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
