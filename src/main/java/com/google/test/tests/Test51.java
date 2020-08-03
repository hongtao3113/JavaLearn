package com.google.test.tests;

import com.google.test.ExampleA;
import com.google.test.ExampleB;

import java.util.Collections;

/**
 * @author wk
 * @Description:
 * @date 2020/1/29 17:34
 **/
public class Test51 {

    public static void main(String[] args) throws Exception {

        Object o = new Object();


        try {
            throw new ExampleB();
        } catch (ExampleA e) {
            System.out.println("ExampleA");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        //输出ExampleA


        try {
            try {
                throw new ExampleB();
            } catch (ExampleA a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (ExampleB s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
        //输出
//        Caught Annoyance
//        Caught Sneeze
//        Hello World!
    }
}