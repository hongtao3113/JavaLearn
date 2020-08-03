package com.google.alibaba;

/**
 * @author wk
 * @Description:
 * @date 2020/5/28 15:00
 **/
public class Test3 {

    public static void main(String[] args) throws Exception {
        method2();
    }

    private static void method1() throws Exception {
        System.out.println(1);
        throw new Exception();
    }

    private static void method2() throws Exception {
        try {
            method1();
        } catch (Exception e) {
            throw e;
        }
        System.out.println(2);
    }
}
