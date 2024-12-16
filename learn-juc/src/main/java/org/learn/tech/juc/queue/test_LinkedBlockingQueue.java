package org.learn.tech.juc.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jimjian on 2020-01-01.
 */
public class test_LinkedBlockingQueue {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> linkBlockingQueue = new LinkedBlockingQueue(10);
        for (int i = 0; i < 10; i++) {
            //add如果队列已满，会抛异常
//            linkBlockingQueue.add(i);
            //将指定的元素添加到队列的尾部，如有必要，则等待空间变得可用，如果空间满了，则会一直等到空间可用时，进行插入。
//            linkBlockingQueue.put(i);
            //在尾部插入一个元素，如果有必要，等待指定的时间，使得队列变得可用。返回boolean值  表示是否插入成功。
            linkBlockingQueue.offer(i);
        }

//        for (Integer integer : linkBlockingQueue)
//            System.out.println(integer);

        //出队列
//        linkBlockingQueue.poll();
        try {
            System.out.println(linkBlockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size:" + linkBlockingQueue.size());
    }
}
