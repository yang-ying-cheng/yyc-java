package Thread;

public class TestSynchronized {
    public static void main(String[] args) {
        // 对TestSynchronized.class进行加锁
        synchronized (TestSynchronized.class){

        }
        // 同步静态方法,对TestSynchronized.class进行加锁
        fun();

    }
    public static synchronized void fun(){

    }
}
