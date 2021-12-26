package com.daxu.picturesapp.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    public void set(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public void setex(String key, String value, int seconds) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, seconds,TimeUnit.SECONDS);
    }

    public String get(String key)
    {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
    public boolean exists(String key)
    {
       return redisTemplate.hasKey(key);
    }
    public  long getExpire(String key)
    {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
    public void remove(String key)
    {
        redisTemplate.delete(key);
    }
}
