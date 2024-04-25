package org.example.redis.service;

import lombok.RequiredArgsConstructor;
import org.example.redis.model.CarEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisCacheService {
    private final RedisTemplate<String, Object> redisTemplate;

    public void cacheValue(CarEntity car) {
        final var valueOperation = redisTemplate.opsForValue();
        valueOperation.set("cachedCar", car);
    }

    public CarEntity getValue(String key) {
        final var valueOperation = redisTemplate.opsForValue();
        return (CarEntity) valueOperation.get(key);
    }

    public void evictValue(String key) {
        redisTemplate.delete(key);
    }
}
