package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor是一个单线程的Executor，它创建单个工作线程来执行任务，如果这个线程异常结束，会创建另一个线程来代替。newSingleThreadExecutor能确保依照任务在队列中的顺序来串行执行（例如FIFO、LIFO、优先级）。
 * <p>
 * 缺点：基本同 newFixedThreadPool，但是将线程数设置为了1，单线程，弊端和newFixedThreadPool 一致。
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/3/1 20:30
 */

public class NewSingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());


    }

}
