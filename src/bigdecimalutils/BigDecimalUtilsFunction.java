package bigdecimalutils;

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
        if (t == null) {
            throw new NullPointerException("t不能为 null！");
        }
        String str = String.valueOf(t);
        if (!str.matches("[+-]?[0-9]+(\\.[0-9]+)?")) {
            throw new IllegalArgumentException("参数不符合规范！");
        }
        return new BigDecimal(str);
    }

    // --------------------------基本运算---------------------------

    /**
     * 相加
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 相加结果
     */
    public static <T> BigDecimal calculateAdd(T a, T b) {
        return toBigDecimal(a).add(toBigDecimal(b));
    }

    /**
     * 相减
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 相减结果
     */
    public static <T> BigDecimal calculateSubtract(T a, T b) {
        return toBigDecimal(a).subtract(toBigDecimal(b));
    }

    /**
     * 相乘
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 积
     */
    public static <T> BigDecimal calculateMultiply(T a, T b) {
        return toBigDecimal(a).multiply(toBigDecimal(b));
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
    public static <T> BigDecimal calculateDivide(T a, T b, int scale, RoundingMode roundingMode) {
        return toBigDecimal(a).divide(toBigDecimal(b), scale, roundingMode);
    }

    /**
     * 相除
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return 商
     */
    public static <T> BigDecimal calculateDivide(T a, T b) {
        return toBigDecimal(a).divide(toBigDecimal(b), 2, RoundingMode.HALF_UP);
    }

    /**
     * 相除
     *
     * @param a     参数 A
     * @param b     参数 B
     * @param scale 保留小数位数
     * @return 商
     */
    public static <T> BigDecimal calculateDivide(T a, T b, int scale) {
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
    public static <T> boolean isAMoreThanB(T a, T b) {
        return toBigDecimal(a).compareTo(toBigDecimal(b)) > 0;
    }

    /**
     * A 小于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A < B ;false A > B
     */
    public static <T> boolean isALessThanB(T a, T b) {
        return toBigDecimal(a).compareTo(toBigDecimal(b)) < 0;
    }

    /**
     * A 等于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A == B ;false A ！= B
     */
    public static <T> boolean isAEqualB(T a, T b) {
        return toBigDecimal(a).compareTo(toBigDecimal(b)) == 0;
    }

    /**
     * A 大于等于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A >= B ;false A < B
     */
    public static <T> boolean isAMoreThanOrEqualB(T a, T b) {
        return toBigDecimal(a).compareTo(toBigDecimal(b)) > -1;
    }

    /**
     * A 小于等于 B
     *
     * @param a 参数 A
     * @param b 参数 B
     * @return true :A <= B ;false A > B
     */
    public static <T> boolean isALessThanOrEqualB(T a, T b) {
        return toBigDecimal(a).compareTo(toBigDecimal(b)) < 1;
    }

    public static void main(String[] args) {
        //BigDecimal a = BigDecimal.ONE;
        //BigDecimal b = BigDecimal.valueOf(3);
        System.out.println(toBigDecimal("-1:2000000"));
        //System.out.println("a+b:" + calculateAdd(a, b));
        //System.out.println("a-b:" + calculateSubtract(a, b));
        //System.out.println("a*b:" + calculateMultiply(a, b));
        //System.out.println("a/b:" + calculateDivide(a, b));
        //System.out.println("a/b:" + calculateDivide(a, b, 2));
        //System.out.println("a/b:" + calculateDivide(a, b, 4, RoundingMode.HALF_UP));
        //System.out.println("a>b:" + isAMoreThanB(a, b));
        //System.out.println("a<b:" + isALessThanB(a, b));
        //System.out.println("a=b:" + isAEqualB(a, b));
        //System.out.println("a>=b:" + isAMoreThanOrEqualB(a, b));
        //System.out.println("a<=b:" + isALessThanOrEqualB(a, b));

    }


}
