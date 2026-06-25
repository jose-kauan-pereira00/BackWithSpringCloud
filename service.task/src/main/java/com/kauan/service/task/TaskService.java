package com.kauan.service.task;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private NotificationClient notificationClient;

    public TaskService(TaskRepository taskRepository, NotificationClient noticationClient) {
        this.taskRepository = taskRepository;
        this.notificationClient = noticationClient;
    }

    public void sendNotificationForDueTasks() {

        LocalDateTime deadLine = LocalDateTime.now().plusDays(1); 
        List<TasksEntity> dueTasks = taskRepository.findTasksDueWithinDeadline(deadLine);

        for (var task : dueTasks) {
            // Create a notification request
            var notificationRequest = new NotificationRequest("Task is due: " + task.toString(), task.getEmail());
          
    
            notificationClient.sendNotification(notificationRequest);
            task.setNotified(true);
            taskRepository.save(task);

        }
    }
}