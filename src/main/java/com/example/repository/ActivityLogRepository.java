package com.example.demo.repository;

import com.example.demo.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    // Must match entity field: createdAt
    List<ActivityLog> findByUserIdAndCreatedAtBetween(Long userId, LocalDate start, LocalDate end);
}
