package org.learn.tech.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class RedisOperatorTest {

    @Resource
    private RedisOperators redisOperators;

    @Test
    public void get() {
        try {
            String result = (String) redisOperators.get("test");
            log.info("result={}", result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
