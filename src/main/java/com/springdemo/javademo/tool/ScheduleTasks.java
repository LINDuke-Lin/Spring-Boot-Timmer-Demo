package com.springdemo.javademo.tool;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

    private final String cronCom = "10,20,30 * * * * ?";

    @Scheduled(cron = cronCom) // cron接受cron表示式，根據cron表示式確定定時規則
    public void testCron() {
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Taipei")) + "HI");
    }
}
