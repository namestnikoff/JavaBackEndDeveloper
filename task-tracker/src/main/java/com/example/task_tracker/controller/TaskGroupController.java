package com.example.task_tracker.controller;

import com.example.task_tracker.dto.TaskGroupDTO;
import com.example.task_tracker.service.TaskGroupService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class TaskGroupController {
    private final TaskGroupService groupService;
    
    public TaskGroupController(TaskGroupService groupService) {
        this.groupService = groupService;
    }
    
    @GetMapping
    public List<TaskGroupDTO> getAllGroups() {
        return groupService.getAllGroups();
    }
    
    @PostMapping
    public TaskGroupDTO createGroup(@RequestBody TaskGroupDTO groupDTO) {
        return groupService.createGroup(groupDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
