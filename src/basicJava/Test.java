package basicJava;

import java.time.LocalDate;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/4/1 10:22
 */

public class Test {

    public static void main(String[] args) {
        //List<Integer> a = new ArrayList<>();
        //List<Integer> collect = a.stream().filter(e -> e.equals(1)).collect(Collectors.toList());
        //System.out.println(collect);
        //String a = "bis/20230220230203155831P1ay.jpg";
        //System.out.println(a.substring(a.lastIndexOf(".")+1));
        LocalDate today = LocalDate.of(2022, 7, 30);
        LocalDate today1 = LocalDate.of(2022, 7, 30);
        LocalDate today2 = LocalDate.of(2022, 8, 31);

        System.out.println(today.equals(today1));
// today 是否在 today1之前
        System.out.println(today.isBefore(today1));
// today 是否在 today1之后
        System.out.println(today.isAfter(today1));

        System.out.println(today.equals(today2));
// today 是否在 today2之前
        System.out.println(today.isBefore(today2));
// today 是否在 today2之后
        System.out.println(today.isAfter(today2));

    }
}
