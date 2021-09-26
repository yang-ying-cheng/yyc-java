package Thread;

public interface ThreadPool<Job extends Runnable> {
    // 执行一个 job，这个 job需要实现 Runnable
    void execute(Job job);
    // 关闭线程池
    void shutdown();
    // 增加工作者线程
    void addWorkers(int num);
    // 减少工作者线程
    void removeWorker(int num) throws IllegalAccessException;
    // 得到正在等带执行的任务数量
    int getJobSize();
}
