package com.google.alibaba;

/**
 * @author wk
 * @Description:
 * @date 2020/5/27 17:55
 **/
public class SwitchString {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
// a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
        Integer x = a * b;
        System.out.println(x);
        System.out.println();
        //报NPE
        Integer result = (flag ? a * b : c);
        System.out.println(result);
        method(null);
    }

    public static void method(String param) {
        switch (param) {
// 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
// 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
// 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
