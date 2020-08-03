package com.google.alibaba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wk
 * @Description:
 * @date 2020/5/26 18:19
 **/
public class Test {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
// 预期大于 3，结果是 3
        System.out.println(ary.length);
        Arrays.asList(ary).stream().forEach(System.out::println);
        int i = LocalDate.now().lengthOfYear();
        System.out.println(i);
        List<Object> list = new ArrayList<>();
        if (list != null && list.isEmpty()&&list.size()>0) {

        }
        List<String> list2 = new ArrayList<>(2);
        list2.add("guan");
        list2.add("bao");
        String[] array = list2.toArray(new String[0]);
        Arrays.asList(array).stream().forEach(System.out::print);
    }
}
