package basicJava;

import java.util.Arrays;
import java.util.List;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/4/21 13:34
 */

public class C {

    public static void main(String[] args) {

        //DateTimeFormatter parten = DateTimeFormatter.ofPattern("yyMMdd");
        //
        //String format = LocalDate.now().format(parten);
        //System.out.println(format);

        String s = "1|2|33";
        List<String> list = Arrays.asList("a", "b", "c");
        boolean b = list.stream().anyMatch("d"::equals);
        //String[] split = s.split("\\|");
        //for (int i = 0; i < split.length; i++) {
        //    System.out.println(split[i]);
        //
        //}
        System.out.println(s.contains("|"));


    }

}
