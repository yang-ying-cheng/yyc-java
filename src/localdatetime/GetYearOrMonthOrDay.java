package localdatetime;

import java.time.*;

public class GetYearOrMonthOrDay {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        // ****************获取年*****************
        int year = localDateTime.getYear();
        int year1 = localDate.getYear();
        System.out.println("year:" + year);
        System.out.println("year1:" + year1);

        // ****************获取月*****************
        // 返回month类型
        Month month = localDateTime.getMonth();
        Month month1 = localDate.getMonth();
        // 返回int类型
        int monthValue = localDateTime.getMonthValue();
        int monthValue1 = localDate.getMonthValue();
        System.out.println( "month:" + month);
        System.out.println( "month1:" + month1);
        System.out.println( "monthValue:" + monthValue);
        System.out.println( "monthValue1:" + monthValue1);

        // ****************获取日*****************
        // 获取一年的中的某一天
        int dayOfYear = localDateTime.getDayOfYear();
        int dayOfYear1 = localDate.getDayOfYear();
        // 获取月份中的某一天
        int dayOfMonth = localDateTime.getDayOfMonth();
        int dayOfMonth1 = localDate.getDayOfMonth();
        // 获取星期中的某一天
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        DayOfWeek dayOfWeek1 = localDate.getDayOfWeek();
        System.out.println("dayOfYear:" + dayOfYear);
        System.out.println( "dayOfYear1:" + dayOfYear1);
        System.out.println( "dayOfMonth:" + dayOfMonth);
        System.out.println( "dayOfMonth1:" + dayOfMonth1);
        System.out.println( "dayOfWeek:" + dayOfWeek);
        System.out.println( "dayOfWeek1:" + dayOfWeek1);

    }
}
