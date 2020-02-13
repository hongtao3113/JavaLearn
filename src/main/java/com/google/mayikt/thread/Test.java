package com.google.mayikt.thread;

/**
 * @author wk
 * @Description:
 * @date 2020/2/13 21:12
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());//输出main
        Thread thread = new Thread(new UserThread());
        thread.start();

        new UserThread().print();//输出main

    }


}

class UserThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"，任务1");
    }

    public void print() {
        System.out.println(Thread.currentThread().getName());
    }

}
