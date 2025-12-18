package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {
    ActivityLog logActivity(Long userId, Long activityTypeId, Double quantity, LocalDate date);
    List<ActivityLog> getUserLogs(Long userId);
}
