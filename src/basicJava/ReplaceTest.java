package basicJava;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplaceTest {
    public static void main(String[] args) throws ParseException {
        String  s = "aaa?aaa?aaa";
        System.out.println(s.replace("?","1"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:SS:ss");
        //DateTimeFormatter partten = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:SS:ss");
        String s1 = "2022-01-01";
        //LocalDate parse = LocalDate.parse(s1, partten);
        new IOException();
        Date parse = sdf.parse(s1);


    }
}
