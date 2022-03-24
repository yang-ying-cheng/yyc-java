package dataStructure;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/7 17:00
 */

public class ConcurrentHashMapTest {


    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("1",null);
        System.out.println(map.toString());
    }
}
