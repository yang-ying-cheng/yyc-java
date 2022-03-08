package dataStructure;

/**
 * java 实现单链表
 * @author 杨英承
 * @version 1.0.0
 * @date 2022/3/7 14:12
 */

public class SingleLinkedList<E> {
    /**
     * 头结点
     */
    private Node<E> headNode;
    /**
     * 尾结点
     */
    private Node<E> lastNode;
    /**
     * 链表的长度
     */
    private int size;

    /**
     * 无参构造方法
     */
    public SingleLinkedList() {
    }

    /**
     * 添加元素
     *
     * @param e 元素
     * @return true 添加成功，false 添加失败
     */
    public boolean add(E e) {

        if (headNode == null) {
            headNode = new Node<>(e);
            size++;
            return true;
        }
        Node<E> temp = headNode;
        // 如果头结点的下一个节点为空的话，直接添加
        while (temp.next != null) {
            temp = temp.next;
        }
        // 放置节点
        temp.next = new Node<>(e);
        size++;
        return true;
    }

    /**
     * 获取元素
     *
     * @param index 下标位置
     * @return 下标对应的元素值
     */
    public E get(int index) {
        int listIndex = 0;
        Node<E> temp = headNode;
        while (listIndex <= index) {
            // 如果下标位置跟索引处的位置一样的话，直接返回该节点
            if (listIndex == index) {
                // 如果 temp 为空的话，说明后面已经没有了
                if (temp == null) {
                    throw new IndexOutOfBoundsException("数组下标越界");
                }
                return temp.e;
            } else {
                // 否则接着往下找
                temp = temp.next;
                listIndex++;
            }
        }
        throw new IndexOutOfBoundsException("数组下标越界");
    }

    /**
     * 去除下标处的节点
     *
     * @param index 下标
     * @return 去除的节点
     */
    public E remove(int index) {
        // 如果是第一个位置，说明去除的是头结点，将第二个节点作为头结点
        if (index == 0) {
            Node<E> delNode = headNode;
            headNode = headNode.next;
            size--;
            return delNode.e;
        }
        Node<E> temp = headNode;
        int listIndex = 0;
        while (listIndex <= index) {
            if (temp == null) {
                throw new IndexOutOfBoundsException("数组下标越界");
            }
            if (listIndex == index - 1) {
                Node<E> delNode = temp.next;
                // 如果要删除的节点下标 +1 刚好等于链表的长度，说明删除的就是最后一个节点
                if (index + 1 != size) {
                    temp.next = temp.next.next;
                    size--;
                    return delNode.e;
                } else {
                    // 走到这里说明删除的是尾结点
                    temp.next = null;
                    size--;
                    return delNode.e;
                }
            } else {
                // 否则的话接着往下找
                temp = temp.next;
                listIndex++;
            }
        }
        throw new IndexOutOfBoundsException("数组下标越界");
    }

    /**
     * 获取链表的长度
     *
     * @return 返回链表的长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 节点
     *
     * @param <E> 类型
     */
    private static class Node<E> {
        E e;
        Node<E> next;

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, E next) {
            this.e = e;
            this.next = new Node<>(next);
        }
    }
}
