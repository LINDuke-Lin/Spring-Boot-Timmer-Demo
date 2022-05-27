package com.springdemo.javademo.service;

import java.util.Calendar;
import java.util.Timer;

import com.springdemo.javademo.service.ServiceImp.TimeWatcherServiceImp;
import com.springdemo.javademo.tool.TimerTest;

import org.springframework.stereotype.Service;

@Service
public class TimeWatcherService implements TimeWatcherServiceImp {
    /**
     * 取得12小時的毫秒
     * 公式 : 12小時 X 60分鐘 X 60秒 X 1000
     * 
     * @return 12小時 -> 毫秒
     */
    private long halfOfTheDay() {
        return 12 * 60 * 60 * 1000;
    }

    /**
     * 將時間歸零，並從明天開始
     * 
     * @return 歸零後的時間
     */
    private Calendar SetTime() {
        // 1. 設定時間
        Calendar calendar = Calendar.getInstance();
        // 1-1 從明天0點開始
        calendar.add(Calendar.DATE, 1);
        // 1-2 歸零年月日
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    /**
     * 啟動定時器，每天12點與0點觸發api
     */
    public void Start() {

        // 1. 設定時間
        Calendar calendar = SetTime();

        // 設定定時器
        Timer timer = new Timer();

        // 設定執行時間間隔 (12 小時)
        long period = halfOfTheDay();

        // 從現在開始 1 秒鐘之後，每隔 1 秒鐘執行一次 job1
        timer.schedule(new TimerTest("good job", new Runnable() {
            @Override
            public void run() {
                System.out.println("又過半天了勒");
            }
        }), calendar.getTime(), period);
    }

}
