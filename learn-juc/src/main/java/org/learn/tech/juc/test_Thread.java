package org.learn.tech.juc;

import org.junit.Test;

/**
 * User: jimjian
 * Date: 16-3-17 下午4:53
 */
public class test_Thread {

    @Test
    public void test1() throws InterruptedException {
        int i = 0;
        while (i < 3) {
            m_Thread mThread1 = new m_Thread("A");
            m_Thread mThread2 = new m_Thread("B");
            m_Thread mThread3 = new m_Thread("C");
            Thread m1 = new Thread(mThread1);
            Thread m2 = new Thread(mThread2);
            Thread m3 = new Thread(mThread3);
            m1.start();
            m1.join();
            m3.start();
            m3.join();
            m2.start();
            m2.join();
            i++;
        }
    }

    class m_Thread implements Runnable {
        String mThread;

        m_Thread() {
        }

        m_Thread(String m) {
            this.mThread = m;
        }

        public void run() {
            System.out.print(mThread);
        }

        String getmThread() {
            return mThread;
        }

        void setmThread(String mThread) {
            this.mThread = mThread;
        }

    }

}
