package com.google.DesignPatterns.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author wk
 * @Description:
 * @date 2019/7/3 17:26
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance().toString());
        System.out.println(Singleton2.getInstance().toString());
        Class<Singleton2> singleton2Class = Singleton2.class;
        try {
            //构造方法私有 会报错，NoSuchMethodException
            //Constructor<Singleton2> singleton2ClassConstructor = singleton2Class.getConstructor();

            //这种方式可以破解单例模式
            Constructor<Singleton2> declaredConstructor = singleton2Class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            System.out.println(declaredConstructor.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
