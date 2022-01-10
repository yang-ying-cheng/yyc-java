package thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Deprecated {
    public static void main(String[] args) throws InterruptedException {

        DateTimeFormatter patten = DateTimeFormatter.ofPattern("HH:mm:ss");
        Thread printThread = new Thread(new Runner());
        printThread.setDaemon(true);
        printThread.start();
        // 睡眠3 秒
        TimeUnit.SECONDS.sleep(3);
        // 线程暂停
        printThread.suspend();
        System.out.println("暂停线程" + LocalDateTime.now().format(patten));
        TimeUnit.SECONDS.sleep(3);
        // 线程恢复
        printThread.resume();
        System.out.println("线程恢复" + LocalDateTime.now().format(patten));
        printThread.stop();
        System.out.println("线程终止" + LocalDateTime.now().format(patten));
        TimeUnit.SECONDS.sleep(3);
    }
}

class Runner implements Runnable{

    @Override
    public void run() {

        while (true){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter parten = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println(Thread.currentThread().getName() + "Run at " + now.format(parten));
            try {
                SleepUtils.second(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
