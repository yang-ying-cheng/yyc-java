package LocalDateTime;

import java.time.Duration;
import java.time.LocalDateTime;

public class DifferenceDayOrMonth {
    public static void main(String[] args) {
        LocalDateTime startDate = LocalDateTime.now();
        //LocalDateTime endDate = startDate.plusDays(60);
        LocalDateTime endDate = startDate.plusYears(1);

        Duration between = Duration.between(startDate, endDate);
        System.out.println(between.toNanos());//到纳秒
        System.out.println(between.toMillis());//到毫秒
        System.out.println(between.toMinutes());//到分钟
        System.out.println(between.toHours());//到小时
        System.out.println(between.toDays());//到天
    }
}
