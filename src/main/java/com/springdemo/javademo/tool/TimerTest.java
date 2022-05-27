package com.springdemo.javademo.tool;

import java.util.TimerTask;
import java.util.concurrent.ForkJoinPool;

public class TimerTest extends TimerTask {
    private final String jobName;
    private Runnable runnable;

    public TimerTest(String job, Runnable runnable) {
        jobName = job;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        System.out.println(jobName + "GoGo");

        ForkJoinPool.commonPool().execute(() -> {
            runnable.run();
        });
    }

}
