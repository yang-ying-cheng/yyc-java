package threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 特点：newScheduledThreadPool创建了一个固定长度的线程池，而且以延迟或定时的方式来执行任务。
 * <p>
 * 缺点：支持定时周期性执行，注意一下使用的是延迟队列，弊端同newCachedThreadPool一致。
 * 那么上面说了使用Executors工具类创建的线程池有隐患，那如何使用才能避免这个隐患呢？如何才是最优雅的方式去使用过线程池吗？
 * 生产环境要怎么去配置自己的线程池才是合理的呢？需要对症下药，建立自己的线程工厂类，灵活设置关键参数。
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/3/1 20:38
 */

public class NewScheduledThreadPoolDemo {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(10, Executors.defaultThreadFactory());


    }
}
