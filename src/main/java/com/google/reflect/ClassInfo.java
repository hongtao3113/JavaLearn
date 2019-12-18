package com.google.reflect;

import java.lang.reflect.Field;

/**
 * @author wk
 * @Description:
 * @date 2019/7/3 16:28
 **/
public class ClassInfo {

    public String name="123";

    public static void main(String[] args) {
        new ClassInfo().test();
    }

    public void test(){
        try {
            Class class1 = Class.forName("com.google.reflect.ClassInfo");
            Class<? extends ClassInfo> class2 = this.getClass();
            System.out.println(class1==class2);
            Class<ClassInfo> class3 = ClassInfo.class;
            System.out.println(class2==class3);
            System.out.println(class1);
            Field field = class1.getField("name");
            System.out.println(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
