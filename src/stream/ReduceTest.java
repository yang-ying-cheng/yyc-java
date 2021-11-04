package stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        BigNum bigNum = new BigNum(new BigDecimal("100"), "001");
        BigNum bigNum1 = new BigNum(new BigDecimal("200"), "002");
        BigNum bigNum2 = new BigNum(new BigDecimal("300"), "003");
        BigNum bigNum3 = new BigNum(new BigDecimal("400"), "004");
        BigNum[] bigNums = {bigNum,bigNum1,bigNum2,bigNum3};
        List<BigNum> list = Arrays.asList(bigNums);
//        List<BigNum> list = new ArrayList<>();
        BigDecimal reduce;
        reduce = list.stream().map(BigNum::getNum).reduce(BigDecimal::add).orElseGet(() -> {
            System.out.println("1111");
            return new BigDecimal("1");
        });

//        reduce = list.stream().map(BigNum::getNum).reduce(BigDecimal::add).orElse(fun ());
        /**
         * 执行结果
         * 111
         * 1000
         */
        System.out.println(reduce);


    }

   public static BigDecimal fun (){
       System.out.println("111");
        return new BigDecimal("2");
   }
}

class BigNum{
    private BigDecimal num;
    private String name;

    public BigNum(BigDecimal num, String name) {
        this.num = num;
        this.name = name;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BigNum{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}