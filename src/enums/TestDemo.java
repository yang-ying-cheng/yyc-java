package enums;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/24 10:29
 */

public class TestDemo {
    public static void main(String[] args) {
        //System.out.println(TestOneEnum.READ.equals(TestOneEnum.GREEN));
        //System.out.println(TestTwoEnum.ONE.getValue());
        //System.out.println(TestThreeEnum.ONE.getKey());
        //System.out.println(TestThreeEnum.ONE.getValue());
        //System.out.println(TestThreeEnum.ONE.equals(TestThreeEnum.ONE));
        //System.out.println(TestThreeEnum.ONE.equals(TestThreeEnum.TWO));
        //System.out.println(TestThreeAndOneEnum.getValueByKey("one"));
        System.out.println(TestFourEnum.SECONDS.toSeconds(86400));// 60s
        System.out.println(TestFourEnum.SECONDS.toMinutes(86400));// 1m
        System.out.println(TestFourEnum.SECONDS.toHours(86400));//
        System.out.println(TestFourEnum.SECONDS.toDays(86400));
    }
}
