package com.google.DesignPatterns.Observer;

/**
 * @author wk
 * @Description:
 * @date 2019/7/4 17:27
 **/
public class MySubject extends AbstractSubject{

    @Override
    public void operation() {
        System.out.println("update myself");
        notifyObservers();
    }
}
