package thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WaitOrNotifyThread {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitThread(),"waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new NotifyThread(),"notifyThread");
        notifyThread.start();
    }
    static class WaitThread implements Runnable{

        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        // wait的时候是会释放锁，要不然notify是获取不到锁的
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        }
    }

    static class NotifyThread implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                // 获取锁，然后进行通知，通知不会释放lock的锁
                // 直到当前线程释放了lock后，waitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                lock.notifyAll();
                flag = false;
                // 睡眠5秒
                try {
                    SleepUtils.second(5);
                    System.out.println(Thread.currentThread() + " hold lock. notify @ end" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 测试waitThread线程
            try {
                SleepUtils.second(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                try {
                    SleepUtils.second(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
