package juc;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
    private static LockTest test = new LockTest();
    // 默认创建的是非公平锁
    private static final ReentrantLock lock = new ReentrantLock();

    // 创建公平锁
    //private static final ReentrantLock lock = new ReentrantLock(true);
    private static int count;


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(test);
        Thread thread2 = new Thread(test);
        thread1.start();
        thread2.start();

        // 等待两个线程都运行结束后，再打印结果
        thread1.join();
        thread2.join();

        //期待结果是20000，但是结果会小于这个值
        System.out.println(count);
    }

    /**
     * 多线程问题原因：count++这行代码要分三步执行；1：读取；2：修改；3：写入。
     * 在这三步中，任何一步都可能被其他线程打断，导致值还没来得及写入，就被其他线程读取或写入，这就是多线程并行操作共享变量导致的问题。
     */
    @Override
    public void run() {

        // =========== 不加锁 ===========
        //for (int k = 0; k < 10000; k++) {
        //    count++;
        //}


        // =========== 加synchronized ===========
        //synchronized (LockTest.class) {
        //    for (int k = 0; k < 10000; k++) {
        //        count++;
        //    }
        //}

        // =========== 加ReentrantLock ===========
        try {
            lock.lock();
            for (int k = 0; k < 10000; k++) {
                count++;
            }
        } finally {
            lock.unlock();
        }
    }
}
