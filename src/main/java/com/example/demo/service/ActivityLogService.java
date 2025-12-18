package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.ActivityLog;

public interface ActivityLogService {
    ActivityLog logActivity(Long userId, Long typeId, ActivityLog log);
    List<ActivityLog> getLogsByUser(Long userId);
    List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end);
    ActivityLog getLog(Long id);
}
