package basicJava;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("9");
        BigDecimal b2 = new BigDecimal("3");
        BigDecimal[] bigDecimals = b1.divideAndRemainder(b2);
        //商
        System.out.println(bigDecimals[0]);
        // 余数
        System.out.println(bigDecimals[1]);

    }
}
