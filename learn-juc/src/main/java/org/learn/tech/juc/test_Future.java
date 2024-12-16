package org.learn.tech.juc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: jimjian
 * Date: 16-2-2
 * Time: 下午3:12
 */
public class test_Future {

    @Test
    public void test1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        System.out.println("$主线程在执行任务=" + test_Future.class);
        try {
            System.out.println("$Task运行结果=" + result.get(1000, TimeUnit.MILLISECONDS) + " " + test_Future.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("$所有任务执行完毕=" + test_Future.class);
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException {
        ExecutorService exe = Executors.newCachedThreadPool();
        List<Sum> list = new ArrayList<>();
        list.add(new Sum(0, 10));
        list.add(new Sum(100, 1_000));
        list.add(new Sum(10_000, 1_000_000));
        List<Future<Long>> futureList = exe.invokeAll(list);

        exe.shutdown();
        for (Future<Long> s : futureList) {
            System.out.println(s.get());
        }
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在进行计算=" + this.getClass());
            Thread.sleep(5000);
            return new Date().hashCode();
        }
    }

    static class Sum implements Callable<Long> {
        private final long from;
        private final long to;

        Sum(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() {
            long acc = 0;
            for (long i = from; i <= to; i++) {
                acc = acc + i;
            }
            return acc;
        }
    }

}



