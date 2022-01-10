package exceptionfolder;

public class TryTest {
    public static void main(String[] args) {
        System.out.println(fun());

    }

    public static String fun() {
        boolean flag = true;
        try {
            int a = 2 / 1;
            flag = false;
            return "try";

        } catch (Exception e) {
            return "catch";
        } finally {
            if(flag)
            return "finally";
        }
    }
}
/**



 */