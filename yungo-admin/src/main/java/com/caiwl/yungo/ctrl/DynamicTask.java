package com.caiwl.yungo.ctrl;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.TaskConfig;
import com.caiwl.yungo.mapper.TaskConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("/admin/v1/task")
public class DynamicTask {
    @Autowired
    private TaskConfigMapper taskConfigMapper;

    @Autowired
    private ThreadPoolTaskScheduler scheduler;
    private ScheduledFuture<?> myRunFuture;
    private ScheduledFuture<?> yourRunFuture;

    @Bean
    public ThreadPoolTaskScheduler scheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(3);
        return scheduler;
    }

    @GetMapping("/start")
    public Body start(TaskCode taskCode) {
        doStart(taskCode);
        return Body.success();
    }

    @GetMapping("/stop")
    public Body stop(TaskCode taskCode) {
        doStop(taskCode);
        return Body.success();
    }

    @GetMapping("/change")
    public Body change(TaskCode taskCode) {
        doStop(taskCode);
        doStart(taskCode);
        return Body.success();
    }

    private enum TaskCode {
        MY, YOUR,
    }

    private void doStart(TaskCode taskCode) {
        TaskConfig taskConfig = taskConfigMapper.get(taskCode.name());
        String className = "com.caiwl.yungo.task." + taskConfig.getClazz();
        Runnable task;
        try {
            task = (Runnable) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("task class not found: " + className);
        }
        switch (taskCode) {
            case MY:
                myRunFuture = scheduler.scheduleWithFixedDelay(task, taskConfig.getFixedDelay());
                break;
            case YOUR:
                yourRunFuture = scheduler.scheduleWithFixedDelay(task, taskConfig.getFixedDelay());
                break;
            default:
                // do nothing
        }
    }

    private void doStop(TaskCode taskCode) {
        switch (taskCode) {
            case MY:
                if (myRunFuture != null) {
                    myRunFuture.cancel(true);
                }
                break;
            case YOUR:
                if (yourRunFuture != null) {
                    yourRunFuture.cancel(true);
                }
                break;
            default:
                // do nothing
        }
    }

}
