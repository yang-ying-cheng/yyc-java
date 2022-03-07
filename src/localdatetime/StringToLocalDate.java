package localdatetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/7 10:25
 */

public class StringToLocalDate {
    public static void main(String[] args) {
        LocalDate yyyy = LocalDate.parse("2022-02-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(yyyy);
    }
}
