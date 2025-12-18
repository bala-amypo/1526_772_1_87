package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {

    List<ActivityLog> getLogs(Long userId, LocalDate start, LocalDate end);

}
