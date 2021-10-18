package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 独占锁(不可重入锁)
 * 它在同一时刻只允许一个线程占用锁。Metex中定义了一个静态内部类，该内部类继承了同步器并实现了独占式获取和释放同步状态。
 */
public class Mutex implements Lock {
    // 静态内部类，自定义同步器,推荐使用静态内部类？
    private static class Sync extends AbstractQueuedSynchronizer{
        // 返回当前状态的值
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
        // 当状态为0的时候获取锁
        public boolean tryAcquire(int acquires){
            // 0表示锁定状态，1表示锁定状态
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 释放锁，将状态设置为 0，试图设置状态来反映独占模式下的一个释放。
        protected boolean tryRelease(int release){
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            // 设置当前拥有独占访问权限的线程。 null 参数表示没有线程拥有访问权限
            setExclusiveOwnerThread(null);
            // 设置同步状态的值。
            setState(0);
            return true;
        }
        Condition newCondition(){
            // 返回一个Condition，每个condition都包含了一个condition队列
            return new ConditionObject();
        }
    }
    // 仅需要将操作代理到Sync上即可
    private final Sync sync = new Sync();

    @Override
    public void lock(){
        // 以独占模式获取对象，忽略中断
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        // 试图在独占模式下获取对象状态。
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        // 试图以独占模式获取对象，如果被中断则中止，如果到了给定超时时间，则会失败。
        return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }

    @Override
    public void unlock() {
        //  以独占模式释放对象。
        sync.release(1);
    }

    @Override
    public Condition newCondition() {

        return sync.newCondition();
    }

    public boolean isLocked(){
        // 判断同步对于当前线程是否是独立的
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads(){
        // 查询是否有正在等待获取的任何线程。
        return sync.hasQueuedThreads();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // 以独占模式获取对象，如果被中断则中止。
        sync.acquireInterruptibly(1);
    }


}
