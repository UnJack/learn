package org.learn.tech.juc;

import java.util.concurrent.*;

/**
 * User: jimjian
 * Date: 16-2-2 Time: 下午3:18
 */
public class test_FutureTask {

    public static void main(String[] args) {
        //第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        test_Future.Task task = new test_Future.Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executor.submit(futureTask);
        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务 " + test_FutureTask.class);

        try {
            System.out.println("task运行结果" + futureTask.get() + " " + test_FutureTask.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕 " + test_FutureTask.class);
    }
}

