package com.kauan.service.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class TaskNotificationSchedule {

    private final TaskService taskService;

    public TaskNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 600)
    public void checkAndNotifyDueTasks() {
        this.taskService.sendNotificationForDueTasks();
    }
}
