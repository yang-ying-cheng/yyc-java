package time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * 获取当前月第一天以及最后一天
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 19:50
 */

public class Demo7 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        // 获取当前月的第一天
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
        // 获取当前月的最后一天
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(firstDay);
        System.out.println(lastDay);
    }
}

