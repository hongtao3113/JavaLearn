package com.google.DesignPatterns.Singleton;

/**
 * @author wk
 * @Description:单例模式 饿汉式
 * @date 2019/7/3 17:16
 **/
public class Singleton1 {

    //直接创建对象
    public static Singleton1 instance = new Singleton1();

    //私有化构造函数
    private Singleton1() {

    }

    //返回实例对象
    public static Singleton1 getInstance() {
        return instance;
    }
}
