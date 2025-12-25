package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;

    private LocalDate activityDate;

    private LocalDateTime loggedAt;

    private Double estimatedEmission;

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }
}
