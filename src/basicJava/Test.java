package basicJava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/4/1 10:22
 */

public class Test {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        List<Integer> collect = a.stream().filter(e -> e.equals(1)).collect(Collectors.toList());
        System.out.println(collect);

    }
}
