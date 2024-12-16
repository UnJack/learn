package org.learn.tech.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作
 */
@Slf4j
public class RedisOperators {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 分布式锁
     *
     * @param lockKey
     * @param callable
     * @param <T>
     * @return
     */
    public <T> T callWithLock(String lockKey, Callable<T> callable, long timeout) throws Exception {
        //将UUID当做value，确保唯一性
        String lockReference = UUID.randomUUID().toString();
        try {
            if (!lock(lockKey, lockReference, timeout, TimeUnit.SECONDS)) {
                throw new Exception("");
            }
            return callable.call();
        } finally {
            unlock(lockKey, lockReference);
        }
    }

    /**
     * redis加锁
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    private boolean lock(String key, String value, long timeout, TimeUnit timeUnit) {
        Boolean locked;
        try {
            //SET_IF_ABSENT --> NX: Only set the key if it does not already exist.
            //SET_IF_PRESENT --> XX: Only set the key if it already exist.
            locked = redisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.set(
                            key.getBytes(StandardCharsets.UTF_8),
                            value.getBytes(StandardCharsets.UTF_8),
                            Expiration.from(timeout, timeUnit),
                            RedisStringCommands.SetOption.SET_IF_ABSENT
                    )
            );
            if (locked) {
                log.info("当前机器分布式加锁成功，key={}", key);
            }
        } catch (Exception e) {
            log.error("Lock failed for redis key: {}, value: {}", key, value);
            locked = false;
        }
        return locked != null && locked;
    }

    /**
     * redis解锁
     *
     * @param key
     * @param value
     * @return
     */
    private boolean unlock(String key, String value) {
        try {
            //使用lua脚本保证删除的原子性，确保解锁
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] "
                    + "then return redis.call('del', KEYS[1]) "
                    + "else return 0 end";
            Boolean unlockState = redisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.eval(
                            script.getBytes(),
                            ReturnType.BOOLEAN,
                            1,
                            key.getBytes(StandardCharsets.UTF_8),
                            value.getBytes(StandardCharsets.UTF_8)
                    )
            );
            if (unlockState) {
                log.info("当前机器分布式解锁成功，key={}", key);
            }
            return unlockState == null || !unlockState;
        } catch (Exception e) {
            log.error("unLock failed for redis key: {}, value: {}", key, value);
            return false;
        }
    }

    public void set(String key, String value) throws Exception {
        redisTemplate.opsForValue().set(key, value, 24 * 60 * 60, TimeUnit.SECONDS);
    }

    public Object get(String key) throws Exception {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    public List<Object> rightPop(String key, long count) {
        return redisTemplate.opsForList().rightPop(key, count);
    }

    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }
}
