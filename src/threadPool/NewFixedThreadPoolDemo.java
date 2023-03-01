package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool 线程池使用样例
 * <p>
 * newFixedThreadPool将创建一个固定长度的线程池，每当提交一个任务时就创建一个线程，直到达到线程池的最大数量，这时线程池的规模将不再变化（如果某个线程由于发生了未预期的Exception而结束，那么线程池会补充一个新的线程。
 * <p>
 * 缺点：
 * 设置了corePoolSize=maxPoolSize，keepAliveTime=0(此时该参数没作用)，无界队列，任务可以无限放入，当请求过多时(任务处理速度跟不上任务提交速度造成请求堆积)可能导致占用过多内存或直接导致OOM异常。
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/3/1 20:09
 */

public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorService executor1 = Executors.newFixedThreadPool(10,Executors.defaultThreadFactory());


    }
}
