package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
自定义实现可重入独占锁
 */
public class ExclusiveOwnerLock implements Lock {

    private final Sync sync;


    private static class Sync extends AbstractQueuedSynchronizer {
        /**
         * 获取锁或者是同步状态
         *
         * @param arg 参数
         * @return 是否获取成功
         */
        protected boolean tryAcquire(int arg) {
            final Thread currentThread = Thread.currentThread();
            int c = getState();
            // 如果是第一次
            if (c == 0) {
                // 通过CAS设置state的值
                if (compareAndSetState(0, arg)) {
                    // 设置线程独占
                    setExclusiveOwnerThread(currentThread);
                    return true;
                }
            } else if (currentThread == getExclusiveOwnerThread()) {
                int nextc = c + arg;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

        /**
         * 释放同步状态或者是锁
         * @param arg 状态参数
         * @return 是否完全释放
         */
        @Override
        protected boolean tryRelease(int arg) {

            int c = getState() - arg;
            if (!isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }

            boolean flag = false;

            if (c == 0) {
                flag = true;
                // 将独占线程置空
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return flag;
        }

        /**
         * 是否是独占
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

    }

    public ExclusiveOwnerLock() {
        sync = new Sync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
       return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
