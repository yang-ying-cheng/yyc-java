package localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocalDateTime {
    public static void main(String[] args) {
        // Date 转 LocalDateTime
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println( "localDateTime: " +  localDateTime);

        // LocalDateTime 转 Date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Date date1 = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println( "date1: " +  date1);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }
}
