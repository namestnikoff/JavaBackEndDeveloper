package com.example.task_tracker.service;

import com.example.task_tracker.dto.TaskGroupDTO;
import com.example.task_tracker.model.TaskGroup;
import com.example.task_tracker.repository.TaskGroupRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {
    private final TaskGroupRepository groupRepository;
    
    public TaskGroupService(TaskGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    
    public List<TaskGroupDTO> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    public TaskGroupDTO createGroup(TaskGroupDTO dto) {
        TaskGroup group = new TaskGroup();
        group.setName(dto.getName());
        group.setDescription(dto.getDescription());
        return toDTO(groupRepository.save(group));
    }
    
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
    
    private TaskGroupDTO toDTO(TaskGroup group) {
        return new TaskGroupDTO(group.getId(), group.getName(), group.getDescription());
    }
}
