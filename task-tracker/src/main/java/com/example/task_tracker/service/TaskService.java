package com.example.task_tracker.service;

import com.example.task_tracker.dto.TaskDTO;
import com.example.task_tracker.model.Task;
import com.example.task_tracker.model.TaskGroup;
import com.example.task_tracker.model.TaskStatus;
import com.example.task_tracker.model.User;
import com.example.task_tracker.repository.TaskRepository;
import com.example.task_tracker.repository.TaskGroupRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskGroupRepository groupRepository;
    
    public TaskService(TaskRepository taskRepository, TaskGroupRepository groupRepository) {
        this.taskRepository = taskRepository;
        this.groupRepository = groupRepository;
    }
    
    public List<TaskDTO> getUserTasks(User user) {
        return taskRepository.findByUserId(user.getId()).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    public TaskDTO createTask(User user, TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus() != null ? dto.getStatus() : TaskStatus.PLANNED);
        task.setUser(user);
        
        if (dto.getGroupId() != null) {
            TaskGroup group = groupRepository.findById(dto.getGroupId())
                    .orElseThrow(() -> new RuntimeException("Group not found"));
            task.setGroup(group);
        }
        
        return toDTO(taskRepository.save(task));
    }
    
    public TaskDTO updateTask(Long taskId, User user, TaskDTO dto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Access denied");
        }
        
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        
        if (dto.getGroupId() != null) {
            TaskGroup group = groupRepository.findById(dto.getGroupId())
                    .orElseThrow(() -> new RuntimeException("Group not found"));
            task.setGroup(group);
        }
        
        return toDTO(taskRepository.save(task));
    }
    
    public void deleteTask(Long taskId, User user) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        
        if (!task.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Access denied");
        }
        
        taskRepository.delete(task);
    }
    
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    private TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getGroup() != null ? task.getGroup().getId() : null
        );
    }
}
