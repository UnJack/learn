package org.learn.tech.juc.thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * User: jimjian
 * Date: 16-3-25 上午11:44
 */
public class test_newScheduledThreadPool {

    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        // 间隔1秒执行，周期为3秒
        final ScheduledFuture future1 = scheduledExecutorService.scheduleAtFixedRate(new ScheduledThread("fix1-固定"), 1000, 3000, TimeUnit.MILLISECONDS);
        final ScheduledFuture future2 = scheduledExecutorService.scheduleAtFixedRate(new ScheduledThread("fix2-固定"), 2000, 3000, TimeUnit.MILLISECONDS);
        final ScheduledFuture future3 = scheduledExecutorService.scheduleAtFixedRate(new ScheduledThread("fix3-固定"), 3000, 3000, TimeUnit.MILLISECONDS);
        final ScheduledFuture future4 = scheduledExecutorService.scheduleWithFixedDelay(new ScheduledThread("delay-延迟"), 3000, 3000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                future1.cancel(true);
                future2.cancel(true);
                future3.cancel(true);
                future4.cancel(true);
                scheduledExecutorService.shutdown();
            }
        }, 12000, TimeUnit.MILLISECONDS);
    }

    static class ScheduledThread implements Runnable {

        private String name;

        public ScheduledThread() {
        }

        public ScheduledThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(" " + this.name);
        }
    }
}
