package com.google.alibaba;

import java.util.*;

/**
 * @author wk
 * @Description:
 * @date 2020/5/27 14:50
 **/
public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
    /*    Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }*/
        //Exception in thread "main" java.util.ConcurrentModificationException
       /* for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }*/
        Arrays.asList(list).forEach(System.out::println);

        Map<Object, Object> map = new HashMap<>(16);
        for (int i = 1; i < 20; i++) {
            map.put(i, i);
        }
        Arrays.asList(map).forEach(System.out::println);
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
    }
}
