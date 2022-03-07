package juc;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/2/18 17:18
 */

public class ConditionJUC implements Condition{
    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

    }

    @Override
    public void await() throws InterruptedException {

    }

    @Override
    public void awaitUninterruptibly() {

    }

    @Override
    public long awaitNanos(long nanosTimeout) throws InterruptedException {
        return 0;
    }

    @Override
    public boolean await(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public boolean awaitUntil(Date deadline) throws InterruptedException {
        return false;
    }

    @Override
    public void signal() {

    }

    @Override
    public void signalAll() {

    }
}
