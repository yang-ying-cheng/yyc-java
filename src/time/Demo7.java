package time;

/**
 * 获取当前月第一天以及最后一天
 *
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/7/31 19:50
 */

public class Demo7 {
    public static void main(String[] args) {
        //LocalDate date = LocalDate.now();
        //// 获取当前月的第一天
        //LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
        //// 获取当前月的最后一天
        //LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        //System.out.println(firstDay);
        //System.out.println(lastDay);
        //System.out.println(String.valueOf(null));
        //System.out.println(LocalDateTime.now());
        //boolean b = Boolean.TRUE;
        //String s = "001";
        //Integer a = 1;
        //String a = "A";
        //char c = "B".charAt(0);
        //int a = (int)c +1;
        //
        //
        //
        //System.out.println("11"+(char)a);
        //String a = "12";
        //System.out.println(a.substring(0,1));
        //System.out.println((char) ('Z'+1));

        //String str = "20.1897%";
        //if(str.matches("^(\\d|[1-9]\\d|100)(\\.\\d{1,6})?%$")){
        //    System.out.println("111111");
        //}else{
        //    System.out.println("22222");
        //}
        //String e = "a,b,c";
        //String s = e.substring(0, e.lastIndexOf(","));
        //System.out.println(s);
        //NumberFormat nf = NumberFormat.getNumberInstance();
        //nf.setMaximumFractionDigits(2);
        //nf.setRoundingMode(RoundingMode.HALF_UP);
        //DecimalFormat df = new DecimalFormat("#0.000");
        //BigDecimal bigDecimal = new BigDecimal("123456.01050");
        //System.out.println(nf.format(bigDecimal));
        for (String s : "1/2".split("/")) {
            System.out.println(s);
        }
        //System.out.println();
        //System.out.println(bigDecimal.setScale(3, RoundingMode.HALF_UP));

    }
}

