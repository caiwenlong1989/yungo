package com.caiwl.yungo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MyTask {
    AtomicInteger idx = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000)
    public void work() {
        log.info("myTask worked. " + idx.incrementAndGet());
        if (idx.get() % 5 == 0) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
