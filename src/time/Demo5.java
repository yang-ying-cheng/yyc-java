package time;

import java.time.LocalDate;
import java.time.Period;

/**
 * 计算两个日期之间的相差的天数、月数、年数
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 18:55
 */

public class Demo5 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(2020, 1, 1);
        Period between = Period.between( date,today);
        // 相差年数
        System.out.println(between.getYears());
        // 相差月数
        System.out.println(between.getMonths());
        // 相差天数
        System.out.println(between.getDays());
    }

}
