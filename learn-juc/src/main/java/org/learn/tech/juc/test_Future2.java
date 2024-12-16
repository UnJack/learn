package org.learn.tech.juc;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by jimjian on 2016/12/2.
 */
public class test_Future2 {
    public static void main(String[] args) {

        FutureTask future = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return new Date().hashCode();
            }
        });

        new Thread(future).start();
        try {
            Thread.sleep(5000);
            System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
