package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.runnable.MyRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("/admin/v1/task")
public class DynamicTask {
    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler scheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(3);
        return scheduler;
    }

    @GetMapping("/start")
    public Body start() {
        future = scheduler.schedule(new MyRunnable(), new CronTrigger("0/1 * * * * *"));
        return Body.success();
    }

    @GetMapping("/stop")
    public Body stop() {
        if (future != null) {
            future.cancel(true);
        }
        return Body.success();
    }

    @GetMapping("/change")
    public Body change() {
        stop();
        future = scheduler.schedule(new MyRunnable(), new CronTrigger("0/3 * * * * *"));
        return Body.success();
    }
}
