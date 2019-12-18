package com.google.reflect.pojo;

/**
 * @author wk
 * @Description:
 * @date 2019/11/28 16:29
 **/
public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("创建了对象");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
