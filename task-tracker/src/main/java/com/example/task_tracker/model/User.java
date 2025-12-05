package com.example.task_tracker.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = "email")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Р СџР С•РЎвЂЎРЎвЂљР В° Р С‘РЎРѓР С—Р С•Р В»РЎРЉР В·РЎС“Р ВµРЎвЂљРЎРѓРЎРЏ Р С”Р В°Р С” Р В»Р С•Р С–Р С‘Р Р…
    @Column(nullable = false, length = 255)
    private String email;

    // Р ТђРЎР‚Р В°Р Р…Р С‘Р С РЎвЂљР С•Р В»РЎРЉР С”Р С• РЎвЂ¦Р ВµРЎв‚¬ Р С—Р В°РЎР‚Р С•Р В»РЎРЏ, Р В° Р Р…Р Вµ РЎРѓР В°Р С Р С—Р В°РЎР‚Р С•Р В»РЎРЉ
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserRole role = UserRole.USER;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    // Р СњР Вµ Р С•Р В±РЎРЏР В·Р В°РЎвЂљР ВµР В»РЎРЉР Р…Р С•, Р Р…Р С• РЎС“Р Т‘Р С•Р В±Р Р…Р С• Р С‘Р СР ВµРЎвЂљРЎРЉ РЎРѓР Р†РЎРЏР В·РЎРЉ "Р С—Р С•Р В»РЎРЉР В·Р С•Р Р†Р В°РЎвЂљР ВµР В»РЎРЉ -> Р ВµР С–Р С• Р В·Р В°Р Т‘Р В°РЎвЂЎР С‘"
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    // Р С–Р ВµРЎвЂљРЎвЂљР ВµРЎР‚РЎвЂ№/РЎРѓР ВµРЎвЂљРЎвЂљР ВµРЎР‚РЎвЂ№ Р Р…Р С‘Р В¶Р Вµ (Р СР С•Р В¶Р Р…Р С• РЎРѓР С–Р ВµР Р…Р ВµРЎР‚Р С‘РЎР‚Р С•Р Р†Р В°РЎвЂљРЎРЉ Р Р† IDE)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

