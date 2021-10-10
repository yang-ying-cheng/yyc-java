package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsNewFixedThreadPool {
    public static void main(String[] args) {
        // 创建 拥有 10 个容量的线程池
        ExecutorService fixtThreadPool = Executors.newFixedThreadPool(10);
        // 创建一池一线程的线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 一池可扩容线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //fun(fixtThreadPool);
        //fun(singleThreadExecutor);
        fun(cachedThreadPool);
    }

    public static void fun(ExecutorService threadPool){
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "业务操作~~");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 无论如何，也要让线程池关闭
            threadPool.shutdown();
        }
    }
}
