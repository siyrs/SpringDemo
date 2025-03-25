package vip.sirius.spring.service;

import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BackgroundTaskService implements CommandLineRunner {
    private volatile boolean isRunning = true;

    @Resource
    private ActionService actionService;

    @Override
    public void run(String... args) {
        new Thread(this::executeContinuousTask).start();
    }

    private void executeContinuousTask() {
        while (isRunning) {
            try {
                log.info("执行任务中...");


                actionService.getNextAction();

                Thread.sleep(3000); // 任务逻辑替换点
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("任务中断", e);
                isRunning = false;
            }
        }
    }

    @PreDestroy
    public void stopTask() {
        isRunning = false;
        log.info("后台任务已停止");
    }
}
