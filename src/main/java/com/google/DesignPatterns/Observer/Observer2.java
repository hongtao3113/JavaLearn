package com.google.DesignPatterns.Observer;

import org.omg.CORBA.Object;

/**
 * @author wk
 * @Description:
 * @date 2019/7/4 17:14
 **/
public class Observer2 implements Observer{

    @Override
    public void update() {
        System.out.println("Observer2".concat(" has received"));
    }
}
