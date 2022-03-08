package dataStructure;

/**
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/7 14:14
 */

public class TestLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int size = list.getSize();
        fun(list, size);
        System.out.println();
        // 删除节点
        delNode(list,5);

    }

    private static void delNode(SingleLinkedList<Integer> list, int delIndex) {
        int size;
        Integer remove = list.remove(delIndex);
        System.out.println();
        System.out.println("删除第"+(delIndex+1)+"个节点:" + remove);
        size = list.getSize();
        fun(list, size);
    }

    private static void fun(SingleLinkedList<Integer> list, int size) {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.print(list.get(size -1));
    }
}
