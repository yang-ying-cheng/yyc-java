package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/2/28 10:25
 */

public class CountDownLatchJuc {
    public static void main(String[] args) throws InterruptedException {
        // 这里的 2 代表等待几个点或者是几个线程
        CountDownLatch c = new CountDownLatch(4);
        Thread t1 = new Thread(() -> {
            String name = Thread.currentThread().getName();

                // 延长 3s
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + ":第一节点执行完毕！");
            c.countDown();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":第二节点执行完毕！");
            c.countDown();
        });
        Thread t2 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                // 延长 5s
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":执行完毕！");
            c.countDown();
        });
        t1.start();
        t2.start();
        c.await();
        System.out.println("主线程执行完毕！");
    }
}
