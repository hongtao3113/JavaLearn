package com.google.DesignPatterns.Singleton;

/**
 * @author wk
 * @Description:懒汉式
 * @date 2019/7/3 17:20
 **/
public class Singleton2 {

    //声明变量
    private static volatile Singleton2 instance = null;

    //私有构造方法
    private Singleton2() {

    }

    //提供对外方法
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
