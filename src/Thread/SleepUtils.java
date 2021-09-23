package Thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    /**
     * 线程睡眠工具类
     * @param seconds 秒数
     */
    public static final void second(long seconds) throws InterruptedException {

            TimeUnit.SECONDS.sleep(seconds);

    }
}
