package org.learn.tech.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.learn.tech.redis.service.StrategyContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 存活检测
 *
 * @author jimjian
 * @date 2024-10-28
 */
@Slf4j
@RequestMapping("/home")
@RestController
public class HomeController {

    @Resource
    private StrategyContext strategyContext;

    /**
     * 心跳接口
     */
    @GetMapping(value = "/heartbeat/{id}")
    public String heartbeat(@PathVariable("id") int id) {
        log.info(strategyContext.getStrategy(id).eat("?"));
        return "success";
    }
}

