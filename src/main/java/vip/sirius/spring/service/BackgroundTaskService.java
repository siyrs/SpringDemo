package vip.sirius.spring.service;

import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class BackgroundTaskService implements CommandLineRunner {
    private volatile boolean isRunning = true;
    private static final Logger logger = LoggerFactory.getLogger(BackgroundTaskService.class);

    @Resource
    private ActionService actionService;

    @Override
    public void run(String... args) {
        new Thread(this::executeContinuousTask).start();
    }

    private void executeContinuousTask() {
        while (isRunning) {
            try {
                logger.info("执行任务中...");


                actionService.getNextAction();

                Thread.sleep(3000); // 任务逻辑替换点
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("任务中断", e);
                isRunning = false;
            }
        }
    }

    @PreDestroy
    public void stopTask() {
        isRunning = false;
        logger.info("后台任务已停止");
    }
}
