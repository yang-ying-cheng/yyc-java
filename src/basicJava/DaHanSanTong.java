package basicJava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/4/3 10:33
 */

public class DaHanSanTong {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        int people = 10;
        for (int i = 1; i <= people; i++) {
            list.add(i);
        }

        int count = 0;
        int index = 0;
        while (people != 1) {
            count++;
            if (index >= people) {
                index = 0;
            }
//            System.out.println("now-people=" + list.get(index));
            if (count == 3) {
                count = 0;
                people--;
//                System.out.println(list.get(index));
                list.remove(index);
            }
            index++;
        }
        System.out.println(list.get(0));
    }
}

