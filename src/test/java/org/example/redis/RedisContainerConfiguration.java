package org.example.redis;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
public class RedisContainerConfiguration {
    private RedisContainer redisContainer;

    @Bean
//    @ServiceConnection(name = "redisContainer")
//    public RedisContainer redisContainer() {
//        return new RedisContainer(DockerImageName.parse("redis:latest"))
//            .withExposedPorts(6379);
//    }
    public GenericContainer redisContainer() {
        return new GenericContainer("redis:latest")
            .withExposedPorts(6379);
    }
}
