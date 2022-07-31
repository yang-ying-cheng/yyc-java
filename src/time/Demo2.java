package time;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * 检查生日这种周期性的事件
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 17:40
 */

public class Demo2 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022,7,1);
        LocalDate today = LocalDate.now();
        MonthDay todayMonthAndDay = MonthDay.from(date);
        // 获取 月-日
        System.out.println(todayMonthAndDay);

        MonthDay birthday = MonthDay.of(today.getMonth(), today.getDayOfMonth());

        if(todayMonthAndDay.equals(birthday)){
            System.out.println("祝你生日快乐！");
        }else{
            System.out.println("抱歉！您的生日还没有到喔~");
        }
    }

}
