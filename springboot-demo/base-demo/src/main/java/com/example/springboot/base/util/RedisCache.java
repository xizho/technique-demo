package com.example.springboot.base.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * 类职责：<br/>
 *
 * <p>Title: RedisCache.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Cmexico</p>
 * <p>CreateTime:2017年12月26日上午9:16:32
 * <p>$LastChangedBy$</p>
 * <p>$LastChangedRevision$ </p>
 * <p>$LastChangedDate$ </p>
 * <p>$Id$ </p>
 */
@Component
public class RedisCache {

    private static StringRedisTemplate stringRedisTemplate;

    private static JedisPool jedisPool;

    /**
     * @param stringRedisTemplate
     * @param jedisPool
     */
    public RedisCache(StringRedisTemplate stringRedisTemplate, JedisPool jedisPool) {
        initStringRedisTemplate(stringRedisTemplate);
        initJedisPool(jedisPool);
    }

    /**
     * @param stringRedisTemplate
     */
    private static void initStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        RedisCache.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * @param jedisPool
     */
    private static void initJedisPool(JedisPool jedisPool) {
        RedisCache.jedisPool = jedisPool;
    }

    /**
     * @return
     */
    public static JedisPool getJedisPool() {

        return RedisCache.jedisPool;

    }


    /**
     * 默认增长步长
     */
    public static final long DEFAULT_DELTA = 1;

    /**
     * @return
     */
    public static StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    /**
     * @param key
     * @param delta
     * @return
     */
    public static long increment(String key, long delta) {

        try {
            return stringRedisTemplate.opsForValue().increment(key, delta).longValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param key
     * @return
     */
    public static long increment(String key) {

        try {
            return stringRedisTemplate.opsForValue().increment(key, DEFAULT_DELTA).longValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * @param key
     * @param val
     * @return
     */
    public static String getAndSet(String key, String val) {

        try {
            return stringRedisTemplate.opsForValue().getAndSet(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param key
     * @param val
     */
    public static void set(String key, String val) {

        try {
            stringRedisTemplate.opsForValue().set(key, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
