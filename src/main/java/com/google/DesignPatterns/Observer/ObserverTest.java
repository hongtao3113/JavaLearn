package com.google.DesignPatterns.Observer;

/**
 * @author wk
 * @Description:观察者模式-测试类
 * @date 2019/7/4 17:05
 **/
public class ObserverTest {

    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        mySubject.add(new Observer1());
        mySubject.add(new Observer2());
        mySubject.operation();
    }
}
