package basicJava;

import java.time.LocalDate;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/2/25 15:01
 */

public class FunctionJava {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.compareTo(now));
        //Predicate<String> predicate = (e) -> {
        //    return e.length() > 3 && e.contains("12");
        //};
        //
        //System.out.println(predicate.test("12"));
        //System.out.println(fun(1, e -> e+"a223",e->"333"));
    }


    //public static String fun(Integer target, Function<String, Integer> function,Function<String,String> function2) {
    //    return function.andThen(function2).apply(target);
    //}
}
