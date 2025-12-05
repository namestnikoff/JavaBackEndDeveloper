package com.example.task_tracker.controller;

import com.example.task_tracker.dto.TaskDTO;
import com.example.task_tracker.service.TaskService;
import com.example.task_tracker.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }
    
    @GetMapping
    public List<TaskDTO> getUserTasks(Authentication auth) {
        var user = userService.findByEmail(auth.getName());
        return taskService.getUserTasks(user);
    }
    
    @PostMapping
    public TaskDTO createTask(Authentication auth, @RequestBody TaskDTO taskDTO) {
        var user = userService.findByEmail(auth.getName());
        return taskService.createTask(user, taskDTO);
    }
    
    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable Long id, Authentication auth, @RequestBody TaskDTO taskDTO) {
        var user = userService.findByEmail(auth.getName());
        return taskService.updateTask(id, user, taskDTO);
    }
}