package com.example.springboot.base.test;

import com.example.springboot.base.util.JedisTool;
import com.example.springboot.base.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 类职责：redis测试<br/>
 *
 * <p>Title: TestRedis.java</p>
 * <p>Description: redis测试</p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年01月29日 下午 4:55
 * <p></p>
 * <p> </p>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRedis {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RedisUtil redisUtil;

    @Test
    public void test() {
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set(key, key, 12, TimeUnit.SECONDS);
        Map<String, Object> map = new HashMap<>();
        map.put(key, key + ":json");
        key = UUID.randomUUID().toString().replaceAll("-", "");
        String[] strings = new String[3];
        int i = 0;
        strings[0] = String.valueOf(Instant.now().toEpochMilli() + ++i);
        strings[1] = String.valueOf(Instant.now().toEpochMilli() + ++i);
        strings[2] = String.valueOf(Instant.now().toEpochMilli() + ++i);
        redisTemplate.opsForList().leftPushAll(key, strings);
        redisTemplate.expire(key, 10, TimeUnit.SECONDS);
        key = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForSet().add(key, strings);
        redisTemplate.expire(key, 10, TimeUnit.SECONDS);

        System.out.println("expire time is " + redisTemplate.getExpire(key));
        key = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForHash().putAll(key, map);
    }


    @Test
    public void testJedis() {
        JedisTool.set("a", "123");
        JedisTool.set("b", "456");
    }


    @Test
    public void testRedis() throws InterruptedException {
        String key = getSerial();
        redisUtil.set(key.concat(":util"), Instant.now(), 20);


    }

    private String getSerial() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

}
