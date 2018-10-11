package cn.saintshaga.session.config;

import cn.saintshaga.session.gson.JsonRedisSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by huang on 18-9-18.
 */
@EnableRedisHttpSession
public class RedisSessionConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(new RedisStandaloneConfiguration("172.26.136.55", 6379));
    }

//    @Bean
//    @Qualifier("springSessionDefaultRedisSerializer")
//    public JsonRedisSerializer jsonRedisSerializer() {
//        return new JsonRedisSerializer();
//    }
}
