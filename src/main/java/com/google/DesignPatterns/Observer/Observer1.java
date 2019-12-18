package com.google.DesignPatterns.Observer;

/**
 * @author wk
 * @Description:
 * @date 2019/7/4 17:14
 **/
public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("Observer1".concat(" has received"));
    }
}
