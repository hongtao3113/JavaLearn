package com.google.reflect;

import com.google.reflect.pojo.Person;

/**
 * @author wk
 * @Description:反射机制练习
 * @date 2019/11/28 16:36
 **/
public class ReflectTest {

    public static void main(String[] args) {

        try {
            Class<?> personClass1 = Class.forName("com.google.reflect.pojo.Person");
            Class<Person> personClass2 = Person.class;
            System.out.println(personClass1);
            Object object1 = personClass1.newInstance();
            //获取无参数构造方法、有参构造方法
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
