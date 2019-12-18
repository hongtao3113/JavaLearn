package com.google.DesignPatterns.Observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author wk
 * @Description:
 * @date 2019/7/4 17:19
 * 接口和抽象类的区别，抽象类实现接口，不需要强制实现方法？
 **/
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()) {
            enumo.nextElement().update();
        }
    }
}