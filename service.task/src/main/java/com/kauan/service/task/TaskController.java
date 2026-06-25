package com.kauan.service.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public ResponseEntity<TasksEntity> createTask(@RequestBody TaskRequest task) {
        TasksEntity taskEntity = new TasksEntity(task);
        return ResponseEntity.ok(taskRepository.save(taskEntity));
    }

}
