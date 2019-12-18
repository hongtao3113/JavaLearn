package com.google.collection.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author wk
 * @Description:
 * @date 2019/9/5 11:58
 **/
public class Test {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0,1);
        list.add(0,2);
        System.out.println(list);
        System.out.println(list.get(1));
        LinkedList<Object> objects = new LinkedList<>();
        try {
            objects.remove(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            objects.add(0,2);
        }
        System.out.println(objects.get(0));
        System.out.println(objects);
        objects.remove(0);
    }
}
