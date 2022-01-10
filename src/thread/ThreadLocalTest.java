package thread;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    // 第一次 get（）方法调用时会进行初始化（如果 set 方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> LOCAL = new ThreadLocal<>();
    protected Long initialValue(){
        return System.currentTimeMillis();
    }
    public static final void begin(){
        LOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis() - LOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(ThreadLocalTest.end() + "s");
    }

}
