package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * stream 通用代码类型封装
 */
public class StreamUtils {
    /**
     * 通用转map方法(当key一样的时候，默认采用后value)
     *
     * @param list      list
     * @param predicate 过滤条件
     * @param function1 参数1
     * @param function2 参数2
     * @param <K>       key
     * @param <V>       value
     * @param <T>       实体类
     * @return map
     */
    public static <K, V, T> Map<K, V> listToMap(List<T> list, Predicate<T> predicate, Function<T, K> function1, Function<T, V> function2) {
        return listToMap(list, predicate, function1, function2, (a, b) -> b);
    }

    /**
     * 通用转map方法
     *
     * @param list      list
     * @param predicate 过滤条件
     * @param function1 参数1
     * @param function2 参数2
     * @param <K>       key
     * @param <V>       value
     * @param <T>       实体类
     * @return map
     */
    public static <K, V, T> Map<K, V> listToMap(List<T> list, Predicate<T> predicate, Function<T, K> function1, Function<T, V> function2, BinaryOperator<V> mergeFunction) {
        return list.stream().filter(predicate).collect(Collectors.toMap(function1, function2, mergeFunction));
    }

    /**
     * 通用类型分组
     *
     * @param list     目标集合
     * @param function 表达式
     * @param <K>      key
     * @param <T>      实体类
     * @return 分组结果
     */
    public static <K, T> Map<K, List<T>> listToGroup(List<T> list, Function<T, K> function) {
        return listToGroup(list, function);
    }

    /**
     * 通用类型分组
     *
     * @param list      目标集合
     * @param function  表达式
     * @param collector 表达式
     * @param <K>       key
     * @param <T>       实体类
     * @param <A>       分组后组内的数据类型
     * @return 分组结果(默认返回HashMap)
     */
    public static <K, T, A> Map<K, List<A>> listToGroup(List<T> list, Function<T, K> function, Function<T, A> collector) {
        return listToGroup(list, function, HashMap::new, collector);
    }


    /**
     * 通用类型分组
     *
     * @param list       目标集合
     * @param function   表达式
     * @param mapFactory 表达式
     * @param taFunction 表达式
     * @param <K>        key
     * @param <T>        实体类
     * @param <A>        分组后组内的数据类型
     * @return 分组结果(自定义返回Map类型)
     */
    public static <K, T, A> Map<K, List<A>> listToGroup(List<T> list, Function<T, K> function, Supplier mapFactory, Function<T, A> taFunction) {
        return listToGroup(list, function, mapFactory, Collectors.mapping(taFunction, Collectors.toList()));
    }

    /**
     * 通用类型分组
     *
     * @param list       目标集合
     * @param function   表达式
     * @param mapFactory 表达式
     * @param collector  表达式
     * @param <K>        key
     * @param <T>        实体类
     * @param <M>        参数
     * @return 分组结果
     */
    public static <K, T, M, D> Map<K, D> listToGroup(List<T> list, Function<T, K> function, Supplier<Map<K, D>> mapFactory, Collector<T, M, D> collector) {
        return list.stream().collect(Collectors.groupingBy(function, mapFactory, collector));
    }
}
