package basicJava;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BigDecimalTest {
    public static void main(String[] args) {
//        BigDecimal b1 = new BigDecimal("9");
//        BigDecimal b2 = new BigDecimal("3");
//        BigDecimal[] bigDecimals = b1.divideAndRemainder(b2);
//        //商
//        System.out.println(bigDecimals[0]);
//        // 余数
//        System.out.println(bigDecimals[1]);

//        A a = new A();
//        A b = null ;
//        String name = Optional.of(a).get().getName();
//        String name1 = Optional.ofNullable(b).o.get().getName();
//        System.out.println(name);
//        System.out.println(name1);
//        BigDecimal a = null;
//        System.out.println(Optional.ofNullable(a).orElse(BigDecimal.ZERO));
//        Integer integer = Integer.valueOf("");
//        System.out.printf(integer.toString());
//        String completeWorkStr = "120.1212%";
//        System.out.println(completeWorkStr.substring(0, completeWorkStr.length() - 1));
        LocalDate now = LocalDate.now();
        LocalDate localDate = LocalDate.now().plusDays(1);
        System.out.println(now.until(localDate, ChronoUnit.DAYS));
    }
}
