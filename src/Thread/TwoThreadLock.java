package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwoThreadLock implements Lock {

    private final Sync sync = new Sync(2);

    private static class Sync extends AbstractQueuedSynchronizer{

        public Sync(int count) {
            if(count <= 0 ){
                // 抛出参数必须大于0的异常
                throw new IllegalArgumentException("参数必须大于0！");
            }
            // 设置status的值
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            // 死循环来设置status的值
            for(;;){
                // 获取当前状态的值
                int currentStatus = getState();
                // 每次进来一个线程，资源数 -1
                int reduceStatus = currentStatus - arg;
                // 如果资源数 >=0 ，设置该状态并返回
                // 或者是资源数 < 0 返回改状态值
                if(reduceStatus < 0 || compareAndSetState(currentStatus,reduceStatus) ){
                    return reduceStatus;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {

            for(;;){
                // 死循环设置状态值
                int currentStatus = getState();
                int sumStatus = currentStatus + arg;
                if(compareAndSetState(currentStatus,sumStatus)){
                    return true;
                }
            }
        }
    }


    @Override
    public void lock() {
        // 获取同步状态
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        // 释放同步状态
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    // 测试同步工具
    public static void main(String[] args) throws InterruptedException {
        TwoThreadLock lock = new TwoThreadLock();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() ->{
                try {

                    lock.lock();
                    TimeUnit.SECONDS.sleep(1);
                    fun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            },"thread-" + i);
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("**********");
        }
    }

    public static void fun(){
        System.out.println(Thread.currentThread().getName());
    }
}
