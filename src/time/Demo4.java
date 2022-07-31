package time;

import java.time.LocalDate;

/**
 * 判断年份是否是闰年
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 18:50
 */

public class Demo4 {

    public static void main(String[] args) {
        // 2022 年
        LocalDate today = LocalDate.now();
        System.out.println(today.isLeapYear());
        LocalDate date = today.plusYears(-2L);
        // 2020年
        System.out.println(date.isLeapYear());


    }
}
