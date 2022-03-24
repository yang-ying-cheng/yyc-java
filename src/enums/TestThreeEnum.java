package enums;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/24 10:48
 */

public enum TestThreeEnum {
    ONE("one","我是 1 号"),
    TWO("two","我是 2 号")
    ;

    private final String key;
    private final String value;

    TestThreeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
