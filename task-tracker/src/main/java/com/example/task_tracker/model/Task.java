package com.example.task_tracker.model;

import jakarta.persistence.*;
import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Р С™РЎР‚Р В°РЎвЂљР С”Р С•Р Вµ Р Р…Р В°Р В·Р Р†Р В°Р Р…Р С‘Р Вµ Р В·Р В°Р Т‘Р В°РЎвЂЎР С‘
    @Column(nullable = false, length = 200)
    private String title;

    // Р СџР С•Р Т‘РЎР‚Р С•Р В±Р Р…Р С•Р Вµ Р С•Р С—Р С‘РЎРѓР В°Р Р…Р С‘Р Вµ
    @Column(length = 2000)
    private String description;

    // Р РЋРЎвЂљР В°РЎвЂљРЎС“РЎРѓ Р В·Р В°Р Т‘Р В°РЎвЂЎР С‘
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskStatus status = TaskStatus.PLANNED;

    // Р вЂ™Р В»Р В°Р Т‘Р ВµР В»Р ВµРЎвЂ  Р В·Р В°Р Т‘Р В°РЎвЂЎР С‘ (Р С—Р С•Р В»РЎРЉР В·Р С•Р Р†Р В°РЎвЂљР ВµР В»РЎРЉ)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        foreignKey = @ForeignKey(name = "fk_tasks_user_id")
    )
    private User user;

    // Р вЂњРЎР‚РЎС“Р С—Р С—Р В° Р В·Р В°Р Т‘Р В°РЎвЂЎ (Р СР С•Р В¶Р ВµРЎвЂљ Р В±РЎвЂ№РЎвЂљРЎРЉ null, Р ВµРЎРѓР В»Р С‘ Р В·Р В°Р Т‘Р В°РЎвЂЎР В° Р В±Р ВµР В· Р С–РЎР‚РЎС“Р С—Р С—РЎвЂ№)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "group_id",
        foreignKey = @ForeignKey(name = "fk_tasks_group_id")
    )
    private TaskGroup group;

    // Р С™Р С•Р С–Р Т‘Р В° РЎРѓР С•Р В·Р Т‘Р В°Р Р…Р В°
    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    // Р С™Р С•Р С–Р Т‘Р В° Р С—Р С•РЎРѓР В»Р ВµР Т‘Р Р…Р С‘Р в„– РЎР‚Р В°Р В· Р С•Р В±Р Р…Р С•Р Р†Р В»Р ВµР Р…Р В°
    @Column(nullable = false)
    private Instant updatedAt = Instant.now();

    // Р вЂќР В»РЎРЏ Р С•Р С—РЎвЂљР С‘Р СР С‘РЎРѓРЎвЂљР С‘РЎвЂЎР ВµРЎРѓР С”Р С•Р в„– Р В±Р В»Р С•Р С”Р С‘РЎР‚Р С•Р Р†Р С”Р С‘ (Р Р…Р В° Р В±РЎС“Р Т‘РЎС“РЎвЂ°Р ВµР Вµ, Р С—РЎР‚Р С‘Р С–Р С•Р Т‘Р С‘РЎвЂљРЎРѓРЎРЏ Р Т‘Р В»РЎРЏ REST)
    @Version
    private Long version;

    public Task() {
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    // Р С–Р ВµРЎвЂљРЎвЂљР ВµРЎР‚РЎвЂ№/РЎРѓР ВµРЎвЂљРЎвЂљР ВµРЎР‚РЎвЂ№

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskGroup getGroup() {
        return group;
    }

    public void setGroup(TaskGroup group) {
        this.group = group;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

