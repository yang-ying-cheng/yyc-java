package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {

    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    // 读锁
    static Lock readLock = lock.readLock();
    // 写锁
    static Lock writeLock = lock.writeLock();

    /**
     * 获取key对应的value
     *
     * @param key
     * @return
     */
    public static final Object getKey(String key) {
        try {
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 放进缓存中
     * @param key key
     * @param object value
     * @return
     */
    public static Object put(String key, Object object) {

        try {
            writeLock.lock();
            return map.put(key, object);
        } finally {
            writeLock.unlock();
        }
    }

    public static void clear() {
        try {
            writeLock.lock();
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }
}
