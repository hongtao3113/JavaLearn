package com.google.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * @author wk
 * @Description:
 * @date 2019/7/11 11:42
 **/
public class HashMapAndHashtable {

    public static void main(String[] args) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("age",123);
        /*hashMap.put(null,null);
        hashMap.put("重地","重地");
        hashMap.put("通话","通话");
        System.out.println(hashMap.toString());
        System.out.println(hashMap.get("通话"));*/

        //线程安全 不允许null键null值
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("name","公子羽");
        hashtable.put("name2","");
        System.out.println(hashtable.toString());

        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put("",null);
        treeMap.put("age",123);
        System.out.println(treeMap.toString());

        System.out.println(0x7FFFFFFF);
    }


}
