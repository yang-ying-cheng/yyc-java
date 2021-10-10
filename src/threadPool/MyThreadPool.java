package threadPool;

import java.util.concurrent.*;

public class MyThreadPool {
    public static void main(String[] args) {
        // 核心线程数量
        int corePoolSize = 10;
        // 最大线程数量
        int maximumPoolSize = 20;
        // 保持存活时间
        long keepAliveTime = 5l;
        // 时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        // 阻塞队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
        // 采用默认的线程工厂
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // 采用默认的拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);

        try {
            for (int i = 0; i < 20; i++) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "执行操作~");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
