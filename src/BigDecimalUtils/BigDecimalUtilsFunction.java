package BigDecimalUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtilsFunction {

    // --------------------------转化---------------------------

    /**
     * 转为 BigDecimal
     *
     * @param t   参数
     * @param <T> 参数类型
     * @return BigDecimal
     */
    public static <T> BigDecimal toBigDecimal(T t) {
        return new BigDecimal(String.valueOf(t));
    }

    // --------------------------基本运算---------------------------

    /**
     * 相加
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 相加结果
     */
    public static BigDecimal calculateAdd(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    /**
     * 相减
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 相减结果
     */
    public static BigDecimal calculateSubtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    /**
     * 相乘
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 积
     */
    public static BigDecimal calculateMultiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    /**
     * 相除
     *
     * @param a            参数 A
     * @param b            参数 B
     * @param scale        保留小数位数
     * @param roundingMode 保留小数规则
     * @return 商
     */
    public static BigDecimal calculateDivide(BigDecimal a, BigDecimal b, int scale, RoundingMode roundingMode) {
        return a.divide(b, scale, roundingMode);
    }

    /**
     * 相除
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 商
     */
    public static BigDecimal calculateDivide(BigDecimal a, BigDecimal b) {
        return calculateDivide(a, b, 2, RoundingMode.HALF_UP);
    }

    /**
     * 相除
     *
     * @param a     参数 A
     * @param b     参数 B
     * @param scale 保留小数位数
     * @return 商
     */
    public static BigDecimal calculateDivide(BigDecimal a, BigDecimal b, int scale) {
        return calculateDivide(a, b, scale, RoundingMode.HALF_UP);
    }
    // --------------------------比较大小---------------------------

    /**
     * A 大于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A > B ;false A < B
     */
    public static boolean isAMoreThanB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > 0;
    }

    /**
     * A 小于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A < B ;false A > B
     */
    public static boolean isALessThanB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 0;
    }

    /**
     * A 等于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A == B ;false A ！= B
     */
    public static boolean isAEqualB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 0;
    }

    /**
     * A 大于等于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A >= B ;false A < B
     */
    public static boolean isAMoreThanOrEqualB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > -1;
    }

    /**
     * A 小于等于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A <= B ;false A > B
     */
    public static boolean isALessThanOrEqualB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 1;
    }

    public static void main(String[] args) {
        BigDecimal a = toBigDecimal(1.01);
        BigDecimal b = toBigDecimal(1.01);
        System.out.println("a+b:" + calculateAdd(a, b));
        System.out.println("a-b:" + calculateSubtract(a, b));
        System.out.println("a*b:" + calculateMultiply(a, b));
        System.out.println("a/b:" + calculateDivide(a, b));
        System.out.println("a/b:" + calculateDivide(a, b, 2));
        System.out.println("a/b:" + calculateDivide(a, b, 4, RoundingMode.HALF_UP));
        System.out.println("a>b:" + isAMoreThanB(a, b));
        System.out.println("a<b:" + isALessThanB(a, b));
        System.out.println("a=b:" + isAEqualB(a, b));
        System.out.println("a>=b:" + isAMoreThanOrEqualB(a, b));
        System.out.println("a<=b:" + isALessThanOrEqualB(a, b));

    }


}
