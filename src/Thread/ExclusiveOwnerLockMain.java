package Thread;

import java.util.concurrent.TimeUnit;

public class ExclusiveOwnerLockMain {
    static ExclusiveOwnerLock lock = new ExclusiveOwnerLock();
//    static ReentrantLock lock = new ReentrantLock();

    static int a = 0;


    public static void main(String[] args) {

//        currentFun(true);
//        System.out.println("=============================");
        currentFun(false);
    }


    public static void fun() {

        if (a > 5) {
            a = 0;
            System.out.println("**************************");
        } else {
            try{
                lock.lock();
                a++;
                System.out.println(a);
            }finally {
                lock.unlock();
            }
            // 递归调用自己
            fun();
        }
    }

    public static void funCurrent() {

        if (a > 5) {
            a = 0;
            System.out.println("**************************");
        } else {
            a++;
            System.out.println(a);
            // 递归调用自己
            fun();
        }
    }

    public static void currentFun(boolean isCurrent) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isCurrent){
                    fun();
                }else{
                    funCurrent();
                }


            }, "thread-" + i);
            thread.start();
        }

    }

}
