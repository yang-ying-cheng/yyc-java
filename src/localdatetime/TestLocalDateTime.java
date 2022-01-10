package localdatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().plusDays(-31);
        System.out.println(now);

        // string 和 LocalDateTime 相互转换
        DateTimeFormatter partten = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now1 = LocalDateTime.parse("2021-12-31 00:00:00",partten);
        System.out.println(now1);

    }
}
