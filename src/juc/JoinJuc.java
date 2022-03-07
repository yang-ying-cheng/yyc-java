package juc;

import java.util.concurrent.TimeUnit;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/2/28 10:09
 */

public class JoinJuc {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                // 延长 3s
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":执行完毕！");
        });
        Thread thread2 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                // 延长 5s
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":执行完毕！");
        });
        thread1.start();
        thread2.start();
        thread1.join();
        //thread2.join();
        System.out.println("主线程执行完毕");
    }
}
