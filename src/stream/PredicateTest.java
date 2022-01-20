package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/1/20 14:18
 */

public class PredicateTest {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Predicate<Integer> integerPredicate = e -> e > 5;
        List<Integer> result = list.stream().filter(integerPredicate).collect(Collectors.toList());
        String a = "1,11,2";
        fun(a,e -> System.out.println(a));
    }

    public static <T> void fun(String a, Consumer<String> t) {
         t.accept(a);
    }





}
