package org.learn.tech.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RedisApplication
 *
 * @author jimjian
 * @date 2024-09-24
 */
@SpringBootApplication(scanBasePackages = "org.learn.tech.redis")
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
