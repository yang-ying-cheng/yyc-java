package time;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/30 20:33
 */

public class TimeDemo1 {
    public static void main(String[] args) {
        // 获取今天的日期
        LocalDate now = LocalDate.now();
        // 获取今天的日期
        LocalDateTime now1 = LocalDateTime.now();
        LocalDate today = LocalDate.of(2022, 7, 30);
        LocalDate today1 = LocalDate.of(2022, 7, 28);
        LocalDate today2 = LocalDate.of(2022, 8, 31);
        //System.out.println(now);
        //System.out.println(now1);
        // 获取年
        //System.out.println(now.getYear());
        //// 获取月
        //System.out.println(now.getMonthValue());
        //// 获取日
        //System.out.println(now.getDayOfMonth());
        //// 生成特定的日期
        //System.out.println(today);

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
