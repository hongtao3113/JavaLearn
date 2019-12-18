package com.google.base.object;

import java.io.Serializable;

/**
 * 克隆方式有哪几种
 */
public class ObjectClone {

    public static void main(String[] args) {

    }
}

class Cat implements Cloneable,Serializable{
    private String name="cat king";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}