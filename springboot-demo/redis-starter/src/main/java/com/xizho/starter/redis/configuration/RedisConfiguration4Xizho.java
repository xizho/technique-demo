package com.xizho.starter.redis.configuration;

import com.xizho.starter.redis.properties.RedisXizhoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Configuration
@EnableConfigurationProperties(RedisXizhoProperties.class)
@ConditionalOnProperty(
        prefix = "xizho",
        name = "isOpen",
        havingValue = "true"
)
public class RedisConfiguration4Xizho {

    private final static Logger LOGGER = LoggerFactory.getLogger(RedisConfiguration4Xizho.class);

    @Autowired
    private RedisXizhoProperties redisXizhoProperties;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPool jedisPool = new JedisPool(redisXizhoProperties,
                redisXizhoProperties.getHost(),
                redisXizhoProperties.getPort(),
                redisXizhoProperties.getTimeout(),
                (StringUtils.isEmpty(redisXizhoProperties.getPassword()) ? null : redisXizhoProperties.getPassword()),
                redisXizhoProperties.getDatabase());

        LOGGER.info("JedisPool *******init success********* ");
        LOGGER.info("Redis-info [host:{}, port:{}, database:{}]", redisXizhoProperties.getHost(), redisXizhoProperties.getPort(), redisXizhoProperties.getDatabase());

        return jedisPool;
    }

    @Bean
    @ConditionalOnBean(name = "redisPoolFactory")
    public Jedis getRedis(@Qualifier("redisPoolFactory") JedisPool jedisPool) {
        return jedisPool.getResource();
    }

}
