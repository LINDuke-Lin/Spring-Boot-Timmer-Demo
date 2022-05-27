# Spring Boot Timmer Demo

### 1. TimerTask

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