package com.google.collection;

import java.util.*;

/**
 * ArrayList、Vector、LinkedList的区别
 *
 * @author wk
 */
@SuppressWarnings("unused")
public class ArrayListAndLinkedListAndVector {

    public static void main(String[] args) {
        //基于数组 Object[] Vector线程安全
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("arrayList");

        Vector<Object> vector = new Vector<>();
        vector.add("vector");

        //基于链表
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("linkedList");
        System.out.println(arrayList.toString());
        System.out.println(vector.toString());
        System.out.println(linkedList.toString());


        //本质上是数组与链表的区别，是否线程安全
        HashMap<Object, Object> hashMap = new HashMap<>();

        Set set = new HashSet();
        set.add("set");
        set.add("set");
        set.add("set2");
        System.out.println(set.toString());
    }

}
