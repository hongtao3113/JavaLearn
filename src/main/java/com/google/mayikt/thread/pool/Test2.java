package com.google.mayikt.thread.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wk
 * @Description:
 * @date 2020/2/14 0:03
 **/
public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue blockingQueue = new LinkedBlockingQueue(2);//容量设置为2
        //如何把业务任务存放到队列中？

        blockingQueue.offer("libai");
        blockingQueue.offer("dufu");
        boolean wk = blockingQueue.offer("wk");
        System.out.println(wk);//输出false，因为队列的最大值为2

        Object poll = blockingQueue.poll();
        Object poll2 = blockingQueue.poll();
        System.out.println(poll);
        System.out.println(poll2);
        Object poll3 = blockingQueue.poll(2, TimeUnit.SECONDS);
        System.out.println(poll3);//过两秒，输出Null


    }
}
