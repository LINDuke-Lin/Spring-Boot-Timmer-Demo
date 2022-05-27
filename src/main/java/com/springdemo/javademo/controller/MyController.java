package com.springdemo.javademo.controller;

import java.util.Timer;

import com.springdemo.javademo.tool.TimerTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/My")
public class MyController {

    @GetMapping("/sayHi")
    public String sayHi(String name) {
        Time();
        return "hi!" + name;
    }

    private void Time() {
        Timer timer = new Timer();
        long delay1 = 1 * 1000;
        long period1 = 1000;

        // 從現在開始 1 秒鐘之後，每隔 1 秒鐘執行一次 job1
        timer.schedule(new TimerTest("job1", new Runnable() {
            @Override
            public void run() {
                System.out.println("Just do it");
            }
        }), delay1, period1);

    }
}
