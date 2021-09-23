package Thread;

/**
 * 守护线程
 */
public class DaemonThread {
    public static void main(String[] args) {
        // 自定义线程的时候，要添加线程名字，方便定位
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        // 设置为守护线程
        thread.setDaemon(true);
        thread.start();
    }
}

class DaemonRunner implements Runnable{

    @Override
    public void run() {
        // 让线程睡眠10s
        try {
            SleepUtils.second(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("DaemonRunner finally Thread.run");
        }
    }
}
