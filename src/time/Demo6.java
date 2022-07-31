package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式转化
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 19:23
 */

public class Demo6 {
    public static void main(String[] args) {
        String dateStr = "20220730";
        String dateStr1 = "2022-07-31";
        // 转化为LocalDate
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.BASIC_ISO_DATE);
        // 可以自定义格式
        DateTimeFormatter partten = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(localDate);
        System.out.println(LocalDate.parse(dateStr1,partten));
    }
}
