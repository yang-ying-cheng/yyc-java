package enums;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/24 10:31
 */

public enum TestTwoEnum {
    ONE("我是 1"),
    TWO("我是 2")
    ;
    /**
     * 定义一个属性
     */
    private final String value;

    TestTwoEnum( String value) {
        this.value = value;

    }
    /**
     * 获取属性
     * @return 获取执行枚举的属性值
     */
    public String getValue() {
        return value;
    }
}
