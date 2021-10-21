package org;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 练习生成组织树结构，目的：
 * 公司业务中有类似的表结构，没有存某一个组织的祖先节点，固看同事递归查询数据库，速度极慢，所以模拟实现一下不递归查询数据库的办法
 */
public class OrgMain {
    public static void main(String[] args) {
        // 模拟组织树结构
        List<Org> orgList = Arrays.asList(
                new Org(1, "A1", 100, null),
                new Org(2, "A2", 200, 1),
                new Org(3, "A3", 300, 4),
                new Org(4, "A4", 400, 1),
                new Org(5, "A5", 500, 1),
                new Org(6, "A6", 600, 2),
                new Org(7, "A7", 700, 3),
                new Org(8, "A8", 800, 6),
                new Org(9, "A9", 900, 5),
                new Org(10, "A10", 1000, 6),
                new Org(11, "A11", 101, 10),
                new Org(12, "A12", 102, 11)
        );
        Map<Integer, Stream<String>> collect = orgList.stream().collect(Collectors.groupingBy(e -> e.getOrgCd(), Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().map(e -> e.getOrgName()))));


    }

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
    public static <K, T, A> Map<K, List<A>> listToGroup(List<T> list, Function<T, K> function, Supplier<Map<K, List<A>>> mapFactory, Function<T, A> taFunction) {
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
