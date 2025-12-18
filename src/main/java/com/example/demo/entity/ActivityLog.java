package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private LocalDate activityDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    @Column(nullable = false)
    private Double estimatedEmission;

    @PrePersist
    protected void onCreate() {
        this.loggedAt = LocalDateTime.now();

        // auto-calculate emission
        // factorValue assumed to be inside ActivityType
        this.estimatedEmission = this.quantity * this.activityType.getFactorValue();
    }

    public ActivityLog() {}

    // getters & setters
    public Long getId() {
        return id;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public Double getEstimatedEmission() {
        return estimatedEmission;
    }
}
