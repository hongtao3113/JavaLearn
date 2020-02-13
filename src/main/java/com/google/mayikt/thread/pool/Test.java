package com.google.mayikt.thread.pool;

//并发包
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wk
 * @Description: executor 英 [ɪɡˈzekjətə(r)]
 * @date 2020/2/13 23:04
 **/
public class Test {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        //（不会使用这种方式）
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " <Runnable>");
            }
        });

        //创建一个线程池，多个线程
        //运行结果可以发现，线程存在复用。（不会使用这种方式）
        for (int i = 0; i < 10; i++) {
            final int finali = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " <线程任务>" + finali);
                }
            });
        }

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int finali = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " <newFixedThreadPool线程任务>" + finali);
                }
            });
        }

        newFixedThreadPool.shutdown();
        executorService.shutdown();
    }
}
