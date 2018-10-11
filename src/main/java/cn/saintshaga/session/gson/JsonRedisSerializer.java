package cn.saintshaga.session.gson;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

/**
 * Created by huang on 18-9-21.
 */
public class JsonRedisSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(@Nullable Object o) throws SerializationException {
        return new byte[0];
    }

    @Override
    public Object deserialize(@Nullable byte[] bytes) throws SerializationException {
        return null;
    }
}
