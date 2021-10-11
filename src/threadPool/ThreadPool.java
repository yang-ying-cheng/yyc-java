package threadPool;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        // 核心线程数
        int corePoolSize = 16 + 2 * Runtime.getRuntime().availableProcessors();
        // 最大线程池
        int maximumPoolSize = 16 + 2 * Runtime.getRuntime().availableProcessors();
        // 闲置线程最大存活时间
        long keepAliveTime = 1000 * 60;
        // 存活时间单位
        TimeUnit unit = TimeUnit.MILLISECONDS;
        // 阻塞队列
        BlockingQueue workQueue = new LinkedBlockingQueue<>();
        // 线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();



    }


}
