package com.google.test;

/**
 * @author wk
 * @Description:
 * @date 2019/7/8 18:38
 **/
public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println("In run");
        yield();//暂停当前正在执行的线程对象，并执行其他线程。
        System.out.println("Leaving run");
    }
    public static void main(String []argv) {
        (new ThreadTest()).start();
    }
}
