package org.learn.tech.juc;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import static junit.framework.Assert.assertEquals;

/**
 * User: jimjian
 * Date: 16-3-29 下午5:47
 */
public class test_ForkJoinPool {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask<String> task = new MyForkJoinTask<>();
        task.setSuccess(true);
        task.setRawResult("test");
        String invokeResult = forkJoinPool.invoke(task);
        assertEquals(invokeResult, "test");
    }

    @Test
    public void test2() {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<>();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.complete("i complete...");
            }
        }).start();

        // exec()返回值是false，此处阻塞，直到另一个线程调用了task.complete(...)
        String result = forkJoinPool.invoke(task);
        System.out.println("result:" + result);
    }

    @Test
    public void test3() {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<>();

        task.setSuccess(true); // 是否在此任务运行完毕后结束阻塞
        ForkJoinTask<String> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get()); // 如果exec()返回值是false，在此处会阻塞，直到调用complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<>();

        task.setSuccess(true); // 是否在此任务运行完毕后结束阻塞
        ForkJoinTask<String> result = forkJoinPool.submit(task);
        System.out.println(result.get()); // 如果exec()返回值是false，在此处会阻塞，直到调用complete
    }

    @Test
    public void test5() throws InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<>();

        forkJoinPool.submit(task);
        Thread.sleep(1000);
    }

    @Test
    public void test6() throws ExecutionException, InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<>();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                task.complete("i complete...");
            }
        }).start();

        ForkJoinTask<String> result = forkJoinPool.submit(task);
        // exec()返回值是false，此处阻塞，直到另一个线程调用了task.complete(...)
        System.out.println(result.get());
        Thread.sleep(1000);
    }

    @Test
    public void test7() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask<String> task = new MyForkJoinTask<>();
        forkJoinPool.execute(task); // 异步执行，无视task.exec()返回值。
    }

    @Test
    public void test8() throws InterruptedException {

    }

    static class MyForkJoinTask<V> extends ForkJoinTask<V> {

        private static final long serialVersionUID = 1L;

        private V value;

        private boolean success = false;

        @Override
        public V getRawResult() {
            return value;
        }

        @Override
        protected void setRawResult(V value) {
            this.value = value;
        }

        @Override
        protected boolean exec() {
            System.out.println(" 执行...");
            return this.success;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean isSuccess) {
            this.success = isSuccess;
        }

    }
}
