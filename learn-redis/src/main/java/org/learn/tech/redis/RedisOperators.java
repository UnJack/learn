package org.learn.tech.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

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
@Service
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
            if (!lock(lockKey, lockReference, timeout)) {
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
     */
    private boolean lock(String key, String value, long timeout) {
        Boolean locked;
        try {
            //SET_IF_ABSENT --> NX: Only set the key if it does not already exist.
            //SET_IF_PRESENT --> XX: Only set the key if it already exist.
            locked = redisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.set(
                            key.getBytes(StandardCharsets.UTF_8),
                            value.getBytes(StandardCharsets.UTF_8),
                            Expiration.from(timeout, TimeUnit.SECONDS),
                            RedisStringCommands.SetOption.SET_IF_ABSENT
                    )
            );
            if (Boolean.TRUE.equals(locked)) {
                log.info("当前机器分布式加锁成功，key={}", key);
            }
        } catch (Exception e) {
            log.error("Lock failed for redis key: {}, value: {}", key, value);
            locked = false;
        }
        return locked != null && locked;
    }

    /**
     * Executes a Lua script on Redis to unlock a distributed lock.
     *
     * @param key   The key of the lock in Redis.
     * @param value The value associated with the lock.
     * @return true if the lock was successfully unlocked, false otherwise.
     */
    private boolean unlock(String key, String value) {
        Boolean unlock;
        try {
            //使用lua脚本保证删除的原子性，确保解锁
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] "
                    + "then return redis.call('del', KEYS[1]) "
                    + "else return 0 end";
            unlock = redisTemplate.execute((RedisCallback<Boolean>) connection ->
                    connection.eval(
                            script.getBytes(),
                            ReturnType.BOOLEAN,
                            1,
                            key.getBytes(StandardCharsets.UTF_8),
                            value.getBytes(StandardCharsets.UTF_8)
                    )
            );
            if (Boolean.TRUE.equals(unlock)) {
                log.info("当前机器分布式解锁成功，key={}", key);
            }

        } catch (Exception e) {
            log.error("unLock failed for redis key: {}, value: {}", key, value);
            unlock = false;
        }
        return unlock == null || !unlock;
    }

    /**
     * Sets a key-value pair in Redis with an expiration time.
     *
     * @param key   The key of the data to be stored.
     * @param value The value to be stored.
     * @throws Exception If an error occurs while setting the value.
     */
    public void set(String key, String value) throws Exception {
        redisTemplate.opsForValue().set(key, value, 24 * 60 * 60, TimeUnit.SECONDS);
    }

    /**
     * Retrieves the value associated with a key from Redis.
     *
     * @param key The key of the data to be retrieved.
     * @return The value associated with the key, or null if the key does not exist.
     * @throws Exception If an error occurs while retrieving the value.
     */
    public Object get(String key) throws Exception {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * Deletes a key from Redis.
     *
     * @param key The key to be deleted.
     * @return true if the key was deleted, false otherwise.
     */
    public boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * Pops an element from the right end of a list in Redis.
     *
     * @param key The key of the list.
     * @return The element popped from the list, or null if the list is empty.
     */
    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * Pops multiple elements from the right end of a list in Redis.
     *
     * @param key   The key of the list.
     * @param count The number of elements to pop.
     * @return A list of elements popped from the list.
     */
    public List<Object> rightPop(String key, long count) {
        return redisTemplate.opsForList().rightPop(key, count);
    }

    /**
     * Pushes an element onto the left end of a list in Redis.
     *
     * @param key   The key of the list.
     * @param value The element to be pushed.
     */
    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * Returns the length of a list in Redis.
     *
     * @param key The key of the list.
     * @return The length of the list.
     */
    public long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }
}
