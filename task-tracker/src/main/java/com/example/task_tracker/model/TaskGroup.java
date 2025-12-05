package com.example.task_tracker.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
    name = "task_groups",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_task_groups_name", columnNames = "name")
    }
)
public class TaskGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Р СњР В°Р В·Р Р†Р В°Р Р…Р С‘Р Вµ Р С–РЎР‚РЎС“Р С—Р С—РЎвЂ№ (Р Р…Р В°Р С—РЎР‚Р С‘Р СР ВµРЎР‚, "Р Р€РЎвЂЎРЎвЂР В±Р В°", "Р В Р В°Р В±Р С•РЎвЂљР В°", "Р вЂєР С‘РЎвЂЎР Р…Р С•Р Вµ")
    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    // Р С›Р В±РЎР‚Р В°РЎвЂљР Р…Р В°РЎРЏ РЎРѓР Р†РЎРЏР В·РЎРЉ: Р С•Р Т‘Р Р…Р В° Р С–РЎР‚РЎС“Р С—Р С—Р В° -> Р СР Р…Р С•Р С–Р С• Р В·Р В°Р Т‘Р В°РЎвЂЎ
    @OneToMany(
        mappedBy = "group",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    public TaskGroup() {
    }

    // Р С–Р ВµРЎвЂљРЎвЂљР ВµРЎР‚РЎвЂ№/РЎРѓР ВµРЎвЂљРЎвЂљР ВµРЎР‚РЎвЂ№

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

