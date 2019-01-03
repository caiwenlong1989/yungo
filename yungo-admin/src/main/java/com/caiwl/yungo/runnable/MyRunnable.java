package com.caiwl.yungo.runnable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MyRunnable implements Runnable {
    AtomicInteger idx = new AtomicInteger(0);

    @Override
    public void run() {
        log.info("myTask worked. " + idx.incrementAndGet());
        if (idx.get() % 5 == 0) {
            try {
                if (Thread.interrupted()) {
                    Thread.sleep(3000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
