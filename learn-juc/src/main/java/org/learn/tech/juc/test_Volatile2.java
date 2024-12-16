package org.learn.tech.juc;

/**
 * User: jimjian
 * Date: 16-4-5 上午10:38
 * volatile防止指令重排序
 */
public class test_Volatile2 extends Thread {
    //设置类静态变量,各线程访问这同一共享变量
    private static boolean flag = false;
//    private static volatile boolean flag = false;

    //无限循环,等待flag变为true时才跳出循环
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (!flag) {
        }
    }

    public static void main(String[] args) throws Exception {
        new test_Volatile2().start();
        //sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了
        Thread.sleep(1000);
        flag = true;
        System.out.println(Thread.currentThread().getName());
    }
}
