package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.util.List;

public interface ActivityLogService {

    // Create a new activity log
    ActivityLog createLog(ActivityLog log);

    // Get a single log by ID
    ActivityLog getLog(Long id);

    // Get all activity logs
    List<ActivityLog> getAllLogs();
}
