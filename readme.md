# Spring Boot Timmer Demo

## 1. TimerTask

- 繼承 TimerTask

```java
public class TimerTest extends TimerTask 
```

- 複寫run

```java
@Override
    public void run() {
       //TODO: Something
    }
```

- 由建構子帶入`Runnable` and `jobName`

```java
    private final String jobName;
    private Runnable runnable;

    public TimerTest(String job, Runnable runnable) {
        jobName = job;
        this.runnable = runnable;
    }
```

- 使用`ForkJoinPool`啟用執行續，並執行`Runnable`

```java
 ForkJoinPool.commonPool().execute(() -> {
            runnable.run();
        });
```


# 使用方式:

## 需求:
- 每天中午12:00與晚上0:00，啟動定時器，提醒大家又過半天了



### 建立TimeWatcherService

- 主程式 `Start`
1. 將時間歸零，並從明日開始`SetTime()`
   
```java
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
```
2. 設定定時器

```java
    // 設定定時器
    Timer timer = new Timer();
```
3. 取得時間間格`halfOfTheDay()`

```java
    /**
     * 取得12小時的毫秒
     * 公式 : 12小時 X 60分鐘 X 60秒 X 1000
     * 
     * @return 12小時 -> 毫秒
     */
    private long halfOfTheDay() {
        return 12 * 60 * 60 * 1000;
    }
```
4. 啟用定時器

```java
        // 從現在開始 1 秒鐘之後，每隔 1 秒鐘執行一次 job1
        timer.schedule(new TimerTest("good job", new Runnable() {
            @Override
            public void run() {
                System.out.println("又過半天了勒");
            }
        }), calendar.getTime(), period);
```