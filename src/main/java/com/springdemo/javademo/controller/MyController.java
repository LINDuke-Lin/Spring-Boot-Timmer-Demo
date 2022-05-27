package com.springdemo.javademo.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.springdemo.javademo.service.ServiceImp.TimeWatcherServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/My")
public class MyController {

    private final TimeWatcherServiceImp timeWatcher;

    @Autowired
    public MyController(TimeWatcherServiceImp timeWatcher) {
        this.timeWatcher = timeWatcher;
    }

    @GetMapping("/sayHi")
    public String sayHi(String name) {
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Taipei")) + " Api Start ....");
        // 啟動定時器
        timeWatcher.Start();
        return "hi!" + name;
    }

}
