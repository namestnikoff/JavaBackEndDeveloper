package com.example.task_tracker.repository;

import com.example.task_tracker.model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {
}

