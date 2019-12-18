package com.google.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @Description:自定义ArrayList
 * @date 2019/10/29 15:50
 **/
public class CustomArrayList<T> {

    private Object[] elementData;
    private int size = 0;

    public int size() {
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public CustomArrayList() {
    }

    public boolean add(T t) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public T get(int index) {
        return null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        System.out.println(list.size());
    }
}
