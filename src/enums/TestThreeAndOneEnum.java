package enums;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/24 10:57
 */

public enum TestThreeAndOneEnum {
    ONE("one", "我是 1 号"),
    TWO("two", "我是 2 号");

    private final String key;
    private final String value;

    TestThreeAndOneEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 根据 key，获取 value，类似于 map
     *
     * @param key 键
     * @return 值
     */
    public static String getValueByKey(String key) {
        TestThreeEnum[] values = TestThreeEnum.values();
        for (TestThreeEnum e : values) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        return null;
    }
}
