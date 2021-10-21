package orgFolder;

import stream.StreamUtils;

import java.util.*;

/**
 * 练习生成组织树结构，目的：
 * 公司业务中有类似的表结构，没有存某一个组织的祖先节点，固看同事递归查询数据库，速度极慢，所以模拟实现一下不递归查询数据库的办法
 */
public class OrgMain {
    public static void main(String[] args) {
        // 模拟组织树结构
        List<Org> orgList = Arrays.asList(
                new Org(1, "A1", 100, 0),
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

        // 根据parentId 分组
        Map<Integer, List<Integer>> orgAndParentMap = StreamUtils.listToGroup(orgList, Org::getParentId, HashMap::new, Org::getId);
        Map<Integer, List<Integer>> orgParentAndChildren = findAllChildren(orgList, orgAndParentMap);
        System.out.println(orgParentAndChildren.toString());

    }

    public static List<Integer> findNextChildren(Integer node, Map<Integer, List<Integer>> orgAndParentMap) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = orgAndParentMap.getOrDefault(node, Collections.emptyList());
        result.addAll(list);
        for (Integer e : list) {
            List<Integer> nextChildren = findNextChildren(e, orgAndParentMap);
            result.addAll(nextChildren);
        }
        return result;
    }

    /**
     * 查询一个组织下的所有组织
     * @param orgList 组织列表
     * @param orgAndParentMap 以父组织为key的map
     * @return
     */
    public static Map<Integer, List<Integer>> findAllChildren(List<Org> orgList, Map<Integer, List<Integer>> orgAndParentMap) {
        Map<Integer, List<Integer>> orgAndChildrenMap = new HashMap<>();
        for (Org org : orgList) {
            List<Integer> children = findNextChildren(org.getId(), orgAndParentMap);
            orgAndChildrenMap.put(org.getId(), children);
        }
        return orgAndChildrenMap;
    }


}
