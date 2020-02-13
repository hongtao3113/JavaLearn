package com.google.mayikt.thread.pool.ext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wk
 * @Description:纯手写线程池基本实现01
 * @date 2020/2/14 0:16
 **/
public class MayiktExecutorService {

    private List<Thread> workingThreads;

    private BlockingQueue<Runnable> taskRunnable;

    private volatile Boolean isWorking = true;//volatile为什么要加这个关键字

    public MayiktExecutorService(int num, int taskRunnable) {

        this.taskRunnable = new LinkedBlockingQueue<>(taskRunnable);//初始化队列容量大小
        this.workingThreads = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            this.workingThreads.add(workThread);
        }
    }

    public boolean execute(Runnable runnable) {
        return this.taskRunnable.offer(runnable);
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (isWorking || taskRunnable.size() > 0) {
                Runnable task = taskRunnable.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }

    public void shutdown() {
        this.isWorking = false;
    }


    public static void main(String[] args) {

        MayiktExecutorService mayiktExecutorService = new MayiktExecutorService(3, 6);
        for (int i = 0; i < 15; i++) {
            final int m = i;
            mayiktExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "任务" + m + "开始执行");
                }
            });
        }

        //停止线程
        mayiktExecutorService.shutdown();

        //考虑空闲的问题
    }
}


