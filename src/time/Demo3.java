package time;

import java.time.LocalDate;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 17:53
 */

public class Demo3 {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        // 明天
        System.out.println("明天："+today.plusDays(1L));
        // 昨天
        System.out.println("昨天："+today.plusDays(-1L));
        // 一周后的今天
        System.out.println("一周后的今天："+today.plusWeeks(1L));
        // 一周前的昨天
        System.out.println("一周前的今天："+today.plusWeeks(-1L));
        // 一年前的今天
        System.out.println("一年前的今天："+today.plusYears(-1L));
        // 一年后的今天
        System.out.println("一年后的今天："+today.plusYears(1L));

    }
}
