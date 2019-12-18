package com.google.test;

import com.google.DesignPatterns.Observer.Observer;

/**
 * @author wk
 * @Description:牛客测试
 * @date 2019/7/8 14:26
 **/
public class TestNowCoder {

    public static void main(String[] args) {
        double v = -5 + 1 / 4 + 2 * -3 + 5.0;
        System.out.println(v);//-6.0
        System.out.println(1/4);//=0
        Object o = new Integer(1);//1
        System.out.println(o);

        Object o1 = true ? new Integer(1) : new Double(2.0);//o1为什么是1.0 三元运算符必须保证类型一致 不一致会自动进行类型提升
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);
    }
}
