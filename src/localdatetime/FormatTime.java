package localdatetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2023/5/4 09:41
 */

public class FormatTime {

    private static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static void main(String[] args) {
        test("2023-03-01 21:01:01 , 2023-04-01 21:01:01");

    }

    private static void test(String param) {

//        if (param != null) {
//            String[] split = param.split(",");
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_FULL);
//            try {
//                LocalDateTime startDate = LocalDateTime.parse(split[0].trim(), formatter);
//                LocalDateTime endDate = LocalDateTime.parse(split[1].trim(), formatter);
//                long days = Duration.between(startDate, endDate).toDays();
//                if(days > 31){
//                    throw new IllegalArgumentException("时间不能超过30天！");
//                }
//
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                return;
//            }
//            System.out.println("123123");
//        }
        System.out.println(toTimeMonthRange("2023-12"));
        System.out.println(toTimeQuarterRange("2023-12"));
    }

    /**
     * 获取时间范围（月度）
     * <p>
     * 比如传进去一个2023-05，返回值为2023-05-01~2023-05-31
     *
     * @return 结果
     */
    public static String toTimeMonthRange(String ym) {
        String date = ym + "-01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.with(TemporalAdjusters.firstDayOfMonth()) + "~" + localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取时间范围（季度）
     * <p>
     * 比如传进去一个2023-05，返回值为2023-05-01~2023-05-31
     *
     * @return 结果
     */
    public static String toTimeQuarterRange(String ym) {
        String date = ym + "-01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
        LocalDate localDate = LocalDate.parse(date, formatter);
        Month month = localDate.getMonth();
        Month firstMonthOfQuarter = month.firstMonthOfQuarter();
        Month endMonthOfQuarter = Month.of(firstMonthOfQuarter.getValue() + 2);
        return LocalDate.of(localDate.getYear(), firstMonthOfQuarter, 1) + "~" + LocalDate.of(localDate.getYear(), endMonthOfQuarter, endMonthOfQuarter.length(localDate.isLeapYear()));
    }
}
