package dataStructure;

/**
 * 双向链表
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/7 16:37
 */

public class DoubleLinkedList<E> {
    /**
     * 节点
     * @param <E> 元素
     */
    private static class Node<E>{
        /**
         * 存数据
         */
        E data;
        /**
         * 下一个节点
         */
        Node<E> next;
        /**
         * 上一个节点
         */
        Node<E> prev;
    }

    /**
     * 链表的长度
     */
    private int size ;
}
