package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl
        implements ActivityLogService {

    private final ActivityLogRepository repo;

    public ActivityLogServiceImpl(ActivityLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public ActivityLog createLog(ActivityLog log) {

        // quantity > 0
        if (log.getQuantity() <= 0) {
            return null;
        }

        // activityDate cannot be future
        if (log.getActivityDate().isAfter(LocalDate.now())) {
            return null;
        }

        return repo.save(log);
    }

    @Override
    public ActivityLog getLog(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ActivityLog> getAllLogs() {
        return repo.findAll();
    }
}
