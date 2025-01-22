package org.learn.tech.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.learn.tech.redis.service.Strategy;
import org.learn.tech.redis.service.StrategyContext;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class StrategyServiceTest {

    @Resource
    private StrategyContext strategyContext;

    @Test
    public void test() {
        Strategy<String, String> strategy = strategyContext.getStrategy(1);
        log.info("strategyContext={}", strategy.eat("好吃"));
    }
}
