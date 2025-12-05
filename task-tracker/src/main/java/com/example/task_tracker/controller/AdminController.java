package com.example.task_tracker.controller;

import com.example.task_tracker.dto.TaskDTO;
import com.example.task_tracker.model.User;
import com.example.task_tracker.model.UserRole;
import com.example.task_tracker.repository.TaskRepository;
import com.example.task_tracker.repository.UserRepository;
import com.example.task_tracker.service.TaskService;
import com.example.task_tracker.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;
    private final TaskService taskService;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    
    public AdminController(UserService userService, TaskService taskService, 
                          TaskRepository taskRepository, UserRepository userRepository) {
        this.userService = userService;
        this.taskService = taskService;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/tasks")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @GetMapping("/stats")
    public Map<String, Long> getTaskStats() {
        List<Object[]> results = taskRepository.countTasksByStatus();
        Map<String, Long> stats = new HashMap<>();
        for (Object[] row : results) {
            stats.put(row[0].toString(), (Long) row[1]);
        }
        return stats;
    }
    
    @PostMapping("/promote/{userId}")
    public Map<String, String> promoteToAdmin(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(UserRole.ADMIN);
        userRepository.save(user);
        return Map.of("message", "User promoted to ADMIN");
    }
}