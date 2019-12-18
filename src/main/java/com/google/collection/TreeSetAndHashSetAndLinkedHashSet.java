package com.google.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author wk
 * @Description:
 * @date 2019/7/11 10:58
 **/
public class TreeSetAndHashSetAndLinkedHashSet {

    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("treeSet");
        //treeSet.add(null);
        System.out.println(treeSet.toString());

        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("hashSet");
        hashSet.add(null);
        System.out.println(hashSet.toString());

        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("linkedHashSet");
        linkedHashSet.add(null);
        System.out.println(linkedHashSet.toString());


    }
}
