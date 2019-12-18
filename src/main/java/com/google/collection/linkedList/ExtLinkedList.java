package com.google.collection.linkedList;

/**
 * @author wk
 * @Description:手写LinkedList
 * @date 2019/9/5 14:28
 **/
public class ExtLinkedList<E> {

    //链表实际大小
    private int size;

    //第一个元素（头节点 查询开始）
    private Node first;

    //第二个元素（尾结点 为添加开始）
    private Node last;

    /**
     * 节点
     */
    class Node {
        Node prev;//上一个节点
        Node next;//下一个节点
        Object object;//存放元素的值
    }

    public void add(E e) {
        Node node = new Node();
        node.object = e;
        if (first == null) {
            //添加第一个元素,首尾节点均为该元素
            first = node;
        } else {
            //添加第二个元素及以上
            //添加第二个元素的时候，此时first == last
            node.prev = last;
            last.next = node;
        }
        last = node;
        size++;
    }

    /**
     * 删除指定小标的元素
     * @param index
     */
    public void remove(int index) {
        checkElementIndex(index);
        // 1.先获取当前删除Node节点
        ExtLinkedList<E>.Node oldNode = getNode(index);
        if (oldNode != null) {
            // 2.获取删除元素的上下节点
            // node3
            ExtLinkedList<E>.Node oldNextNode = oldNode.next;
            // node1
            ExtLinkedList<E>.Node oldPrevNode = oldNode.prev;
            // 将node1 的下一个节点变为node3
            if (oldPrevNode == null) {
                // 删除一个元素 从换换头
                first = oldNextNode;
            } else {
                oldPrevNode.next = oldNextNode;
                oldNode.prev = null;
            }

            // 将node3的上一个节点变为node1
            if (oldNextNode == null) {
                last = oldPrevNode;
            } else {
                oldNextNode.prev = oldPrevNode;
                oldNode.next = null;
            }
            oldNode.object = null;// 让垃圾回收机制回收
            size--;
        }
    }

    public Node getNode(int index) {
        // 下标的验证
        checkElementIndex(index);
        Node node = null;
        if (first != null) {
            node = first;// 默认取第0个
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    /**
     * 获取指定下标的元素
     * @param index
     * @return
     */
    public Object get(int index) {
        checkElementIndex(index);
        Node node = null;
        if (first != null) {
            node = first;//默认取第0个
            //查询方法可以更换，这个效率较低
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node.object;
    }

    /**
     * 校验是否越界
     * @param index
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        StringBuffer sbf = new StringBuffer("Index: ");
        sbf.append(index);
        sbf.append(", Size: ");
        sbf.append(size);
        return sbf.toString();
    }

    public static void main(String[] args) {
        ExtLinkedList<Object> list = new ExtLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.first.object);
        System.out.println(list.first.next.object);
        System.out.println(list.first.next.next.object);
        System.out.println(list.last.prev.prev.object);
        System.out.println("get方法："+list.get(0));

        list.remove(0);
        System.out.println("删除了一个元素 "+list.get(0));
    }
}
