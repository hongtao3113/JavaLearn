package com.google.thread;

/**
 * 
 * @author wk
 *
 */
public class ThreadTest implements Runnable{
	
	public static void main(String[] args) {
		new Thread("t1").start();
		new Thread("t2").start();
		new Thread("t3").start();
	}

	@Override
	public void run() {
		System.out.println(Thread.class.getName()+"运行中");
	}
}
