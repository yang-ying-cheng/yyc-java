package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCachedThreadPool
 * <p>
 * newCachedThreadPool将创建一个可缓存的线程池，如果线程池的规模超过了处理需求时，那么将回收空闲的线程，而当需求增加时，则可以添加新的线程，线程池的规模不存在任何限制。
 * <p>
 * 缺点：corePoolSize=0，maxPoolSize为很大的数，同步移交队列，也就是说不维护常驻线程(核心线程)，每次来请求直接创建新线程来处理任务，也不使用队列缓冲，会自动回收多余线程，由于将maxPoolSize设置成Integer.MAX_VALUE，当请求很多时就可能创建过多的线程，导致资源耗尽OOM。
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/3/1 20:22
 */

public class NewCachedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executor1 = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
    }
}
