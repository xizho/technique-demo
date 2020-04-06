package com.example.springboot.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Set;

public class JedisTool {

    private static Logger logger = LoggerFactory.getLogger(JedisTool.class);

    private static final String LOCK_SUCCESS = "OK";

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;

    private static Jedis jedis = RedisCache.getJedisPool().getResource();

    private final static Object LOCK = new Object();

    private static Jedis getJedis() {
//        if (jedis == null) {
//            synchronized (LOCK) {
//                if (jedis == null) {
        jedis = RedisCache.getJedisPool().getResource();
//                }
//            }
//        }

        return jedis;
    }


    /**
     * 尝试获取分布式锁
     *
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }

        return false;
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }

        return false;
    }

    public static void set(String key, String value) {
        Jedis jedis = getJedis();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("set [{}] failed: ", key, e);
        } finally {
            close();
        }
    }

    public static void setnx(String key, String value) {
        Jedis jedis = getJedis();
        try {
            jedis.setnx(key, value);
        } catch (Exception e) {
            logger.error("setnx [{}] failed: ", key, e);
        } finally {
            close();
        }
    }

    public static void set(String key, String value, int expire) {
        Jedis jedis = getJedis();
        try {
            jedis.setex(key, expire, value);
        } catch (Exception e) {
            logger.error("set [{}] expire failed: ", key, e);
        } finally {
            close();
        }
    }

    public static Object get(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("get [{}] failed: ", key, e);
        } finally {
            close();
        }

        return null;
    }

    public static boolean exists(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.exists(key);
        } catch (Exception e) {
            logger.error("[{}] exists failed: ", key, e);
        } finally {
            close();
        }

        return false;
    }

    public static void del(String key) {
        Jedis jedis = getJedis();
        try {
            if (!exists(key)) {
                logger.warn("[{}]不存在", key);
                return;
            }

            jedis.del(key);
        } catch (Exception e) {
            logger.error("del [{}] failed: ", key, e);
        } finally {
            close();
        }
    }

    public static long sadd(String key, String... value) {
        Jedis jedis = getJedis();
        try {
            return jedis.sadd(key, value);
        } catch (Exception e) {
            logger.error("add set [{}] failed: ", key, e);
        } finally {
            close();
        }

        return 0;
    }

    public static long scard(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.scard(key);
        } catch (Exception e) {
            logger.error("get set size [{}] failed: ", key, e);
        } finally {
            close();
        }

        return 0;
    }

    public static boolean sismember(String key, String value) {
        Jedis jedis = getJedis();
        try {
            return jedis.sismember(key, value);
        } catch (Exception e) {
            logger.error("[{}] belongs to [{}] ? failed: ", value, key, e);
        } finally {
            close();
        }

        return false;
    }

    public static Set<String> smembers(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.smembers(key);
        } catch (Exception e) {
            logger.error("[{}] smembers failed: ", key, e);
        } finally {
            close();
        }

        return null;
    }

    public static String spop(String key) {
        Jedis jedis = getJedis();
        try {
            return jedis.spop(key);
        } catch (Exception e) {
            logger.error("get set size [{}] failed: ", key, e);
        } finally {
            close();
        }

        return null;
    }

    public static long move(String sourceKey, String targetKey, String value) {
        Jedis jedis = getJedis();
        try {
            return jedis.smove(sourceKey, targetKey, value);
        } catch (Exception e) {
            logger.error("move [{}] from set[{}] to set[{}] failed: ", value, sourceKey, targetKey, e);
        } finally {
            close();
        }

        return 0;
    }

    /**
     * 关闭redis连接
     */
    public static void close() {
        if (jedis != null) {
            synchronized (LOCK) {
                if (jedis != null && jedis.isConnected()) {
//                    jedis.close();
                }
            }
        }
    }

}