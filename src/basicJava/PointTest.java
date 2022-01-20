package basicJava;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/1/19 14:37
 */

public class PointTest {

    private static int flag = 1;

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 100; i++) {

            sum+=i;
            if(i == 50){
                flag = 3;
            }
        }
        System.out.println(sum);
    }
}
