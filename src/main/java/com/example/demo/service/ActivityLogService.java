package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.util.List;

public interface ActivityLogService {

    ActivityLog createLog(ActivityLog log);

    ActivityLog getLog(Long id);

    List<ActivityLog> getAllLogs();
}
